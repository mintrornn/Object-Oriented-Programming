import java.time.LocalDateTime;
public class AirQualityProfile {
	public static int count=0;
	private LocalDateTime datetime;
	private String location;
	private int aqi;
	private int pm25;
	private double temp;

	//constructor method
	public AirQualityProfile(LocalDateTime dt, String loc, int aq, int pm, double tempp) {
	datetime = dt;
	location = loc;
	aqi = aq;
	pm25 = pm;
	temp = tempp;	
	count++;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getAqi() {
		return aqi;
	}

	public void setAqi(int aqi) {
		this.aqi = aqi;
	}

	public int getPm25() {
		return pm25;
	}

	public void setPm25(int pm25) {
		this.pm25 = pm25;
	}

	public double getTemp() {
		return temp;
	}

	public void setTemp(double temp) {
		this.temp = temp;
	}
	public boolean isUnhealthy(int aqi){
		if(aqi>100){
			return true;
		}else
			return false;
	}
	public void isPM25(){
		if(pm25>50){
			System.out.println("Stay at home");
		}else
			System.out.println("can go outside");
	}
	
	
	public void printAirQualityInfo() {
	System.out.println(getLocation()+" at "+ datetime);
	System.out.println("AQI: "+getAqi()+" PM2.5:"+getPm25()+" microgram/m3");
	System.out.println("Temperature: "+ getTemp()+" Celcius\n");
	}
	
}	
