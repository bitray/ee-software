package net.ray.web.ees.bo.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.ray.web.ees.bo.FloorBO;
import net.ray.web.ees.db.dao.FloorsMapper;
import net.ray.web.ees.db.eo.Floors;

@Service("floorBO")
public class FloorBOImpl implements FloorBO {
	@Resource
	private FloorsMapper floorsMapper;

	@Override
	public List<Floors> getFloors() {
		return floorsMapper.getFloors();
	}

	@Override
	public boolean insertFloor(Floors floors) {
		int count = 0;
		try {
			count = floorsMapper.insert(floors);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return count > 0;
	}

	@Override
	public boolean deleteFloor(Integer floorId) {
		int count = 0;
		try {
			count = floorsMapper.deleteByPrimaryKey(floorId);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return count > 0;
	}

	@Override
	public boolean updateFloor(Floors floors) {
		int count = 0;
		try {
			count = floorsMapper.updateByPrimaryKeySelective(floors);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return count > 0;
	}

}
