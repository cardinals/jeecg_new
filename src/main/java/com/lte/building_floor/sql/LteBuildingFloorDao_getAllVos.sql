SELECT lbf.*,lb.building_name
FROM lte_building_floor lbf
  LEFT JOIN lte_building lb ON lb.id = lbf.building_id
WHERE 1 = 1