package com.cafe.CafeWonder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="cake")
public class Cake {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cakeId;
	private String cakeName;
	private String cakeImagePath;
	private String description;
	private int calories;
	private int price;
	
	public Cake()
	{
		
	}

	public Cake(String cakeName, String cakeImagePath, String description, int calories,int price)
	{
		this.cakeName = cakeName;
		this.cakeImagePath = cakeImagePath;
		this.description = description;
		this.calories = calories;
		this.price = price;
	}


	public long getCakeId() {
		return cakeId;
	}



	public void setCakeId(long cakeId) {
		this.cakeId = cakeId;
	}



	public String getCakeName() {
		return cakeName;
	}



	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}



	public String getCakeImagePath() {
		return cakeImagePath;
	}



	public void setCakeImagePath(String cakeImagePath) {
		this.cakeImagePath = cakeImagePath;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getCalories() {
		return calories;
	}



	public void setCalories(int calories) {
		this.calories = calories;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
