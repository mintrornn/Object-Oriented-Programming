//Name: Intr-orn Lersupakitsin	
//ID: 6288089
//Section: 1

import java.util.ArrayList;
import java.lang.Math;
public class Kalculator {
	//******INSERT YOUR CODE HERE***********
	//Class attributes go here
	//**************************************

	private double Sum;
	private double Avg;
	private double Std;
	private double Max;
	private double Min;
	private ArrayList<Double> numList;

	/**
	 * Constructor is the fist method to be call at instantiation of a Kalculator object.
	 * If you need to initialize your object, do so here.
	 */
	Kalculator()
	{
		Sum = 0;
		Avg = 0;
		Std = 0;
		numList = new ArrayList<Double>();
	}
	
	/**
	 * Add number to the list of numbers. 
	 * @param number
	 */
	public void addNumber(double number)
	{	
		numList.add(number);
		//add number to the numList.	
	}
	
	/**
	 * Remove the least recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteFirstNumber()
	{
		if(numList.isEmpty()){ //check that is numList empty or not.
			 numList.clear(); //do nothing.	
		}else{
			numList.remove(0); 
			//remove the first position of array.
		}
	}
	
	/**
	 * Remove the most recently added number from the list. If the list is empty, do nothing.
	 */
	public void deleteLastNumber()
	{
		if(numList.isEmpty()){ //check that is numList empty or not.
			numList.clear(); // do nothing.
		}else{
			numList.remove(numList.size()-1); 
			//remove the number in array last position of the numList
		}
	}

	/**
	 * Calculate the summation of all the numbers in the list, then returns the sum. 
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getSum()
	{
		if(numList.isEmpty()){ //check that is numList empty or not.
			return 0;
		}else{
			for(int i=0;i<numList.size();i++){
				Sum += numList.get(i); //sum all of the number in numList.
			}
			return Sum;
		}
	}
	
	/**
	 * Calculate and return the average of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getAvg()
	{
		if(numList.isEmpty()){ //check that is numList empty or not.
			return 0;
		}else{
			Avg = Sum/numList.size(); //find the average by sum divided by size of array.
			return Avg;
		}
	}
	
	/**
	 * Calculate and return the sample standard deviation of all the numbers in the list.
	 * If the list has fewer than 2 numbers, return 0.
	 * @return
	 */
	public double getStd()
	{
		double a=0.0;
		if(numList.size()<2){
			return 0;  
		}else{
			for(int i=0;i<numList.size();i++){
				a += Math.pow(numList.get(i)-Avg, 2);
				//every number minus average and power by 2 and sum of it.
			}
			double b = numList.size()-1;
			//size of array minus 1
			Std = Math.sqrt(a/b);
			//square root the sum of every number minus average that power by 2 and size of array minus 1
        	return Std;
		}
	}
	
	/**
	 * Find and return the maximum of all the numbers in the list.
	 * If the list is empty, return 0.
	 * @return
	 */
	public double getMax()
	{
		if(numList.isEmpty()){ //check that is numList is empty or not.
			return 0;
		}else{
			Max = numList.get(0); //initialize that Max is the first position of array 
			for(int i=0;i<numList.size();i++){
				if(Max<numList.get(i)){ //check that which number is greater than
					Max = numList.get(i);  //initialize that the greater one is max
				}
			}
			return Max;
		}	
	}
	
	/**
	 * Find and return the minimum of all the numbers in the list.
	 * If the list is empty, return 0.
	 */
	public double getMin()
	{
		if(numList.isEmpty()){ //check that is numList is empty or not.
			return 0;
		}else{
			Min = numList.get(0);
			for(int i=0;i<numList.size();i++){
				if(Min>numList.get(i)){  //check that which number is less than
					Min = numList.get(i); //initialize that the less one is min
				}
			}
			return Min;
		}	
	}
	
	
	/**
	 * Find and return the maximum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the max k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMaxK(int k)
	{
		if(numList.size()<k){ //check that size of array is less than k or not.
			return null;
		}else{
			double[] maxk = new double[numList.size()];
			double wow;
			for(int i=0; i<numList.size(); i++){
				maxk[i]=numList.get(i); //substitute numList to maxk
			}
		for(int i=0;i<numList.size();i++){
			for(int j=0;j<numList.size()-i-1;j++){
				if(maxk[j]<maxk[j+1]){ //swap
					wow = maxk[j];
					maxk[j] = maxk[j+1];
					maxk[j+1] = wow;
				}
			}
		}
		double[] mintmk = new double[k];
		for(int i=0;i<k;i++){
			mintmk[i]=maxk[i]; //substitute maxk to mintmk
		}
		return mintmk;
		}		
	}
	
	/**
	 * Find and return the minimum k numbers of all the numbers in the list as an array of k double number.
	 * The order of the returned k numbers does not matter. (We only care if you can get the min k elements)
	 * If the list has fewer than k numbers, return null.
	 */
	public double[] getMinK(int k)
	{	
		if(numList.size()<k){ //check that size of array is less than k or not.
			return null;
		}else{
			double[] mink = new double[numList.size()];
			double xxx;
			for(int i=0; i<numList.size(); i++){
				mink[i]=numList.get(i); //substitute numList to mink
			}
			for(int i=0;i<numList.size();i++){
				for(int j=0;j<numList.size()-i-1;j++){
					if(mink[j]>mink[j+1]){
						xxx = mink[j]; //swap
						mink[j] = mink[j+1];
						mink[j+1] = xxx;
					}
				}
			}
		double[] tnimmk = new double[k];
			for(int i=0;i<k;i++){
				tnimmk[i]=mink[i]; //substitute mink to tnimmk
			}
			return tnimmk;
		}	
	}
	
	/**
	 * Print (via System.out.println()) the numbers in the list in format of:
	 * DATA[<N>]:[<n1>, <n2>, <n3>, ...]
	 * Where N is the size of the list. <ni> is the ith number in the list.
	 * E.g., "DATA[4]:[1.0, 2.0, 3.0, 4.0]"
	 */
	public void printData()
	{		
		System.out.print("DATA[" + numList.size() + "]: "+numList);
		System.out.println();	
	}
}