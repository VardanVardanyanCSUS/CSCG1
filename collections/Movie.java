package collections;

//import java.io.*;
//import java.util.*;
//import java.io.IOException;

class Movie{
	private String title;
	private String director;
	private int year;
	
	public Movie(String title, String director, int year){
		this.title=title;
		this.director=director;
		this.year=year;
	}
	
	//default constructor
	public Movie(){
		this("null", "null", -1);
	}
	
	/******* setters *******/
	public void setTitle(String title){
		this.title=title;
	}
	
	public void setDirector(String director){
		this.director=director;
	}
	
	public void setYear(int year){
		this.year=year;
	}
	
	/****** getters *****/
	public String getTitle(){
		return this.title;
	}
	
	public String getDirector(){
		return this.director;
	}
	
	public int getYear(){
		return this.year;
	}
	
	public String toString(){
		return this.title + ", " + this.director + ", " + this.year;
	}
}