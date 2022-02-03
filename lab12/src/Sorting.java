import java.util.*;
import java.io.*;

public class Sorting {
	
	public static List<String> keep;
	
	public static List<String> Reading(String TextFile){
		
//		File file = new File(TextFile);
				
		//read file
//		BufferedReader reader = null;
		try{
			BufferedReader reader = new BufferedReader(new FileReader(TextFile));
			String line = "";
			
			while((line=reader.readLine()) != null){
				String[] reline = line.split(",");
				keep = new LinkedList <String> (Arrays.asList(reline));
			}
			reader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return keep;
	}
	
	//public static List<String> keep;
	
	public static void Printing(List<String> PrintList){
		System.out.println("Original:" + PrintList);
	}
	
	public static void Sort(List<String> SortList){
		for(int i=0;i<keep.size()-1;i++){
			for(int j=0;j<keep.size()-i-1;j++){
				if(keep.get(j).compareTo(keep.get(j+1))<0){
					String temp = keep.get(j);
					keep.set(j,keep.get(j+1));
					keep.set(j+1, temp);
				}
			}
			System.out.println("Pass" + (i+1) + ":" + SortList);
		}
	}
	
	public static void main(String[] args){
		List<String> sorted_lines = Reading("mint.txt");
		Printing(sorted_lines);
		Sort(sorted_lines);
	}
	
}
