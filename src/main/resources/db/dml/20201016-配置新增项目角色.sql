----------新增项目角色role_type必须为add-----------
INSERT INTO `t_sys_role`(`id`, `role_name`, `role_type`, `role_desc`, `role_order`, `status`, `CREATED_STAFF`, `CREATED_TIME`, `UPDATED_STAFF`, `UPDATED_TIME`) VALUES (8, '新增项目', 'add', NULL, NULL, '01', NULL, NULL, NULL, NULL);

----------将新增项目角色授权给用户-----------
INSERT INTO `t_user_role`(`id`, `role_id`, `user_id`, `project_id`) VALUES (null, 8, 1, 0);

INSERT INTO `t_sys_role`(`id`, `role_name`, `role_type`, `role_desc`, `role_order`, `status`, `CREATED_STAFF`, `CREATED_TIME`, `UPDATED_STAFF`, `UPDATED_TIME`) VALUES (9, '指派', 'appoint', NULL, NULL, '01', NULL, NULL, NULL, NULL);

INSERT INTO `t_sys_role`(`id`, `role_name`, `role_type`, `role_desc`, `role_order`, `status`, `CREATED_STAFF`, `CREATED_TIME`, `UPDATED_STAFF`, `UPDATED_TIME`) VALUES (10, '申请延期', 'delay', NULL, NULL, '01', NULL, NULL, NULL, NULL);

--------------2020.10.16新增查看所有项目权限角色-------------
INSERT INTO `t_sys_role`(`id`, `role_name`, `role_type`, `role_desc`, `role_order`, `status`, `CREATED_STAFF`, `CREATED_TIME`, `UPDATED_STAFF`, `UPDATED_TIME`) VALUES (11, '查看所有项目', 'viewAll', NULL, NULL, '01', NULL, NULL, NULL, NULL);
