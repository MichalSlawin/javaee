package com.javaee.doorstore.domain;

import java.util.Date;

public class Door {

	private long id;
	private Date productionDate;
	private double weight;
	private boolean isExterior;
	private String producer;
	private String description;
	private double price;

	public Door() {}
	
	public Door(long id, Date productionDate, double weight, boolean isExterior, String producent, String description, double price) {
		this.id = id;
		this.productionDate = productionDate;
		this.weight = weight;
		this.isExterior = isExterior;
		this.producer = producent;
		this.description = description;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isExterior() {
		return isExterior;
	}

	public void setExterior(boolean exterior) {
		isExterior = exterior;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "id=" + id +
				", productionDate=" + productionDate +
				", weight=" + weight +
				", isExterior=" + isExterior +
				", producer='" + producer + '\'' +
				", description='" + description + '\'' +
				", price=" + price;
	}
}
