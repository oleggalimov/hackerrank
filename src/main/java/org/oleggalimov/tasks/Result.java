package main.java.org.oleggalimov.tasks;

import java.time.format.TextStyle;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Result {


    /*
    java-date-and-time
    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */
    public static String findDay(int month, int day, int year) {
        //Field number for get and set indicating the month. This is a calendar-specific value.
        // The first month of the year in the Gregorian and Julian calendars is JANUARY which is 0; the last depends on the number of months in a year.
        return new GregorianCalendar(year, month-1, day).getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.US).toUpperCase();
    }


}