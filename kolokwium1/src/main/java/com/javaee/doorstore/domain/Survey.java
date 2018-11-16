package com.javaee.doorstore.domain;

import java.util.Date;
import java.util.List;

public class Survey {
    private String dateSince;
    private String dateTo;
    private String howOften;
    private boolean isDoorTooHeavy;
    private boolean isDoorWrongColour;
    private boolean isDoorBroken;

    public boolean isDoorTooHeavy() {
        return isDoorTooHeavy;
    }

    public void setDoorTooHeavy(boolean doorTooHeavy) {
        isDoorTooHeavy = doorTooHeavy;
    }

    public boolean isDoorWrongColour() {
        return isDoorWrongColour;
    }

    public void setDoorWrongColour(boolean doorWrongColour) {
        isDoorWrongColour = doorWrongColour;
    }

    public boolean isDoorBroken() {
        return isDoorBroken;
    }

    public void setDoorBroken(boolean doorBroken) {
        isDoorBroken = doorBroken;
    }

    public Survey() {
    }

    public String getDateSince() {
        return dateSince;
    }

    public void setDateSince(String dateSince) {
        this.dateSince = dateSince;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getHowOften() {
        return howOften;
    }

    public void setHowOften(String howOften) {
        this.howOften = howOften;
    }

}
