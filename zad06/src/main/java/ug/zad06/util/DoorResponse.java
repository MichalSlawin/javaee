package ug.zad06.util;

import ug.zad06.domain.Door;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class DoorResponse {
    private List<Door> door = new ArrayList<>();

    public List<Door> getDoor() {
        return door;
    }

    public void setDoor(List<Door> door) {
        this.door = door;
    }
}
