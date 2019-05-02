package com.ymb.windy.datasource2.service;

import com.ymb.windy.datasource2.entity.Area;
import java.util.List;

public interface AreaService {

	public void saveArea(Area area);

	public List<Area> queryAllArea();

}
