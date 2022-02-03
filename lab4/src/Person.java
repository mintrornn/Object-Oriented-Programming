public class Person {
public String firstname;
public String lastname;
public MyDate birthday;
	
Person(String afirstname, String alastname){
	this.firstname = afirstname;
	this.lastname = alastname;
}
Person(String afirstname, String alastname, int aYear, int aMonth, int aDay){
	this.firstname = afirstname;
	this.lastname = alastname;
	this.birthday = new MyDate(aYear, aMonth, aDay);
}
public int getAge(MyDate aDate){
	return MyDate.yearDiff(birthday, aDate);
}
public boolean isEligible(MyDate elecDate){
	if(getAge(elecDate) >= 18){
		return true;
	}else
		return false;
}

public void printPersonInfo(){
	System.out.println("Person: " + this.firstname + " " + this.lastname);
	System.out.println("Birthday: " + birthday.toString());
}

}