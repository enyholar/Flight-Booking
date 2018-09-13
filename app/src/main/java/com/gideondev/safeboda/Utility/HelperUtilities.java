/*************************************************************************************************
 * JANUARY 8, 2018
 * Mentesnot Aboset
 * ************************************************************************************************/
package com.gideondev.safeboda.Utility;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelperUtilities {

    public static boolean isEmptyOrNull(String param) {
        if (param == null || param.trim().equals("")) {
            return true;
        }
        return false;
    }

    public static boolean isString(String data) {

        if (data.matches("\\d+(?:\\.\\d+)?")) {
            return false;
        }

        return true;
    }


    public static String formatDate(int y, int m, int d){

        try{
            String date = d + "/" + (m+1) +"/" + y;
            Date date1= new SimpleDateFormat("dd/MM/yyyy").parse(date);
            DateFormat fullDf = DateFormat.getDateInstance(DateFormat.FULL);

            return fullDf.format(date1);

        }catch(Exception e){

        }

        return null;
    }

    public static int currentYear(){

        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    public static int currentMonth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH);
    }

    public static int currentDay(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }



    public static String capitalize(String str) {
        return str.length() == 0 ? str : str.substring(0, 1).toUpperCase() + str.substring(1);
    }
    //TODO Filter the string of special characters
    public static String filter(String input) {
        if (!hasSpecialChars(input)) {
            return (input);
        }
        StringBuilder stringBuilder = new StringBuilder(input.length());
        char c;

        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            switch (c) {
                case '<':
                    stringBuilder.append("&lt;");
                    break;
                case '>':
                    stringBuilder.append("&gt;");
                    break;
                case '"':
                    stringBuilder.append("&quot;");
                    break;
                case '\'':
                    stringBuilder.append("&apos;");
                    break;
                case '&':
                    stringBuilder.append("&amp;");
                    break;
                default:
                    stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();

    }

    //TODO filter special Chars input.
    private static boolean hasSpecialChars(String input) {

        Pattern regexSpecialChars = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher inputStr = regexSpecialChars.matcher(input);
        boolean hasSpecialChars = inputStr.find();

        if (!hasSpecialChars) {
            return false;
        }

        return true;
    }


    public static Double calculateTotalFare(double startTravelFare, double returnFare, int numTraveller){
        return (startTravelFare + returnFare) * numTraveller;
    }

    public static Double calculateTotalFare(double fare, int numTraveller){
        return fare * numTraveller;
    }
    //TODO Compare the departure and return Date.
    public static boolean compareDate(String departureDate, String returnDate){

        try{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = simpleDateFormat.parse(departureDate);
            Date date2 = simpleDateFormat.parse(returnDate);

            if (date2.before(date1)) {
                return true;
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

}
