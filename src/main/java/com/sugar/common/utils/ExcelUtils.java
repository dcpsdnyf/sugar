package com.sugar.common.utils;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.util.StringUtils;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ExcelUtils {
	// 读取两种格式的Excel内容
	/**
	 * @description: 读取两种格式的Excel
	 * @param stream
	 *            输入流
	 * @param extString
	 *            excel后缀
	 * @param columns
	 *            列名称
	 * @author: baipengfei
	 * @since: 2018年3月21日 下午12:01:44
	 */
	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"; // 时间格式类型
	public static List<Map<String, String>> readExcelByStream(InputStream stream, String extString, String[] columns,
			Integer rows) throws Exception {
		Workbook wb = getExcelWb(stream, extString);
		List<Map<String, String>> list = null;
		String cellData = null;
		if (wb != null) {
			// 获取第一个sheet
			Sheet sheet = wb.getSheetAt(0);
			// 获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			if (rownum <= rows) {
				return Collections.emptyList();
			}
			// 用来存放表中数据
			list = new ArrayList<Map<String, String>>();
			// 获取第一行数据
			Row row = sheet.getRow(rows);
			// 获取最大列数
			int column = row.getPhysicalNumberOfCells();
			column = column > columns.length ? columns.length : column;
			for (int i = rows; i < rownum; i++) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				row = sheet.getRow(i);
				if (row == null) {
					break;
				}
				if (StringUtils.isEmpty(String.valueOf(getValue(row.getCell(0))))) {
					break;
				}
				for (int j = 0; j < column; j++) {
					cellData = String.valueOf(getValue(row.getCell(j)));
					map.put(columns[j], cellData);
				}
				list.add(map);
			}

		}
		return list;
	}

	// 获取Workbook对象
	private static Workbook getExcelWb(InputStream stream, String extString) throws Exception {
		Workbook wb = null;
		if (stream == null) {
			return null;
		}

		if (".xls".equals(extString)) {
			return new HSSFWorkbook(stream);
		} else if (".xlsx".equals(extString)) {
			return new XSSFWorkbook(stream);
		} else {
			return null;
		}

	}

//	// 获取单元格值
//	private static Object getCellFor(Cell cell) {
//		Object cellValue = null;
//		if (cell != null) {
//			switch (cell.getCellType()) {
//			case Cell.CELL_TYPE_NUMERIC: {
//				cellValue = String.valueOf(cell.getNumericCellValue());
//				break;
//			}
//			case Cell.CELL_TYPE_FORMULA: {
//				if (DateUtil.isCellDateFormatted(cell)) {
//					cellValue = cell.getDateCellValue();
//				} else {
//					cellValue = String.valueOf(cell.getNumericCellValue());
//				}
//				break;
//			}
//
//			case Cell.CELL_TYPE_STRING: {
//				cellValue = cell.getRichStringCellValue();
//				break;
//			}
//
//			default:
//				cellValue = "";
//
//			}
//		} else {
//			cellValue = "";
//		}
//		return cellValue;
//	}
	/**
	 * 获取表格单元格数据
	 */
	private static String getValue(Cell cell) {
		// 空白或空
		if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK ) {
			return "";
		}
		// 0. 数字 类型
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				DateFormat df = new SimpleDateFormat(DATE_FORMAT);
				return df.format(date);
			}
			cell.setCellType(Cell.CELL_TYPE_STRING);
			String val = cell.getStringCellValue()+"";
			val = val.toUpperCase();
			if (val.contains("E")) {
				val = val.split("E")[0].replace(".", "");
			}
			return val;
		}
		// 1. String类型
		if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
			String val = cell.getStringCellValue();
			if (val == null || val.trim().length() == 0) {
				return "";
			}
			return val.trim();
		}
		// 2. 公式 CELL_TYPE_FORMULA
		if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
			String value="";
			try {
				value = String.valueOf(cell.getNumericCellValue());
			} catch (IllegalStateException e) {
				return cell.getCellFormula();
			}
			return value;
		}
		// 4. 布尔值 CELL_TYPE_BOOLEAN
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return cell.getBooleanCellValue()+"";
		}
		// 5. 错误 CELL_TYPE_ERROR
		return "";
	}







	/**
	 * 
	 * @param stream
	 * @param extString
	 * @param columns
	 * @param length
	 *            总共导入多少个字段
	 * @param type
	 *            导入类型
	 * @param rows
	 *            从第几行开始读
	 * @return
	 * @throws Exception
	 */
	public static List<Map<String, String>> readExcelByStream(InputStream stream, String extString, String[] columns,
			Integer length, String type, Integer rows) throws Exception {
		Workbook wb = getExcelWb(stream, extString);
		List<Map<String, String>> list = null;
		String cellData = null;
		if (wb != null) {
			// 用来存放表中数据
			list = new ArrayList<Map<String, String>>();
			// 获取第一个sheet
			Sheet sheet = wb.getSheetAt(0);
			// 获取最大行数
			int rownum = sheet.getPhysicalNumberOfRows();
			// 获取第一行
			Row row = sheet.getRow(0);
			// 获取最大列数
			int column = row.getPhysicalNumberOfCells();
			for (int i = rows; i < rownum; i++) {// 从第几行开始获取数据
				Map<String, String> map = new LinkedHashMap<String, String>();
				row = sheet.getRow(i);
				if (isValidRow(row)) {
					for (int j = 0; j < column; j++) {
						cellData = String.valueOf(getValue(row.getCell(j)));
						map.put(columns[j], cellData);
					}
				} else {
					break;
				}
				map.put(columns[length], type);// 保存导入类型
				list.add(map);
			}

		}
		return list;
	}

	private static Boolean isValidRow(Row row) {
		boolean isValidRow = false;
		if (row == null) {
			return isValidRow;
		}
		if (StringUtils.hasText(String.valueOf(getValue(row.getCell(0))))) {
			return true;
		}
		return isValidRow;
	}
	
	/**
	 * 生成2007版本的excel文件
	 * @param titleList
	 * @param rowDataList
	 * @return
	 */
	public static XSSFWorkbook buildWorkBookForExport(List<String> titleList,List<List<String>> rowDataList) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
        //创建一个Excel表单,参数为sheet的名字
        XSSFSheet sheet = workbook.createSheet();

        //创建表头
        setTitle(workbook, sheet, titleList);

        if (rowDataList==null||rowDataList.size()<=0) {
			return workbook;
		}
        
        //新增数据行，并且设置单元格数据
        int rowNum = 1;
        for (List<String> rowData : rowDataList) {
        	XSSFRow row = sheet.createRow(rowNum);
        	
        	for (int i = 0; i < rowData.size(); i++) {
				String data=rowData.get(i);
				row.createCell(i).setCellValue(data);
			}
            rowNum++;
		}
        
        //设置自动列宽
        for (int i = 0; i < titleList.size(); i++) {
            sheet.autoSizeColumn(i);
            sheet.setColumnWidth(i,sheet.getColumnWidth(i)*17/10);
        }
        
        return workbook;
	}
	
	 /***
     * 设置表头
     * @param workbook
     * @param sheet
     */
    private static void setTitle(XSSFWorkbook workbook, XSSFSheet sheet,List<String> titleList){
        XSSFRow row = sheet.createRow(0);

        //设置为居中加粗
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        
        for (int i = 0; i < titleList.size(); i++) {
        	String title=titleList.get(i);
        	XSSFCell cell = row.createCell(i);
            cell.setCellValue(title);
            cell.setCellStyle(style);
		}
    }
	
}
