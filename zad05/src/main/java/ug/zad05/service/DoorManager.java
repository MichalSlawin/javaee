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

    public Door getDoor(long id) {
        for(Door door : db) {
            if(door.getId() == id) return door;
        }
        return null;
    }

    public List<Door> getDoors(String producer) {
        List<Door> doorsList = new ArrayList<>();

        for(Door door : db) {
            if(door.getProducer().equals(producer)) {
                doorsList.add(door);
            }
        }
        return doorsList;
    }

    public List<Door> getAllDoors() {
        return db;
    }

    public Door updateDoor(Door newDoor) {
        for(int i = 0; i < db.size(); i++) {
            if(db.get(i).getId() == newDoor.getId())
                db.set(i, newDoor);
        }
        return newDoor;
    }

    public void deleteDoor(long id) {
        for(Door door : db) {
            if(door.getId() == id) {
                db.remove(door);
            }
        }
    }

    public void deleteAllDoors() {
        db.clear();
    }
}
