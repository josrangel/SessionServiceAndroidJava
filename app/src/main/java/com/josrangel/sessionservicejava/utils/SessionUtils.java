package com.josrangel.sessionservicejava.utils;

import java.util.Calendar;

/**
 * Source:
 * https://www.delftstack.com/es/howto/java/how-to-get-the-current-date-time-in-java/
 * https://stackoverflow.com/questions/4905416/how-do-i-add-one-month-to-current-date-in-java
 * https://stackoverflow.com/questions/5369682/how-to-get-current-time-and-date-in-android
 * https://www.tutorialspoint.com/subtract-minutes-from-current-time-using-calendar-add-method-in-java
 * https://www.javatpoint.com/how-to-compare-dates-in-java
 */

public class SessionUtils {
    private SessionUtils() {}

    public static Calendar getCurrentTime() {
        return Calendar.getInstance();
    }

    public static Calendar getTimePlusTimeSession() {
        Calendar timeNow = getCurrentTime();
        timeNow.add(Calendar.MINUTE, 15);
        return timeNow;
    }

    public static boolean timeInRangeSession(Calendar timeSession) {
        return getCurrentTime().before(timeSession);
    }

}
