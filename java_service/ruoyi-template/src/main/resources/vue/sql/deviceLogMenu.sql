-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850502262785, '设备日志', '3', '1', 'deviceLog', 'iot/deviceLog/index', 1, 0, 'C', '0', '0', 'iot:deviceLog:list', '#', 'admin', sysdate(), '', null, '设备日志菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850502262786, '设备日志查询', 1728680850502262785, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850502262787, '设备日志新增', 1728680850502262785, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850502262788, '设备日志修改', 1728680850502262785, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850502262789, '设备日志删除', 1728680850502262785, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850502262790, '设备日志导出', 1728680850502262785, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:export',       '#', 'admin', sysdate(), '', null, '');
