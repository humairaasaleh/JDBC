package com.main;

public class Animals {
	private int animalId;
	private String animalname;
	private String colour;

	
//	CONSTRUCTORS
	public Animals() {
	}

	public Animals(int animalId, String animalname, String colour) {
		super();
		this.animalId = animalId;
		this.animalname = animalname;
		this.colour = colour;
	}

//CONSTRUCTOR WITHOUT ID
	public Animals(String animalname, String colour) {
		super();
		this.animalname = animalname;
		this.colour = colour;
	}

//GETTERS AND SETTERS
	public int getAnimalId() {
		return animalId;
	}

	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}

	public String getAnimalname() {
		return animalname;
	}

	public void setAnimalname(String animalname) {
		this.animalname = animalname;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

//	TO STRING
	@Override
	public String toString() {
		return "ANIMALS: " + "(ID = " + animalId + ", Name = " + animalname + ", Colour = " + colour + ") \n" ;
	}

}
