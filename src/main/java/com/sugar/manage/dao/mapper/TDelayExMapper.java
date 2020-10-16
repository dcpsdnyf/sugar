package com.sugar.manage.dao.mapper;


import com.sugar.manage.dao.vo.TDelayVO;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public interface TDelayExMapper
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TDelayVO selectTDelayById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tDelay 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TDelayVO> selectTDelayList(TDelayVO tDelay);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    public int insertTDelay(TDelayVO tDelay);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    public int updateTDelay(TDelayVO tDelay);

    /**
     * 修改【请填写功能名称】
     *
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    public int udaDelay(TDelayVO tDelay);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTDelayById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTDelayByIds(String[] ids);
}
