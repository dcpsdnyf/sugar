ALTER  TABLE  t_sugar_project  ADD   group_name  VARCHAR(128) COMMENT  '集团名称' ;

ALTER  TABLE  t_sugar_project  ADD   business_principal  VARCHAR(128) COMMENT  '商机负责人' ;

ALTER  TABLE  t_sugar_project  ADD   purchase_principal  VARCHAR(128) COMMENT  '采购负责人' ;

ALTER  TABLE  t_sugar_project  ADD   product_principal  VARCHAR(128) COMMENT  '产品负责人' ;

ALTER  TABLE  t_sugar_project  ADD   development_principal  VARCHAR(128) COMMENT  '研发负责人' ;

ALTER  TABLE  t_sugar_project  ADD   operation_principal  VARCHAR(128) COMMENT  '运营负责人' ;

ALTER  TABLE  t_sugar_project  ADD   operation_maintain_principal  VARCHAR(128) COMMENT  '运维负责人' ;

--------------------------2020.10.16-------------------------
ALTER  TABLE  t_sugar_project  ADD   add_project_username  VARCHAR(64) COMMENT  '项目新增人' ;