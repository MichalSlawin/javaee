package com.javaee.doorstore.domain;

import java.util.Date;

public class Survey {
    private static long idCounter = 0;

    private long id;
    private Date dateSince;
    private Date dateTo;
    private String howOften;
    private boolean isDoorTooHeavy;
    private boolean isDoorWrongColour;
    private boolean isDoorBroken;

    public Survey() { }

    public Survey(Date dateSince, Date dateTo, String howOften, boolean isDoorTooHeavy, boolean isDoorWrongColour, boolean isDoorBroken) {
        this.id = idCounter;
        idCounter++;

        this.dateSince = dateSince;
        this.dateTo = dateTo;
        this.howOften = howOften;
        this.isDoorTooHeavy = isDoorTooHeavy;
        this.isDoorWrongColour = isDoorWrongColour;
        this.isDoorBroken = isDoorBroken;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public Date getDateSince() {
        return dateSince;
    }

    public void setDateSince(Date dateSince) {
        this.dateSince = dateSince;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getHowOften() {
        return howOften;
    }

    public void setHowOften(String howOften) {
        this.howOften = howOften;
    }

    @Override
    public String toString() {
        String surveyStr = "";
        surveyStr += "Used " + howOften + "since " + dateSince +
                ", to " + dateTo;
        if(isDoorBroken) surveyStr += "\n- door is broken";
        if(isDoorTooHeavy) surveyStr += "\n- door is too heavy";
        if(isDoorWrongColour) surveyStr += "\n- door is wrong colour";

        return surveyStr;
    }
}
