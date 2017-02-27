/**
 * 
 */
package com.org.practice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author Anudeep Kumar
 *
 */
public class DayCheck {

	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		GregorianCalendar gc= new GregorianCalendar();
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		Date today=new Date(117, 0, 22);
		Date today1=new Date(117, 0, 23);
		Date today2=new Date(117, 0, 24);
		Date today3=new Date(117, 0, 25);
		Date today4=new Date(117, 0, 26);
		Date today5=new Date(117, 0, 27);
		Date today6=new Date(117, 0, 28);
		Calendar c =Calendar.getInstance();
		Calendar c1 =Calendar.getInstance();
		c.setTime(today2);
		c1.setTime(sd.parse("26-01-2017"));
		System.out.println(c1.get(Calendar.MONTH));
		System.out.println(c1.get(Calendar.DATE));
		System.out.println(c1.get(Calendar.YEAR));
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.MONDAY);
		System.out.println(Calendar.TUESDAY);
		System.out.println(Calendar.WEDNESDAY);
		System.out.println(Calendar.THURSDAY);
		System.out.println(Calendar.FRIDAY);
		System.out.println(Calendar.SATURDAY);
		System.out.println(today);
		if(today.getDay()==0||today.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		if(today1.getDay()==0||today1.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		if(today2.getDay()==0||today2.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		if(today3.getDay()==0||today3.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		if(today4.getDay()==0||today4.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		if(today5.getDay()==0||today5.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		if(today6.getDay()==0||today6.getDay()==6){
			System.out.println("I am not a week day"+ " "+today.getDay());
		}
		else {
			System.out.println("I am weekday");
		}
		
	}

}
