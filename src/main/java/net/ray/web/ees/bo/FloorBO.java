package net.ray.web.ees.bo;

import java.util.List;

import net.ray.web.ees.db.eo.Floors;

public interface FloorBO {
	public List<Floors> getFloors();
	public boolean insertFloor(Floors floors);
	public boolean deleteFloor(Integer floorId);
	public boolean updateFloor(Floors floors);
}
