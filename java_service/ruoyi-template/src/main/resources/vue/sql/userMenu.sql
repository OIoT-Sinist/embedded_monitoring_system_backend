-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850632286210, '用户', '3', '1', 'user', 'iot/user/index', 1, 0, 'C', '0', '0', 'iot:user:list', '#', 'admin', sysdate(), '', null, '用户菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850632286211, '用户查询', 1728680850632286210, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850632286212, '用户新增', 1728680850632286210, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850632286213, '用户修改', 1728680850632286210, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850632286214, '用户删除', 1728680850632286210, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850632286215, '用户导出', 1728680850632286210, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:user:export',       '#', 'admin', sysdate(), '', null, '');
