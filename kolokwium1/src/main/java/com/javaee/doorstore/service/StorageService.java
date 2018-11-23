package com.javaee.doorstore.service;

import com.javaee.doorstore.domain.Door;
import com.javaee.doorstore.domain.Survey;

import java.util.ArrayList;
import java.util.List;

public class StorageService {

	private List<Door> doorsList = new ArrayList<Door>();
	private List<Survey> surveysList = new ArrayList<Survey>();
	
	public void addDoor(Door door){
		Door newDoor = new Door(door.getId(), door.getProductionDate(),
				door.getWeight(), door.isExterior(), door.getProducer(), door.getDescription(), door.getPrice());
		doorsList.add(newDoor);
	}

	public Door getDoor(long id) {
		for(Door door : doorsList) {
			if(door.getId() == id) return door;
		}
		return null;
	}

	public void addSurvey(Survey survey) {
		Survey newSurvey = new Survey(survey.getDateSince(), survey.getDateTo(), survey.getHowOften(),
				survey.isDoorTooHeavy(), survey.isDoorWrongColour(), survey.isDoorBroken());
		surveysList.add(newSurvey);
	}

	public List<Survey> getAllSurveys() {
		return surveysList;
	}

	public void deleteLastSurvey() {
		surveysList.remove(surveysList.size()-1);
	}

	public Survey getSurveyById(long id) {
		for(Survey survey : surveysList) {
			if(survey.getId() == id) return survey;
		}
		return null;
	}

	public void deleteSurveyById(long id) {
		surveysList.remove(getSurveyById(id));
	}

	public void clearDoors() {
		doorsList.clear();
	}
	
	public List<Door> getAllDoors(){
		return doorsList;
	}

}
