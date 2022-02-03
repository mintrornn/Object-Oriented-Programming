public class MyDate {
public int year;
public int month;
public int day;
public int objectNumber;
public static int objectCounter;
public static String[] strMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

MyDate(){
	this.year = 1900;
	this.month = 1;
	this.day = 1;
	objectCounter++;
	this.objectNumber = objectCounter;
}
MyDate(int aYear, int aMonth, int aDay){
	this.year = aYear;
	this.month = aMonth;
	this.day = aDay;
	objectCounter++;
	this.objectNumber = objectCounter;
}

public int getObjectNumber(){
	return objectNumber;
}
public void setDate(int aYear, int aMonth, int aDay){
	this.year = aYear;
	this.month = aMonth;
	this.day = aDay;
}
public void setYear(int aYear){
	this.year = aYear;
}
public void setMonth(int aMonth){
	this.month = aMonth;
}
public void setDay(int aDay){
	this.day = aDay;
}
public int getYear(){
	return year;
}
public int getMonth(){
	return month;
}
public int getDay(){
	return day;
}
public String toString(){
	String date = this.day + " " + strMonths[this.month-1] + " " + this.year;
	return date;
}

public static boolean isLeapYear(int year){
	if(year%4 != 0) {
		return false;
	}else if(year%100 != 0 ){
		return true;
	}else if(year%400 != 0) {
		return false;
	}else
		return true;
}

public MyDate nextDay() {
	if(this.month == 12 && this.day == 31) {
		this.year = this.year+1;
		this.month = 1;
		this.day = 1;
	}else {
		if(this.month == 4 ||this.month == 6 || this.month == 9 || this.month == 11) {
			if(this.day == 30){
				this.month = this.month+1;
				this.day = 1;
			}else {
				this.day = this.day+1;
			}
		}else if(this.month != 2){
			if(this.day == 31) {
				this.month = this.month+1;
				this.day = 1;
			}else {
				this.day = this.day+1;
			}
		}else {
			if(isLeapYear(year)== true && this.day == 29) 
			{
				this.month = this.month+1;
				this.day = 1;
			}
			else if(isLeapYear(year) == false && day == 28 ) {
				this.month=this.month+1;
				this.day=this.day+1;
			}
			else {
				this.day = this.day+1;
			}
		}
	}
	return this;
}
public MyDate nextMonth() {
	if(this.month == 12) {
		this.month = 1;
		this.year=this.year+1;
	}else {
		this.month = this.month+1;
	}
	return this;
}
public MyDate nextYear() {
	this.year = this.year+1;
	return this;
}

public MyDate previousDay() {
	if(this.month == 1 && this.day == 1) {
		this.year = this.year-1;
		this.month = 12;
		this.day = 31;
	}else {
		if(this.month == 5 || this.month == 7 || this.month == 10 || this.month == 12) {
			if(this.day == 1) {
				this.month = this.month-1;
				this.day = 30;
			}else {
				this.day = this.day-1;
			}
		}else if(this.month != 3) {
			if(this.day == 1) {
				this.month = this.month-1;
				this.day = 31;
			}else {
				this.day = this.day-1;
			}
		}else {
			if(isLeapYear(year) && this.day == 1) {
				this.month = this.month-1;
				this.day = 29;
			}else if(this.day == 1) {
				this.month = this.month-1;
				this.day = 28;
			}else {
				this.day = this.day-1;
			}
		}
	}
	return this;
}
public MyDate previousMonth() {
	
	if(this.month == 1) {
		this.month = 12;
		this.year = this.year-1;
	}else {
		this.month = this.month-1;
	}
	return this;
}

public MyDate previousYear() {

	if(isLeapYear(year) && this.day == 29 && this.month==2) {
		this.day = 28;
	}
	this.year = this.year-1;
	
	return this;
}

}
