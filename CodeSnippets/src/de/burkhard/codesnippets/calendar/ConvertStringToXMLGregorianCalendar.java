package de.burkhard.codesnippets.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class ConvertStringToXMLGregorianCalendar {
	
	public static void main (String args[]) {
		String dateformatStr = "yyyy-MM-dd-hh.mm.ss.SSS";
		String dateString = "2015-10-02-23.59.59.999";
		TimeZone timezone = null;
		//timezone = TimeZone.getTimeZone("Europe/Berlin");
		boolean normalize = false;
		
		// Test 1
		XMLGregorianCalendar xmlgc = convertStringToXMLGregorianCalendar(dateString, dateformatStr, timezone, normalize);
		System.out.println(xmlgc.toString());
		
		// Test 2
		dateformatStr = "yyyy-MM-dd";
		xmlgc = convertStringToXMLGregorianCalendar(dateString, dateformatStr, timezone, normalize);
		System.out.println(xmlgc.toString());
	}
	
	public static XMLGregorianCalendar convertStringToXMLGregorianCalendar(String dateStr, String dateformatStr, final TimeZone timezone, boolean normalize) {
		XMLGregorianCalendar xmlgc = null;
		Date date = null;
		DateFormat df = new SimpleDateFormat(dateformatStr);
		try {
			date = df.parse(dateStr);
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(date.getTime());
			//gc.setTime(date);
			//xmlgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH)+1, gc.get(Calendar.DAY_OF_MONTH), gc.get(Calendar.HOUR_OF_DAY), gc.get(Calendar.MINUTE), gc.get(Calendar.SECOND), gc.get(Calendar.MILLISECOND), timezone == null ? DatatypeConstants.FIELD_UNDEFINED : timezone.LONG);
			//xmlgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc.get(Calendar.YEAR), gc.get(Calendar.MONTH)+1, gc.get(Calendar.DAY_OF_MONTH), date.getHours(), date.getMinutes(), date.getSeconds(), DatatypeConstants.FIELD_UNDEFINED, timezone == null ? DatatypeConstants.FIELD_UNDEFINED : timezone.LONG);
			xmlgc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
		} catch (ParseException pe) {
			System.out.println("Fehler beim parsen aufgetreten!");
		} catch (DatatypeConfigurationException dce) {
			System.out.println("DatatypeConfigurationException aufgetreten!");
		}
		return xmlgc;
	}

}
