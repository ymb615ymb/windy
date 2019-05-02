package com.ymb.windy.datasource2.controller;

import com.ymb.windy.datasource2.entity.Area;
import com.ymb.windy.datasource2.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 多数据源事务
 */
@RestController
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping("/area/saveArea")
	public String saveArea() {
		Area area = new Area();
		area.setAreaName("上海");
		areaService.saveArea(area);
		return "success";
	}

	@RequestMapping("/area/getAllArea")
	public List<Area> getAllArea() {

		return areaService.queryAllArea();
	}
}
