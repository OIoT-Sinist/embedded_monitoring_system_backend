-- 菜单 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126918926338, '物联网设备数据传输', '3', '1', 'deviceTransData', 'iot/deviceTransData/index', 1, 0, 'C', '0', '0', 'iot:deviceTransData:list', '#', 'admin', sysdate(), '', null, '物联网设备数据传输菜单');

-- 按钮 SQL
insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126918926339, '物联网设备数据传输查询', 1727990126918926338, '1',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126918926340, '物联网设备数据传输新增', 1727990126918926338, '2',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126918926341, '物联网设备数据传输修改', 1727990126918926338, '3',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126918926342, '物联网设备数据传输删除', 1727990126918926338, '4',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_id, menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values(1727990126918926343, '物联网设备数据传输导出', 1727990126918926338, '5',  '#', '', 1, 0, 'F', '0', '0', 'iot:deviceTransData:export',       '#', 'admin', sysdate(), '', null, '');
