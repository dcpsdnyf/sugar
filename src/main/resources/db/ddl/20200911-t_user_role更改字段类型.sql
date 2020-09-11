alter table t_user_role modify role_id varchar(512) not null  COMMENT '角色id';

alter table t_user_role modify project_id varchar(512) not null COMMENT '用户id';