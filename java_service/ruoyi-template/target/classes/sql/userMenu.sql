-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990127048949761, '用户', '3', '1', 'user', 'iot/user/index', 1, 0, 'C', '0', '0', 'iot:user:list', '#', 'admin', sysdate(), '', null, '用户菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990127048949762, '用户查询', 1727990127048949761, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990127048949763, '用户新增', 1727990127048949761, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990127048949764, '用户修改', 1727990127048949761, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990127048949765, '用户删除', 1727990127048949761, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990127048949766, '用户导出', 1727990127048949761, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:export',       '#', 'admin', sysdate(), '', null, '');
