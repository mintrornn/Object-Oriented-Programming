import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.commons.io.FileUtils;

public abstract class NameSearcher {

	protected static ArrayList<String> readNames = null;
	protected int number_of_compared = 0; 
	
	NameSearcher(String filename)
	{
		try {
			readNames = (ArrayList<String>) FileUtils.readLines(new File(filename), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//clean word
        readNames.replaceAll(name -> name.toLowerCase());  
        	
	}

	public int getNumComparisons() {
		return number_of_compared;
	}

	public void resetCompareCounter() {
		number_of_compared = 0;
	}
	
    public void sortWord() {
	   //TODO
    	Collections.sort(readNames);
    }

	public abstract String find(String query);
}

class LinearNameSearcher extends NameSearcher{

	LinearNameSearcher(String filename) {
		super(filename);
	}

	@Override
	public String find(String query) {
		for(int i=0;i<readNames.size();i++) {
			number_of_compared++;
			if(query.toLowerCase().compareTo(readNames.get(i))==0) {
				return "Found: '" + query + "'AT_INDEX(" + i + ")";
			}
		}
		return "Not Found Name: '" + query + "'";
	}	
}

class BinaryNameSearcher extends NameSearcher{

	BinaryNameSearcher(String filename) {
		super(filename);
	}

	@Override
	public String find(String query) {
		int first = 0; 
		int last = readNames.size()-1;
		while(first<=last) {
			int mid = (first+last)/2;
			number_of_compared++;
			if(query.compareToIgnoreCase(readNames.get(mid))==0) {
				return "Found: '" + query + "' AT_INDEX(" + mid + ")";
			}
			if(query.compareToIgnoreCase(readNames.get(mid))>0) {
				first = mid + 1;
			}else {
				last = mid - 1;
			}
		}
		return "Not Found Name: '" + query + "'";
	}
	
	
}


