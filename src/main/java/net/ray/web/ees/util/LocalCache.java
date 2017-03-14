package net.ray.web.ees.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ray.web.ees.db.eo.Floors;
import net.ray.web.ees.db.eo.Person;

public class LocalCache {
	public static List<Floors> floors;

	public static List<Floors> getFloors() {
		return floors;
	}

	public static void setFloors(List<Floors> floors) {
		LocalCache.floors = floors;
	}
	
	public static Map<String,Person> currentMap=new HashMap<String,Person>();

	public static Map<String, Person> getCurrentMap() {
		return currentMap;
	}
	
}
