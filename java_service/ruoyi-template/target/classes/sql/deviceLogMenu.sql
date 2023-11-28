-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126725988354, '设备日志', '3', '1', 'deviceLog', 'iot/deviceLog/index', 1, 0, 'C', '0', '0', 'iot:deviceLog:list', '#', 'admin', sysdate(), '', null, '设备日志菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126725988355, '设备日志查询', 1727990126725988354, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126725988356, '设备日志新增', 1727990126725988354, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126725988357, '设备日志修改', 1727990126725988354, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126725988358, '设备日志删除', 1727990126725988354, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126725988359, '设备日志导出', 1727990126725988354, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceLog:export',       '#', 'admin', sysdate(), '', null, '');
