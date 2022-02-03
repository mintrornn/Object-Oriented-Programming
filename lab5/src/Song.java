public class Song {
	private String title;
	private double duration;
	
	public Song(String title, double duration) {
		this.title = title;
		this.duration = duration;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public double getDuration() {
		return this.duration;
	}
	
	public int getDurationInSec() {
		int sec=(int)duration;
		int sec2=(int)Math.round((duration-sec)*100);
		int sum=sec*60+sec2;
		return sum;
	}
	
	public String toString() {
		String a = title + ": " + duration + " minutes (" + getDurationInSec() + " seconds)";
		return a;
	}
}