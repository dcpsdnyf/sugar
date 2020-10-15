CREATE TABLE t_stage_time(
    id INT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    stage_type VARCHAR(32)    COMMENT '阶段类型(01：大阶段；02：小阶段)' ,
    stage_name VARCHAR(128)    COMMENT '阶段名称' ,
    stage_day INT    COMMENT '阶段默认完成天数' ,
    status VARCHAR(32)    COMMENT '状态（01：有效；99：删除）' ,
    CREATED_STAFF VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_STAFF VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
) COMMENT = '阶段默认时间配置表 ';

