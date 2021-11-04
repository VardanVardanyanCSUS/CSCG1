package collections;

//import java.io.*;
import java.util.HashMap;
//import java.io.IOException;


public class MovieCollections{
	private MovieCollections movie = null;
	private HashMap<String,Movie> movieMap = null;
	
	public MovieCollections() {
		movieMap = new HashMap<String,Movie>();
	}
	
	public void addNewMovie(Movie movie) {
		movieMap.put(movie.getId(), movie);
	}
	
	public HashMap<String,Movie> getMovies(){
		return movieMap;
	}
	
	public Movie getMovieById(String id) {
		return movieMap.get(id);
	}
	
	
}