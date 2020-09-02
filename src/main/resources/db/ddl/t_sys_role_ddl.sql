CREATE TABLE t_sys_role(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    role_name VARCHAR(128)    COMMENT '角色名称' ,
    role_type VARCHAR(32)    COMMENT '角色类型' ,
    role_desc VARCHAR(128)    COMMENT '角色描述' ,
    role_order INT    COMMENT '角色排序' ,
    status VARCHAR(32)    COMMENT '状态' ,
    CREATED_STAFF VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_STAFF VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
) COMMENT = '系统角色表';
