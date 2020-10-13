package com.sugar.manage.dao.mapper;


import com.sugar.manage.dao.vo.TUserTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
public interface TUserTaskMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    public TUserTask selectTUserTaskById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param tUserTask 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<TUserTask> selectTUserTaskList(TUserTask tUserTask);

    /**
     * 新增【请填写功能名称】
     * 
     * @param tUserTask 【请填写功能名称】
     * @return 结果
     */
    public int insertTUserTask(TUserTask tUserTask);

    /**
     * 修改【请填写功能名称】
     * 
     * @param tUserTask 【请填写功能名称】
     * @return 结果
     */
    public int updateTUserTask(TUserTask tUserTask);
    public int updateTask(TUserTask tUserTask);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTUserTaskById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTUserTaskByIds(String[] ids);

    public TUserTask getTaskInfoByUserIdAndProjectIdtask1(@Param("projectId")String projectId);

    public List<TUserTask> getTaskInfoByProductIdAndTaskType(String projectId);

    public List<TUserTask> getTaskInfoByProductIdAndTaskTypehsn(String projectId);

    public TUserTask getTaskInfoByProductId(String projectId);

    public List<String> getAllTaskNameByProductId(String projectId);

    public List<TUserTask> getTkPrincipalByPjId(@Param("projectIds") List<String> projectIds);

    public List<TUserTask> getDoneTask(String taskPrincipal);

    public List<TUserTask> getUndoTask(String taskPrincipal);

    public int changeTaskStatusByPrincipalAndProjectId(@Param("taskstatus") String taskstatus,@Param("projectId") String projectId,@Param("taskPrincipal") String taskPrincipal);

    public int delayDay(TUserTask tUserTask);

    public TUserTask getProject(@Param("projectId") String projectId,@Param("taskPrincipal") String taskPrincipal,@Param("taskInfo") String taskInfo,@Param("taskStatus") String taskStatus);

    public TUserTask getTaskInfoByPrincipalAndPJId(@Param("userName") String userName,@Param("projectId") String projectId);

    public TUserTask getPrincipal(@Param("projectId") String projectId,@Param("taskName") String taskName);

    public TUserTask getOnlyAddPricipalTKName1(String projectId);

    /**
     * 根据projectId查询Task数据并且按照开始日期降序排序
     * @param tUserTask
     * @return
     */
    List<TUserTask> selectTUserTaskOrderByDate(TUserTask tUserTask);

    public int updateTUserTaskById(TUserTask tUserTask);
}
