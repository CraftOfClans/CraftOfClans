package com.icraftgames.main;

import java.util.Date;

public class SystemTime {
	
	/*
	 * How to use this:
	 * 
	 * 1) Use getSystemTime() or new Date() to get a new date object with the current time.
	 * 2) Use durationToMilliseconds to get the number of milliseconds you want whatever you are timing to last.
	 * 3) Use getDateWhenFinished (dateFromStep1, durationFromStep2) to get the date object for when your upgrade/troop training/whatever will be finished.
	 */
	
	/**
	 * @return
	 * System time
	 */
	public static Date getSystemTime () {
		return new Date();
	}
	
	/**
	 * Gets the Date object for the given number of milliseconds past the given Date object.
	 * 
	 * @param startingDate
	 * Starting date
	 * @param duration
	 * Duration in milliseconds
	 * @return
	 * Final date
	 */
	public static Date getDateWhenFinished (Date startingDate, long duration) {
		return new Date(startingDate.getTime() + duration);
	}
	
	/**
	 * Calculates the number of milliseconds for the given number of days, hours, minutes, and seconds.
	 * 
	 * @param days
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return
	 * millisecond value for the given duration
	 */
	public static long durationToMilliseconds (int days, int hours, int minutes, int seconds) {
		long milliseconds = 0;
		
		milliseconds = milliseconds + (days * 86400000);
		milliseconds = milliseconds + (hours * 3600000);
		milliseconds = milliseconds + (minutes * 60000);
		milliseconds = milliseconds + (seconds * 1000);
		
		return milliseconds;
	}
	
	/**
	 * Gets the number of milliseconds until the given date.
	 * 
	 * @param endTime
	 * End date
	 * @return
	 * Milliseconds until endTime
	 */
	public static long timeRemaining (Date endTime) {
		return endTime.getTime() - new Date().getTime();
	}
	
	/**
	 * Checks if the given instant has already passed.
	 * 
	 * @param endTime
	 * Date to check
	 * @return
	 * True if the given instant is before the current instant. Otherwise, it returns false.
	 */
	public static boolean hasPassed (Date endTime) {
		return new Date().after(endTime);
	}
}
