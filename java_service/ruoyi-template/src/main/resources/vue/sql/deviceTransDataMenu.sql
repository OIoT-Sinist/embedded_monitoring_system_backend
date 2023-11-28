-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850565177346, '物联网设备数据传输', '3', '1', 'deviceTransData', 'iot/deviceTransData/index', 1, 0, 'C', '0', '0', 'iot:deviceTransData:list', '#', 'admin', sysdate(), '', null, '物联网设备数据传输菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850565177347, '物联网设备数据传输查询', 1728680850565177346, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850565177348, '物联网设备数据传输新增', 1728680850565177346, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850565177349, '物联网设备数据传输修改', 1728680850565177346, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850565177350, '物联网设备数据传输删除', 1728680850565177346, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1728680850565177351, '物联网设备数据传输导出', 1728680850565177346, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:export',       '#', 'admin', sysdate(), '', null, '');
