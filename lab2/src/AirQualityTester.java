import java.time.LocalDateTime;
public class AirQualityTester {
	
	public static void main(String[] args) {
		AirQualityProfile Bangkok= new AirQualityProfile(LocalDateTime.now(), null, 0, 0, 0);
		Bangkok.setDatetime(LocalDateTime.now());
		Bangkok.setLocation("Bangkok");
		Bangkok.setAqi(74);
		Bangkok.setPm25(23);
		Bangkok.setTemp(32.0);
		Bangkok.printAirQualityInfo();
		
		AirQualityProfile Tokyo= new AirQualityProfile(LocalDateTime.now(), null, 0, 0, 0);
		Tokyo.setDatetime(LocalDateTime.now());
		Tokyo.setLocation("Tokyo");
		Tokyo.setAqi(78);
		Tokyo.setPm25(25);
		Tokyo.setTemp(11.0);
		Tokyo.printAirQualityInfo();
		
		System.out.println(AirQualityProfile.count);
	}
}