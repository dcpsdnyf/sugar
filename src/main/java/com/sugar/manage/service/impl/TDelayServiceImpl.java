package com.sugar.manage.service.impl;

import java.util.List;

import com.sugar.manage.dao.mapper.TDelayMapper;
import com.sugar.manage.dao.vo.TDelay;
import com.sugar.manage.service.ITDelayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-10-09
 */
@Service
public class TDelayServiceImpl implements ITDelayService
{
    @Autowired
    private TDelayMapper tDelayMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TDelay selectTDelayById(Long id)
    {
        return tDelayMapper.selectTDelayById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tDelay 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TDelay> selectTDelayList(TDelay tDelay)
    {
        return tDelayMapper.selectTDelayList(tDelay);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTDelay(TDelay tDelay)
    {
        return tDelayMapper.insertTDelay(tDelay);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param tDelay 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTDelay(TDelay tDelay)
    {
        return tDelayMapper.updateTDelay(tDelay);
    }

    /**
     * 删除【请填写功能名称】对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
  /*  @Override
    public int deleteTDelayByIds(String ids)
    {
        return tDelayMapper.deleteTDelayByIds(Convert.toStrArray(ids));
    }
*/
    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTDelayById(Long id)
    {
        return tDelayMapper.deleteTDelayById(id);
    }
}
