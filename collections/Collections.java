package collections;

import java.io.*;
import java.util.*;
import java.io.IOException;

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

public class Collections{
	public static void main (String[] args){
		String filename = "input.txt";
		run(filename);
	}
	
	public static void run(String filename){
		LinkedList<Movie> movieList = createList(filename);
		displayMovieList(movieList);
		writeToFile(movieList);
	}

	public static LinkedList<Movie> createList(String filename){
		LinkedList<Movie> list = new LinkedList<Movie>();
		try{
			Scanner fscan = new Scanner(new File(filename));
			while(fscan.hasNextLine()){
				Movie newMovie = new Movie();
				String inline = fscan.nextLine(); //title
				String tokens[] = inline.split(": ");
				//tokens[0] is label, tokens[1] is data (title, director, or year)
				newMovie.setTitle(tokens[1]);
			
				inline = fscan.nextLine();  //director
				tokens = inline.split(": ");
				newMovie.setDirector(tokens[1]);
				
				inline = fscan.nextLine(); //year
				tokens = inline.split(": ");
				newMovie.setYear(Integer.parseInt(tokens[1]));
				
				list.add(newMovie);
				
			}

			//done scanning from list and stored into LinkedList
			
			fscan.close();
         
		}
		catch(FileNotFoundException e){
			System.out.println("File input.txt open error ");
		}
		
		//if succesfull, return list
		return list;
	}
	
	public static void displayMovieList(LinkedList<Movie> list){
		for (int i=0; i<list.size(); i++){
			System.out.println( (i+1) +". " + list.get(i).toString() );
		}
		
	}
	
	public static void writeToFile(LinkedList<Movie> list){
		try {
			FileWriter fout = new FileWriter("output.txt");
			fout.write("Output: \n");
			for (int i=0; i<list.size(); i++){
				fout.write( (i+1) +". " + list.get(i).toString()+"\n" );
			} 
			fout.close();
			System.out.println("\n Done printing to file");
		} catch (IOException e) {
			System.out.println("Error occurred ");
			e.printStackTrace();
		}
		
		
	}
}