import java.util.Scanner;
public class palindrome {
	public static void main(String[] args){
		String original, reverse = "";
		Scanner word = new Scanner(System.in);
			System.out.println("Enter a word or phrase to check if it is a palindrome: ");
		original = word.nextLine();
	
		int length = original.length();
		for(int i=length-1;i>=0;i--){
			//This will return the i char of the string like a reverse
			reverse = reverse + original.charAt(i);	
		}
		if(original.replaceAll("\\s+","").equalsIgnoreCase(reverse.replaceAll("\\s+", ""))){
			System.out.println("The input word “"+ original+"”is a palindrome.");
		}else{
			System.out.println("The input word “"+ original+"”is not a palindrome.");
		}

	}
}
