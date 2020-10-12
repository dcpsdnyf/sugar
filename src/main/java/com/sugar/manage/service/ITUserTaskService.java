package com.sugar.manage.service;


import com.github.pagehelper.PageInfo;
import com.sugar.manage.dao.vo.TUserTask;


import java.text.ParseException;
import java.util.List;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
public interface ITUserTaskService 
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

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
  /*  public int deleteTUserTaskByIds(String ids);*/

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    public int deleteTUserTaskById(Long id);

    public TUserTask getTaskInfoByUserIdAndProjectId(String projectId,String userId);

    public List<String> getAllTaskNameByProductId(String projectId);

    public String getAllTaskNameByProductId(Long userId);

    public PageInfo<TUserTask> getDoneTask(String taskPrincipal);

    public PageInfo<TUserTask> getUndoTask(String taskPrincipal);

    public int changeTaskStatusByPrincipalAndProjectId(String taskstatus,String projectId,String taskPrincipal);

    public int delay(String userId,String projectId,String delayDay) throws ParseException;

    public void updateUserTask(TUserTask tUserTask);

    public int examine(String userId,String projectId,String staus,String taskName) throws ParseException;

    List<TUserTask> selectTUserTaskByProId(Integer projectId);

    /**
     * 更新用户任务状态为进行中
     * @param tUserTask
     */
    public void updateUserTaskToProgressing(TUserTask tUserTask);
}
