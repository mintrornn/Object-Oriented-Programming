import java.util.ArrayList;
public class PremiumMember extends Member{
	   private double fee;
	   private double Family_FEE = 80.00;
	   private ArrayList<String> family;
	   
	   PremiumMember(String email, String password, double fee){
		   super(email, password);
		   this.fee = fee;
		   family = new ArrayList<String>();
	   }
	   
	   public boolean addFamily(String username){
		  if(family.contains(username)||family.size()==2){
			   System.out.println("use: " + username + " cannot be added, the Family user is reached the limit");
			   return false;
		   	}else{
			   family.add(username);
			   System.out.println(username + " is added successfully.");
			   return true;
		   	}
		}
	   
	   public boolean removeFamily(String username){
			   if(family.contains(username)){
				   family.remove(username);
				   System.out.println(username + " is removed successfully.");
				   return true;
			   }else{
				   System.out.println("user: " + username + " does not exists and cannot be removed.");
				   return false;
			   }
	   }
	   
	   public double getMonthlyBill(){
		   double sum = fee + (Family_FEE * family.size());
		   return sum;
	   }
	   
	   public void printMemberInfo(){
		   System.out.println("---- Premium MEMBER ----");
		   System.out.println("Member fee: " + fee);
		   super.printMemberInfo();
		   if(family.size()==0)
		   {
		   System.out.println("---------------------");
		   }else {
			   System.out.println("---------------------");
		   System.out.println("List of family");
		   
		   for(int i=0;i<family.size();i++){
			   System.out.println(family.get(i) + ",");
		   }
		   }
	   }

	

}