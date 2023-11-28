-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990123181801473, '设备配置', '3', '1', 'deviceConfig', 'iot/deviceConfig/index', 1, 0, 'C', '0', '0', 'iot:deviceConfig:list', '#', 'admin', sysdate(), '', null, '设备配置菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990123181801474, '设备配置查询', 1727990123181801473, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990123181801475, '设备配置新增', 1727990123181801473, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990123181801476, '设备配置修改', 1727990123181801473, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990123181801477, '设备配置删除', 1727990123181801473, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990123181801478, '设备配置导出', 1727990123181801473, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:export',       '#', 'admin', sysdate(), '', null, '');
