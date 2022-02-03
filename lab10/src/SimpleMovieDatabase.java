
import java.io.*;
import java.util.*;


//import org.apache.commons.io.FileUtils;

public class SimpleMovieDatabase {
	public Map<Integer, Movie> movies = null;
	
	public void importMovies(String movieFilename)
	{	//YOUR CODE GOES HERE
		this.movies = new HashMap<Integer,Movie>();
		File file = new File(movieFilename);
				
		//read file
		BufferedReader reader = null;
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
					
			String line = null;
			
			while((line=reader.readLine()) != null)
			{	line = line.trim(); //remove space
				if(line.isEmpty()) continue;
				String[] x = line.split(","); //remove ,
				if(x[0].matches("[0-9]+")==true && x[1].charAt(0)!=' '){
					int y = Integer.parseInt(x[0]);
					Movie z = new Movie(y,x[1]);
					movies.put(y, z);
					String[] xxx = x[2].split("\\|");
					z.tags.addAll(Arrays.asList(xxx));
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	
	//-------------------BONUS----------------------
	public List<Movie> searchMovies(String query) 
	{
		List<Movie> a = new ArrayList<Movie>();
		for(Movie b : movies.values()){
			String c = b.title.toLowerCase();
			String d = query.toLowerCase();
			if(c.contains(d)){
				a.add(b);
			}
		}
		return a;
	}
	
	public List<Movie> getMoviesByTag(String tag)
	{
		//YOUR BONUS CODE GOES HERE
		List<Movie> a = new ArrayList<Movie>();
		for(Movie b: movies.values()){
			for(String e: b.tags){
			String c = e.toLowerCase();
			String d = tag.toLowerCase();
				if(c.contains(d)){
					a.add(b);
				}
			}
		}
		return a;
	}
	
	
	public static void main(String[] args)
	{
		SimpleMovieDatabase mdb = new SimpleMovieDatabase();
		mdb.importMovies("lab10_movies.txt");
		System.out.println("Done importing "+mdb.movies.size()+" movies");
		int[] mids = new int[]{139747, 141432, 139415, 139620, 141305};
		for(int mid: mids)
		{
			System.out.println("Retrieving movie ID "+mid+": "+mdb.movies.get(mid));
		}
		
		//Uncomment for bonus
		System.out.println("\n////////////////////////// BONUS ///////////////////////////////");
		String[] queries = new String[]{"america", "thai", "thailand"};
		for(String query: queries)
		{
			System.out.println("Results for movies that match: "+query);
			for(Movie m: mdb.searchMovies(query))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		String[] tags = new String[]{"Musical", "Action", "Thriller"};
		for(String tag: tags)
		{
			System.out.println("Results for movies in category: "+tag);
			for(Movie m: mdb.getMoviesByTag(tag))
			{
				System.out.println("\t"+m);
			}
			System.out.println();
		}
		
		
	}

}
