package com.sugar.manage.service;


import com.sugar.manage.dao.vo.TDelay;

import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
public interface ITDelayService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TDelay selectTDelayById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tDelay 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TDelay> selectTDelayList(TDelay tDelay);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    public int insertTDelay(TDelay tDelay);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    public int updateTDelay(TDelay tDelay);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
  /*  public int deleteTDelayByIds(String ids);*/

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTDelayById(Long id);
}
