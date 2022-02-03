public class FreeMember extends Member {
	private int FREE_LIMITED_VDOs;
	private int numDownloadedVDO;
	
	FreeMember(String email, String password){
		super(email, password);
		FREE_LIMITED_VDOs = 3; 
		numDownloadedVDO = 0;
	}
	
	public boolean addVideo(Video vdo){
		if(numDownloadedVDO == FREE_LIMITED_VDOs){
			System.out.println(vdo.toString() + "cannot be downloaded because the number of video is reaching the limit");
			return false;
		}else{
			super.addVideo(vdo);
			numDownloadedVDO++;
			return true;
		}
	}
	
	public boolean removeVideo(Video vdo){
		if(super.removeVideo(vdo)){
			numDownloadedVDO--;
			return true;
		}else{
        return false;
      }
	}
	
	public void printMemberInfo(){
		System.out.println("---- FREE MEMBER ----");
		super.printMemberInfo();
		System.out.println("---------------------");
	}
	
	public int getNumVideo(){
		return numDownloadedVDO;
	}
	
	
}