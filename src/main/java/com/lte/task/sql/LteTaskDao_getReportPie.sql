 select total.total_cnt
 ,ifnull(valid.valid_cnt,0) as valid_cnt
 ,ifnull(valid.valid_cnt,0)/total.total_cnt*100 as percent
  from (
 select count(1) as total_cnt,building_id from lte_data
	where 1=1
	and building_id = :paraMap.buildingId
	and task_id = :paraMap.taskId
 group by building_id ) total
 left join 
 (select count(1) as valid_cnt,building_id from lte_data
	where 1=1
	and lte_rsrp >= -105
	and lte_sinr >=-3
	and building_id = :paraMap.buildingId
	and task_id = :paraMap.taskId
 group by building_id)  valid
 on total.building_id = valid.building_id
 where 1=1
 and total.total_cnt is not null 

 