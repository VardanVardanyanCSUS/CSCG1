package collections;

import java.io.*;
import java.util.*;
import java.io.IOException;


public class Collections{
	public static void main (String[] args){
		String filename = "input.txt";
		run(filename);
	}
	
	public static void run(String filename){
		HashMap<String,Movie> movieList = createList(filename);
		displayMovieList(movieList);
		writeToFile(movieList);
	}

	public static HashMap<String,Movie> createList(String filename){
		HashMap<String,Movie> list = new HashMap<String,Movie>();
		try{
			Scanner fscan = new Scanner(new File(filename));
			int id=0; //id and counter for movies 
			while(fscan.hasNextLine()){
				id++;
				Movie newMovie = new Movie();
				String inline = fscan.nextLine(); //title
				String tokens[] = inline.split(": ");
				//tokens[0] is label, tokens[1] is data (title, director, or year)
				newMovie.setId(Integer.toString(id)); //convert int id to String then set as newMovie's id
				newMovie.setTitle(tokens[1]);
			
				inline = fscan.nextLine();  //director
				tokens = inline.split(": ");
				newMovie.setDirector(tokens[1]);
				
				inline = fscan.nextLine(); //year
				tokens = inline.split(": ");
				newMovie.setYear(Integer.parseInt(tokens[1]));
				
				list.put(newMovie.getId(),newMovie);
				
			}

			//done scanning from list and stored into LinkedList
			
			fscan.close();
         
		}
		catch(FileNotFoundException e){
			System.out.println("File input.txt open error ");
		}
		
		//if succesfully, return list
		return list;
	}
	
	public static void displayMovieList(HashMap<String,Movie> list){
		for (String id: list.keySet()){
			System.out.println( list.get(id).toString() );
		}
		
	}
	
	public static void writeToFile(HashMap<String,Movie> list){
		try {
			FileWriter fout = new FileWriter("output.txt");
			fout.write("Output: \n");
			for (String id: list.keySet()){
				fout.write( list.get(id).toString()+"\n" );
			} 
			fout.close();
			System.out.println("\n Done printing to file");
		} catch (IOException e) {
			System.out.println("Error occurred ");
			e.printStackTrace();
		}
		
		
	}
}