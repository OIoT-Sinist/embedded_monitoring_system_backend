-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850376433666, '设备配置', '3', '1', 'deviceConfig', 'iot/deviceConfig/index', 1, 0, 'C', '0', '0', 'iot:deviceConfig:list', '#', 'admin', sysdate(), '', null, '设备配置菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850376433667, '设备配置查询', 1728680850376433666, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850376433668, '设备配置新增', 1728680850376433666, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850376433669, '设备配置修改', 1728680850376433666, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850376433670, '设备配置删除', 1728680850376433666, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850376433671, '设备配置导出', 1728680850376433666, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceConfig:export',       '#', 'admin', sysdate(), '', null, '');
