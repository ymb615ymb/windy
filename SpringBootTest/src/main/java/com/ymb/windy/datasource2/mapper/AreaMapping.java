package com.ymb.windy.datasource2.mapper;

import com.ymb.windy.datasource2.entity.Area;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AreaMapping {

	public void saveArea(Area area);

	public List<Area> queryAllArea();
}
