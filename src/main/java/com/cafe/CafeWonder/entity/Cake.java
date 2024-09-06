package com.cafe.CafeWonder.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="cake")
public class Cake {
	

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long cakeId;
	private String cakeName;
	private String cakeImagePath;
	private String description;
	private Integer calories;
	private Integer price;

	@ManyToMany
	@JoinTable(name = "User_Cake",joinColumns = {@JoinColumn(name="cakeId")},inverseJoinColumns = {@JoinColumn(name = "userId")})
	private List<User> userList;

	public Cake()
	{
	}

	public Cake(String cakeName, String cakeImagePath, String description, Integer calories,Integer price)
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



	public Integer getCalories() {
		return calories;
	}



	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
}
