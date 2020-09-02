CREATE TABLE t_user_role(
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT 'ID' ,
    role_id BIGINT NOT NULL   COMMENT '角色id' ,
    user_id BIGINT NOT NULL   COMMENT '用户id' ,
    PRIMARY KEY (id)
) COMMENT = '用户角色对应关系表';
