package com.ymb.windy.datasource2.service.impl;

import com.ymb.windy.datasource2.entity.Area;
import com.ymb.windy.datasource2.mapper.AreaMapping;
import com.ymb.windy.datasource2.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Component
@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaMapping areaMapping;

	@Override
	@Transactional
	public void saveArea(Area area) {
		areaMapping.saveArea(area);
	}

	@Override
	@Transactional
	public List<Area> queryAllArea() {
		return areaMapping.queryAllArea();
	}
}
