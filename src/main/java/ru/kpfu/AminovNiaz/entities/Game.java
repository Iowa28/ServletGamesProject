package ru.kpfu.AminovNiaz.entities;

public class Game {
	private String name;
	private String annotation;
	private double raiting;
	  
	public Game(String name, String annotation, double raiting) {
		this.name = name;
		this.annotation = annotation;
		this.raiting = raiting;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public double getRaiting() {
		return raiting;
	}

	public void setRaiting(double raiting) {
		this.raiting = raiting;
	}
	  
	
}
