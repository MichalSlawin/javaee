package com.javaee.doorstore.service;

import com.javaee.doorstore.domain.Door;

import java.util.ArrayList;
import java.util.List;

public class StorageService {

	private static List<Door> doorsList = new ArrayList<Door>();
	private static List<Door> shoppingCart = new ArrayList<Door>();
	
	public static void add(Door door, List<Door> list){
		Door newDoor = new Door(door.getId(), door.getProductionDate(),
				door.getWeight(), door.isExterior(), door.getProducer(), door.getDescription(), door.getPrice());
		list.add(newDoor);
	}

	public static Door getDoor(long id) {
		for(Door door : doorsList) {
			if(door.getId() == id) return door;
		}
		return null;
	}
	
	public static List<Door> getDoorsList(){
		return doorsList;
	}

	public static List<Door> getShoppingCart() {
		return shoppingCart;
	}

}
