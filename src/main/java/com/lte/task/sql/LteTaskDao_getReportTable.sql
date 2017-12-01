 select total.total_cnt
 ,total.building_floor_id
 ,ifnull(valid.valid_cnt,0) as valid_cnt
 ,buildingFloor.floor_name
 ,ifnull(valid.valid_cnt,0)/total.total_cnt*100 as percent
  from (
 select count(1) as total_cnt,building_floor_id from lte_data
	where 1=1
	and building_id = :paraMap.buildingId
	and task_id = :paraMap.taskId
 group by building_floor_id ) total
 left join 
 (select count(1) as valid_cnt,building_floor_id from lte_data
	where 1=1
	and lte_rsrp >= -105
	and lte_sinr >=-3
	and building_id = :paraMap.buildingId
	and task_id = :paraMap.taskId
 group by building_floor_id)  valid
 on total.building_floor_id = valid.building_floor_id
 left join lte_building_floor buildingFloor
 on total.building_floor_id = buildingFloor.id
 where 1=1
 and total_cnt is not null 
 <#if ( paraMap.floorId )?? && paraMap.floorId ?length gt 0>
		    and total.building_floor_id = :paraMap.floorId
</#if>
 order by total.building_floor_id
 
 
 