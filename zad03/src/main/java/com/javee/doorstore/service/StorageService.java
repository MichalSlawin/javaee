package com.javee.doorstore.service;

import com.javee.doorstore.domain.Door;

import java.util.ArrayList;
import java.util.List;

public class StorageService {
	
	private List<Door> db = new ArrayList<Door>();
	
	public void add(Door door){
		Door newDoor = new Door(door.getId(), door.getProductionDate(),
				door.getWeight(), door.isExterior(), door.getProducer(), door.getDescription());
		db.add(newDoor);
	}
	
	public List<Door> getAllPersons(){
		return db;
	}

}
