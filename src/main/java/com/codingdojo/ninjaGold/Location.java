package com.codingdojo.ninjaGold;

import java.util.Date;

public class Location {
	private String location;
	private String text;
	private int gold;
	private String color;
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGained() {
		return gained;
	}

	public void setGained(String gained) {
		this.gained = gained;
	}

	private String gained;
	
	public Location( String location, int gold ) {
		this.location = location;
		this.gold = gold;
		
		if(gold < 0) {
			this.color = "red";
			this.gained = "lost";
		}else {
			this.color = "green";
			this.gained = "gained";
		}
		
		this.text = "You entered a " + location + " and " + this.gained + " " + this.gold + " gold ( " + new Date() + " ).";
	}
}
