import java.util.ArrayList;
public class Member {
	private String email;
	private String password;
	private ArrayList<Video> vdoList;
	
	Member(String email, String password){
		vdoList = new ArrayList<Video>();
		this.email = email;
		this.password = password;
	}
	
	public boolean addVideo(Video vdo){
		if(vdo == null){
			return false;
		}else{
			vdoList.add(vdo);
			return true;
		}	
	}
	
	public boolean removeVideo(Video vdo){
		for(int i=0;i<vdoList.size();i++){
			if(vdoList.get(i).equals(vdo)){
				vdoList.remove(i);
				System.out.println(vdo.toString() + " is succesfully removed.");
				return true;
			}
		}
		return false;
	}
	
	public void printMemberInfo(){
		System.out.println("Email: " + email + " (pwd: " + password + ")");
		System.out.println("List of Videos");
		for(int i=0;i<vdoList.size();i++){
			System.out.println("["+(i+1)+"]"+vdoList.get(i));
		}
	}	
}