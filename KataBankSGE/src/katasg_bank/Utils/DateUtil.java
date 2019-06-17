
package katasg_bank.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * class that groups all date object processing
 * the inheritance will be used to anticipate the future improvement,
 * in case other transactions :
 * <ul>
 *	 <li>Loan Money
 * 	 <li>Transfert Money
 * </ul>
 *@author  Nadjem Nadir
 *@version 1.0
 */


public class DateUtil {

	private static final  DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss"); 

	/**
	 * get the actual time as a date Object
	 * @return Date Object of actual time
	 */
	public static Date getActualDateAsDateObject(){
		return Calendar.getInstance().getTime();
	}
	/**
	 * get the actual time as a string
	 * @return String of the actual time
	 */
	public static String getActualDateAsString(){
		Date now = getActualDateAsDateObject();

		String strDate = dateFormat.format(now);  
		return strDate;
	}

	/**
	 * convert a date to a string
	 * @param date
	 * @return String 
	 */
	public static String getStringFromDate(Date date) { 
		String strDate = dateFormat.format(date);  
		return strDate;
	}
	/**
	 * convert a string as date
	 * @param stringDate
	 * @return
	 * @throws ParseException 
	 */

	public static Date getDateFromString(String stringDate) throws ParseException{
		Date date=dateFormat.parse(stringDate);  
		return date;
	}

}
