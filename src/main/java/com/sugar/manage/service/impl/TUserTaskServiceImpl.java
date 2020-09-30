package com.sugar.manage.service.impl;

import java.util.HashMap;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sugar.common.utils.CookieUtils;
import com.sugar.manage.dao.mapper.TUserRoleMapper;
import com.sugar.manage.dao.mapper.TUserTaskMapper;
import com.sugar.manage.dao.model.TSugarProjectWithBLOBs;
import com.sugar.manage.dao.vo.TUserTask;
import com.sugar.manage.service.ITUserTaskService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;


/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-09-28
 */
@Service
public class TUserTaskServiceImpl implements ITUserTaskService {
    @Autowired
    private TUserTaskMapper tUserTaskMapper;
    @Autowired
    private TUserRoleMapper tUserRoleMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param id 【请填写功能名称】ID
     * @return 【请填写功能名称】
     */
    @Override
    public TUserTask selectTUserTaskById(Long id) {
        return tUserTaskMapper.selectTUserTaskById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param tUserTask 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<TUserTask> selectTUserTaskList(TUserTask tUserTask) {
        return tUserTaskMapper.selectTUserTaskList(tUserTask);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param tUserTask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertTUserTask(TUserTask tUserTask) {
        return tUserTaskMapper.insertTUserTask(tUserTask);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param tUserTask 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateTUserTask(TUserTask tUserTask) {
        return tUserTaskMapper.updateTUserTask(tUserTask);
    }

    /**
     * 删除【请填写功能名称】对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
  /*  @Override
    public int deleteTUserTaskByIds(String ids)
    {
        return tUserTaskMapper.deleteTUserTaskByIds(Convert.toStrArray(ids));
    }*/

    /**
     * 删除【请填写功能名称】信息
     *
     * @param id 【请填写功能名称】ID
     * @return 结果
     */
    @Override
    public int deleteTUserTaskById(Long id) {
        return tUserTaskMapper.deleteTUserTaskById(id);
    }

    @Override
    public TUserTask getTaskInfoByUserIdAndProjectId(String projectId, String userId) {

        TUserTask task = new TUserTask();
        if ("53".equals(userId) || "33".equals(userId)) {//如果是李佳娜、谢帅
            task = tUserTaskMapper.getTaskInfoByUserIdAndProjectIdtask1(projectId);
            if ("10".equals(task.getTaskSubName())) {//这个task.gettasksubname需要从下级中获取
                task.setTaskSubName("商机线索开启");
            }
            if ("11".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机线索0%");
            }
            if ("12".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机发现10%");
            }
            if ("13".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机确立25%");
            }
            if ("14".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机确立50%");
            }
            if ("15".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机确立75%");
            }
            if ("16".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机赢取100%");
            }
            if ("17".equals(task.getTaskSubName())) {
                task.setTaskSubName("客户回款/维护阶段");
            }
            if ("18".equals(task.getTaskSubName())) {
                task.setTaskSubName("商机关闭");
            }
            if ("1".equals(task.getTaskName())) {
                task.setTaskName("商机推进阶段");
            }
            return task;
        }


        if ("80".equals(userId)) {//如果是尹罗琦
            List<TUserTask> tasklist = tUserTaskMapper.getTaskInfoByProductIdAndTaskType(projectId);
            HashMap<String, TUserTask> taskn = new HashMap<>();

            for (TUserTask tusk : tasklist) {
                taskn.put(tusk.getTaskName(),tusk);
            }
            if (taskn.containsKey("2")) {
                task.setTaskName("采购阶段");
                if ("21".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("初步意向方案");
                }
                if ("22".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("写立项方案");
                }
                if ("23".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("工时评估");
                }
                if ("24".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("商务谈判");
                }
                if ("25".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("请示拟写");
                }
                if ("26".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("上会");
                }
                if ("27".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("招投标");
                }
                if ("28".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("请示OA审批");
                }
                if ("29".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("合同拟写");
                }
                if ("291".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("律师审核");
                }
                if ("292".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("合同OA审批");
                }
                if ("293".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("用章");
                }
                if ("294".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("对方盖章");
                }
                if ("295".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("扫描");
                }
                if ("296".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("综合部归档");
                }
                if ("297".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("首付款");
                }
                if ("298".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("进度款");
                }
                if ("299".equals(taskn.get("2").getTaskSubName())) {
                    task.setTaskSubName("尾款");
                }

            }

            if (taskn.containsKey("3")) {
                task.setTaskName("产品阶段");
                if ("31".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("设计概要");
                }
                if ("32".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("详细设计");
                }
                if ("33".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("UI设计");
                }
                if ("34".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("需求设计");
                }
                if ("35".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("需求审批");
                }
                if ("36".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("需求单确认");
                }
                if ("37".equals(taskn.get("3").getTaskSubName())) {
                    task.setTaskSubName("验收");
                }

            }
            if (taskn.containsKey("5")) {
                task.setTaskName("运营阶段");
                task.setTaskSubName("运营阶段");
            }
            return task;
        }

        if ("20".equals(userId)) {//如果是黄斯南
            List<TUserTask> tasklist = tUserTaskMapper.getTaskInfoByProductIdAndTaskTypehsn(projectId);
            HashMap<String, TUserTask> taskn = new HashMap<>();
            for (TUserTask tusk : tasklist) {
                taskn.put(tusk.getTaskName(),tusk);
            }
            if (taskn.containsKey("4")) {
                task.setTaskName("研发阶段");
                if ("41".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("技术选型");
                }
                if ("42".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("环境部署");
                }
                if ("43".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("框架设计");
                }
                if ("44".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度10");
                }
                if ("45".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度25");
                }
                if ("46".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度50");
                }
                if ("47".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度75");
                }
                if ("48".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("开发进度100");
                }
                if ("49".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("内部测试优化");
                }
                if ("50".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("客户测试优化");
                }
                if ("51".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("实施交付");
                }
                if ("52".equals(taskn.get("4").getTaskSubName())) {
                    task.setTaskSubName("验收");
                }
            }
            if (taskn.containsKey("6")) {
                task.setTaskName("运维阶段");
                task.setTaskSubName("技术选型");
            }
            return task;
        }
        //如果是卢丽娜、张洋洋、姜仲一则返回一阶段信息
        if ("82".equals(userId) || "26".equals(userId) || "47".equals(userId)) {
            TUserTask ustk =  tUserTaskMapper.getTaskInfoByProductId(projectId);
            return ustk;
        }
        return null;
    }

    @Override
    public List<String> getAllTaskNameByProductId(String projectId) {

        return tUserTaskMapper.getAllTaskNameByProductId(projectId);
    }

    @Override
    public String getAllTaskNameByProductId(Long userId) {
        return tUserRoleMapper.getIsHasPowerToInsertTask(userId);
    }

    @Override
    public PageInfo<TUserTask> getDoneTask(String taskPrincipal) {
        List<TUserTask> doneTkuser = tUserTaskMapper.getDoneTask(taskPrincipal);
        if (!CollectionUtils.isEmpty(doneTkuser)) {
            PageInfo<TUserTask> pageInfo = new PageInfo<>(doneTkuser);
            return pageInfo;
        }
        return new PageInfo<>();
    }

    @Override
    public PageInfo<TUserTask> getUndoTask(String taskPrincipal) {
        List<TUserTask> unDoTkuser =  tUserTaskMapper.getUndoTask(taskPrincipal);
        if (!CollectionUtils.isEmpty(unDoTkuser)) {
            PageInfo<TUserTask> pageInfo = new PageInfo<>(unDoTkuser);
            return pageInfo;
        }
        return new PageInfo<>();
    }
}





