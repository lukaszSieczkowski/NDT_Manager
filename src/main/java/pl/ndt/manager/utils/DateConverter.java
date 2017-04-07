package pl.ndt.manager.utils;

import java.time.LocalDateTime;

public class DateConverter {

	/**
	 * Convents date from String to LocalDateTime object
	 * 
	 * @param dateInString
	 *            Date in String
	 * @param hour
	 *            Hours
	 * @param min
	 *            Minutes
	 * @return date
	 */
	public LocalDateTime createDateFromString(String dateInString, int hour, int min) {

		int day = Integer.parseInt(dateInString.substring(0, 2));

		int month = Integer.parseInt(dateInString.substring(3, 5));
		int year = Integer.parseInt(dateInString.substring(6, 10));
		LocalDateTime date = LocalDateTime.of(year, month, day, hour, min);

		return date;
	}

	/**
	 * Convents date from LocalDateTime object to String
	 * 
	 * @param localDateTime
	 *            date
	 * @return date
	 */
	public String createDateToString(LocalDateTime localDateTime) {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append(localDateTime.toString().substring(8, 10));
		stringBuilder.append(localDateTime.toString().substring(7, 8));
		stringBuilder.append(localDateTime.toString().substring(5, 7));
		stringBuilder.append(localDateTime.toString().substring(4, 5));
		stringBuilder.append(localDateTime.toString().substring(0, 4));

		return stringBuilder.toString();
	}
}
