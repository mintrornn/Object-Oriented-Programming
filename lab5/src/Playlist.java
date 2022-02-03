// Name:Intr-orn lertsupakitsin Section1
// ID: 6288089
import java.util.ArrayList;
public class Playlist {

	private String name;
	private int duration;
	private ArrayList<Song> songs;
	
	
	public Playlist(String name) {
		this.name = name;
		songs = new ArrayList<Song>();
	}
	
	public void addSong(Song aSong) {
		songs.add(aSong);
	}
	
	public void addSongAtIndex(Song aSong, int index) {
		if(index > songs.size()){
			System.out.println("Error: couldn't add song at index" + index);
		}else{
			songs.add(index, aSong);
		}
	}
	
	public boolean removeSongByIndex(int index) {
		if(index > songs.size()){
			System.out.println("Error: index is invalid");
		}else
			songs.remove(index);
			return true; 
	}	
	
	public boolean removeSongByTitle(String title) {
		for(int i=0;i<songs.size();i++) {
			if(songs.get(i).getTitle()==title) {
				songs.remove(i);
				return true;
			}
		}
		System.out.println("Error: The title is not found");
		return false;
		
	}	
	
	public void moveUp(int current) {
		songs.add(current-1,songs.get(current));
		songs.remove(current+1);
	}	
	
	public void moveDown(int current) {
		songs.add(current, songs.get(current+1));
		songs.remove(current+2);
	}	
	
	public int getPlaylistDuration() {
		duration=0;
		for(int i=0;i<songs.size();i++) {
			duration += songs.get(i).getDurationInSec();
		}
		return duration;
	}	
	
	public void showPlaylist() {
		System.out.println(name);
		for(int i=0;i<songs.size();i++) {
			System.out.print("[" + i + "]");
			Song jam = songs.get(i);
			System.out.println(jam.toString());
		}
		System.out.println("Total duration is " + (double)(getPlaylistDuration()/60+(double)(getPlaylistDuration()%60)/100) + " minutes");
	}
}