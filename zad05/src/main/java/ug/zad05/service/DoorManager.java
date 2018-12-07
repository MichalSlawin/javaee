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

//    public Door updateDoor(Door newDoor) {
//        for(int i = 0; i < db.size(); i++) {
//            if(db.get(i).getId() == newDoor.getId())
//                db.set(i, newDoor);
//        }
//        return newDoor;
//    }

    public Door updateDoor(Door newDoor) {
        int updateIndex = -1;
        for(Door door : db) {
            if(door.getId() == newDoor.getId())
                updateIndex = db.indexOf(door);
        }
        if(updateIndex != -1)
            db.set(updateIndex, newDoor);
        return newDoor;
    }

    // UWAGA: nie mozemy zmieniac listy przechodzac przez nia
    public void deleteDoor(long id) {
        Door toDelete = null;
        for(Door door : db) {
            if(door.getId() == id) {
               toDelete = door;
            }
        }
        if(toDelete != null)
            db.remove(toDelete);
    }

    public void deleteAllDoors() {
        db.clear();
    }
}
