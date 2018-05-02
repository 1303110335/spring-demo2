package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Area;

/**
 * @author xly
 */
public interface AreaMapper {
	List<Area> queryArea();
	Area queryAreaById(int areaId);
	int insertArea(Area area);
	int updateArea(Area area);
	int deleteArea(int areaId);
}