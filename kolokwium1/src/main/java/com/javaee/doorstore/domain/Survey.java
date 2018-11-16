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

    public Survey() {
    }

    public Survey(String dateSince, String dateTo, String howOften, boolean isDoorTooHeavy, boolean isDoorWrongColour, boolean isDoorBroken) {
        this.dateSince = dateSince;
        this.dateTo = dateTo;
        this.howOften = howOften;
        this.isDoorTooHeavy = isDoorTooHeavy;
        this.isDoorWrongColour = isDoorWrongColour;
        this.isDoorBroken = isDoorBroken;
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

    @Override
    public String toString() {
        String surveyStr = "";
        surveyStr += "Used since " + dateSince +
                ", Used to=" + dateTo +
                ", Used " + howOften;
        if(isDoorBroken) surveyStr += ", door is broken";
        if(isDoorTooHeavy) surveyStr += ", door is too heavy";
        if(isDoorWrongColour) surveyStr += ", door is wrong colour";

        return surveyStr;
    }
}
