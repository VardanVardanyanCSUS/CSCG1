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