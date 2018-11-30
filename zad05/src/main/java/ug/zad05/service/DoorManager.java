package ug.zad05.service;

import ug.zad05.domain.Door;

import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Singleton
public class DoorManager {
    private List<Door> db = Collections.synchronizedList(new ArrayList<>());

    public void addDoor(Door door) {
        db.add(door);
    }

    public void deleteDoor(Door door) {
        db.remove(door);
    }

    public Door getDoor(long id) {
        for(Door door : db) {
            if(door.getId() == id) return door;
        }
        return null;
    }

    public void updateDoor(long id) {
        for(Door door : db) {
        }
    }

    public List<Door> getAllDoors() {
        return db;
    }

    public void deleteAllDoors() {
        db.clear();
    }
}
