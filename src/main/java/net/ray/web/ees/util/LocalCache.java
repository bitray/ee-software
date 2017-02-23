package net.ray.web.ees.util;

import java.util.List;

import net.ray.web.ees.db.eo.Floors;

public class LocalCache {
	public static List<Floors> floors;

	public static List<Floors> getFloors() {
		return floors;
	}

	public static void setFloors(List<Floors> floors) {
		LocalCache.floors = floors;
	}
	
}
