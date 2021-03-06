CREATE TABLE t_sys_user(
    ID INT NOT NULL AUTO_INCREMENT  COMMENT '索引值' ,
    user_name VARCHAR(128)    COMMENT '用户名' ,
    english_name  VARCHAR(128)    COMMENT  '英文名称',
    status VARCHAR(32)    COMMENT '状态' ,
    remark VARCHAR(128)    COMMENT '备注' ,
    CREATED_STAFF VARCHAR(32)    COMMENT '创建人' ,
    CREATED_TIME DATETIME    COMMENT '创建时间' ,
    UPDATED_STAFF VARCHAR(32)    COMMENT '更新人' ,
    UPDATED_TIME DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (ID)
) COMMENT = '系统用户表';
