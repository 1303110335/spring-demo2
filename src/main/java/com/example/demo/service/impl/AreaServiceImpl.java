package com.example.demo.service.impl;

import com.example.demo.entity.Area;
import com.example.demo.mapper.AreaMapper;
import com.example.demo.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaMapper areaMapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Area> getAreaList() {
        return areaMapper.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaMapper.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {

        if(area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaMapper.insertArea(area);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaMapper.updateArea(area);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0) {
            try {
                int effectNum = areaMapper.deleteArea(areaId);
                if (effectNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域Id不能为空!");
        }
    }

}