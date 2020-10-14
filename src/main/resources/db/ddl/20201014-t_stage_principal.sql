CREATE TABLE t_stage_principal(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    stage_num VARCHAR(32)    COMMENT '大阶段序号代表数字' ,
    stage_name VARCHAR(128)    COMMENT '大阶段序名称' ,
    user_id INT    COMMENT '负责人id' ,
    principal_name VARCHAR(128)    COMMENT '负责人名称' ,
    project_id INT    COMMENT '项目id' ,
    status VARCHAR(32)    COMMENT '状态：01-有效；99-删除' ,
    CREATED_STAFF VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_STAFF VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
) COMMENT = '阶段负责人配置表 ';
