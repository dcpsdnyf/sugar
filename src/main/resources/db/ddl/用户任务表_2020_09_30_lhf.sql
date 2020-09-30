DROP TABLE IF EXISTS t_user_task；
CREATE TABLE t_user_task(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'id' ,
    STATUS VARCHAR(32)    COMMENT '状态（01有效，99失效）' ,
    CREATED_STAFF VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_STAFF VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' ,
    PROJECT_ID VARCHAR(128)    COMMENT '项目id' ,
    TASK_PRINCIPAL VARCHAR(128)    COMMENT '任务责任人' ,
    TASK_TYPE VARCHAR(128)    COMMENT '任务类型 00指派下发的任务/01下属填写的任务' ,
    TASK_STATUS VARCHAR(128)    COMMENT '任务状态 0待进行1进行中2已完成' ,
    TASK_NAME VARCHAR(128)    COMMENT '任务名称' ,
    TASK_SUB_NAME VARCHAR(128)    COMMENT '任务子名称' ,
    START_TIME VARCHAR(128)    COMMENT '开始时间' ,
    END_TIME VARCHAR(128)    COMMENT '完成时间' ,
    ESTIMATED_TIME VARCHAR(128)    COMMENT '预计时间' ,
    TASK_INFO VARCHAR(1024)    COMMENT '任务内容' ,
    TASK_PARENT_TYPE VARCHAR(128)    COMMENT '任务大阶段状态' ,
    PRIMARY KEY (id)
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

alter table t_sugar_project add  START_TIME varchar(200);

alter table t_sugar_project add  TASK_PRINCIPAL varchar(200);

