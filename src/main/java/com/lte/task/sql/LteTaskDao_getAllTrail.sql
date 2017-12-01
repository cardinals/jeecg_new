select a.pic_x ,a.pic_y,b.lte_cgi,b.lte_rsrp,b.lte_sinr,b.data_timestamp from lte_scan_trail a left join lte_data b
    on a.trail_timestamp = b.data_timestamp
    where 1=1
    and a.building_id = :paraMap.buildingId
    and a.building_floor_id = :paraMap.floorId
    and a.task_id = :paraMap.taskId
    and a.pic_x is not null
    and a.pic_y is not null
    and b.lte_cgi is not null
    and b.lte_rsrp is not null
    and b.lte_sinr is not null
    group by a.pic_x,a.pic_y,b.lte_cgi,b.lte_rsrp,b.lte_sinr,b.data_timestamp
    order by b.data_timestamp
    