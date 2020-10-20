
--初始化用户--
insert into t_boms_ums_user(id, user_name, user_phone, user_type, email, sex,
                           password, secure, cpy_id, cpy_name,create_time, last_update_time, is_deleted)
values (87682829097369600, '寸代永', '13917182631',
        'Platform', 'david_1642@163.com', 'Sir', '$2a$10$o078w1KZnPQQcEXEdcc9FusIYtruqyIgXVAGEwRod68hxmfgUgc/C',
        '182631', 1000,'平台' ,now(), now(), false);

--初始化菜单--
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('87682829118341120', '权限管理', '0', 'Menu', '1', '50', 'AuthManager', null, 'cluster', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('87685195905368064', '菜单管理', '87682829118341120', 'Menu', '2', '2', 'MenuManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
    (id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
    VALUES ('87692369041817604', '角色管理', '87682829118341120', 'Menu', '2', '5', 'RoleManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('87692369041817606', '角色分配', '87682829118341120', 'Menu', '2', '10', 'RoleUserManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);

INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88033524942110720', '部门管理', '88033393417125888', 'Menu', '2', '1', 'DeptManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88033393417125888', '组织结构', '0', 'Menu', '1', '1', 'OrganizationManager', null, 'team', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88033627182465024', '员工管理', '88033393417125888', 'Menu', '2', '10', 'EmployeeManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88033719897554944', '岗位管理', '88033393417125888', 'Menu', '2', '5', 'PostManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88269820901982208', '数据权限', '0', 'Menu', '1', '60', 'DataAuth', null, 'database', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88270405705400320', '角色管理', '88269820901982208', 'Menu', '2', '1', 'DataRoleManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88270492665905152', '角色分配', '88269820901982208', 'Menu', '2', '5', 'DataRoleUserManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88387512627625984', '数据字典', '88387354804355072', 'Menu', '2', '1', 'DictionaryManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88387354804355072', '基础资料', '0', 'Menu', '1', '30', 'BasicData', null, 'database', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88388958098030592', '企业管理', '0', 'Menu', '1', '70', 'Company', null, 'apartment', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88397132158992384', '资讯列表', '88397055889768448', 'Menu', '2', '1', 'NewsManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88389026934947840', '企业列表', '88388958098030592', 'Menu', '2', '1', 'CompanyManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('89028862188453888', '省市区管理', '88387354804355072', 'Menu', '2', '5', 'AreaManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('89282314101587968', '区域管理', '88387354804355072', 'Menu', '2', '10', 'AreaCpyManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('88397055889768448', '资讯管理', '0', 'Menu', '1', '35', 'News', null, 'read', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('93746454316711936', '配置管理', '0', 'Menu', '1', '31', 'Config', null, 'setting', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('93748211293880320', '部门区域', '93746454316711936', 'Menu', '1', '1', 'DeptAreaManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94147143324925952', '日志管理', '0', 'Menu', '1', '100', 'LogManager', null, 'file-text', null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);
INSERT INTO t_boms_auth_menu
(id,menu_name,parent_id,menu_type,level,sort,item_id,item_class,item_icon,item_pack,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94147258336935936', '操作日志', '94147143324925952', 'Menu', '2', '1', 'OperationLogManager', null, null, null, null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);


--初始化角色--
INSERT INTO t_boms_auth_role
(id,role_name,remark,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('87692369016651776', '超级管理员', null, '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(), false, 1000);

--角色菜单关联--
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456755957760', '87692369016651776', '94753939827720192', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', '2019-09-19 19:52:58.94', now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456755957761', '87692369016651776', '87685195905368064', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456755957762', '87692369016651776', '87692369041817604', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456755957763', '87692369016651776', '87692369041817606', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(), now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152064', '87692369016651776', '87682829118341120', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152065', '87692369016651776', '88033524942110720', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152066', '87692369016651776', '88033393417125888', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152067', '87692369016651776', '88033627182465024', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152068', '87692369016651776', '88033719897554944', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152069', '87692369016651776', '88270405705400320', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152070', '87692369016651776', '88270492665905152', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152071', '87692369016651776', '88387872800899072', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152072', '87692369016651776', '88384019628032000', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152073', '87692369016651776', '88384100976558080', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152074', '87692369016651776', '88384554871554048', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152075', '87692369016651776', '88384661046165504', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152076', '87692369016651776', '88385188542808064', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152077', '87692369016651776', '88385044959199232', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152078', '87692369016651776', '88383785392930816', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152079', '87692369016651776', '88384436655095808', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152080', '87692369016651776', '88384965212897280', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152081', '87692369016651776', '88386486197551104', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152082', '87692369016651776', '88386556351479808', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152083', '87692369016651776', '88387512627625984', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152084', '87692369016651776', '88386410662330368', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152085', '87692369016651776', '88387354804355072', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152086', '87692369016651776', '88387947321098240', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152087', '87692369016651776', '88397055889768448', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152088', '87692369016651776', '88397132158992384', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152089', '87692369016651776', '88388958098030592', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152090', '87692369016651776', '88389026934947840', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152091', '87692369016651776', '89028862188453888', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152092', '87692369016651776', '89282314101587968', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152093', '87692369016651776', '89417130511958016', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152094', '87692369016651776', '89417219238264832', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152095', '87692369016651776', '89417308128149504', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152096', '87692369016651776', '91194874522501120', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152097', '87692369016651776', '92747221904130048', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152098', '87692369016651776', '92747402351476736', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152099', '87692369016651776', '93746454316711936', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152100', '87692369016651776', '93748211293880320', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152101', '87692369016651776', '94147143324925952', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152102', '87692369016651776', '94147258336935936', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152103', '87692369016651776', '88269820901982208', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);
INSERT INTO t_boms_auth_role_menu
(id,role_id,menu_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('94883456760152104', '87692369016651776', '94883422731763712', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);


--角色人员关联--
INSERT INTO t_boms_auth_role_user
(id,user_id,role_id,create_id,create_name,create_dept_id,create_dept_name,last_update_id,last_update_name,create_time,last_update_time,is_deleted,cpy_id)
VALUES ('87692369041817601', '87682829097369600', '87692369016651776', '87682829097369600', '寸代永', null, null, '87682829097369600', '寸代永', now(),now(),false,1000);

