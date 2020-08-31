package com.sugar.common;

import com.sugar.common.exception.BusinessException;
import com.sugar.common.utils.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;


/**
 * BaseController
 * @author think
 */
public class AppBaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;
	@Autowired
	protected ServletContext servletContext;
	
	private Logger logger = LoggerFactory.getLogger(AppBaseController.class);
	
	public static final String CONTENTTYPE_HTML = "text/html";
	public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CHARTSET_UTF8 = "utf-8";
    
    public static final String NO_ADMIN_AUTH="admin/error/noAuth";
    
    public static final String ERROR_404="/common/404";
    public static final String ERROR_500="/common/500";
    
    

    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String getParam(String name){
    	return request.getParameter(name);
    }
    
    
    /**
     * 向HttpServletResponse输出文本
     * @param text 输出的字符串
     * @param contentType 类型
     * @param charset 编码
     */
    final public void outputText(HttpServletResponse response, String text, String contentType, String charset) {
    	response.setCharacterEncoding(charset);
        //指定内容类型
    	response.setContentType(contentType + ";charset=" + charset);
        //禁止缓存
    	response.setHeader("Pragma", "no-cache");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	OutputStream o = null;
        try {
        	byte[] content = text.getBytes(charset);
        	o = response.getOutputStream();
        	o.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
        	try {
        		if(o!=null){
        			o.close();
        		}
        		o = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    /**
     * 向客户端输出字符串，编码为UTF-8
     * @param text
     */
    final protected void outputString(HttpServletResponse response, String text){
    	logger.debug("输出Json : " + text);
    	this.outputText(response,text, CONTENTTYPE_JSON, CHARTSET_UTF8);
    }
    
    /**
     * 向客户端输出处理结果，格式为json
     * @param obj
     */
    final protected void output(HttpServletResponse response, Object obj){
    	//返回结果
        R rs = null;
        // 如果返回结果是Result
        if (obj instanceof R) {
            rs = (R) obj;
        }
        // 其它类型
        else {
            rs = R.success(obj);
        }
        
        String jsonString = JsonUtil.toJSONString(rs);
        this.outputString(response,jsonString);
    }
    
    
    /**
     * 向客户端返回结果
     */
    public static class R {
    	String msg;
        //是否处理成功
        boolean success;
        //数据
        Object data;

        private R(){
        }
        
        public static R success(){
            return success(null);
        }
        
        /**
         * 成功，输入需要返回的结果
         * @param data 输出的结果
         * @return R
         */
        public static R success(Object data){
            R rs = new R();
            rs.success = true;
            rs.data = data;
            return rs;
        }
        
        public static R failure(String msg){
        	R rs = new R();
        	rs.success = false;
        	rs.msg = msg;
        	return rs;
        }

        public boolean isSuccess() {
            return success;
        }
        
        public void setData(Object data){
        	this.data = data;
        }

        public Object getData() {
            return data;
        }

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
        
		public static R failure(Exception e){
        	R rs = new R();
        	rs.success = false;
        	if (e instanceof BusinessException) {
				BusinessException be=(BusinessException)e;
        		rs.msg=be.getErrorMessage();
				if (StringUtils.isBlank(rs.msg)) {
					rs.msg=be.getErrorCode();
				}
			}else {
				rs.msg = "抱歉，系统错误~";
			}
        	return rs;
        }
    }

	protected void writeExcelToResponse(HttpServletResponse response, XSSFWorkbook workbook, String fileName) throws IOException {
		//清空response
		response.reset();
		//设置response的Header
		fileName= URLEncoder.encode(fileName, "UTF-8");
		response.addHeader("Content-Disposition", "attachment;filename="+ fileName);
		OutputStream os = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/vnd.ms-excel;charset=gb2312");
		//将excel写入到输出流中
		workbook.write(os);
		os.flush();
		os.close();
	}

}
