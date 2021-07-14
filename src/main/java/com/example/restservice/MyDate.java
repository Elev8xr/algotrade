package com.example.restservice;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;

public  class MyDate  {
  String dateTime;
    MyDate(){
    }

    public MyDate(String dateTime){

        this.dateTime = dateTime;
    }
//
    public static boolean isNumeric(String str) {
        ParsePosition pos = new ParsePosition(0);
        NumberFormat.getInstance().parse(str, pos);
        return str.length() == pos.getIndex();
    }

//This method is not done yet , it should be use to validate the DateString to make it always looks like dd/MM/yyyy
    private String Validate(){
        String[]checkDate = dateTime.split("/");
        if(!isNumeric(checkDate[1])){
            Date date = null;
            try {
                date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(checkDate[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH);

            checkDate[1] = Integer.toString(month);
            dateTime ="";
            for(int i=0;i<checkDate.length;i++){
                dateTime += checkDate[i];
                dateTime += '/';
            }

        }

        if(checkDate.length ==2){
            dateTime +="/2021";
        }

        return dateTime;
    }



    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public static Date ConvertStringToDate(String date) throws ParseException {
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
       Date finalDate = simpleDateFormat.parse(date);

        return finalDate;

    }
    //template method should be replaced with method that validate all the date form
    public static Date ConvertCNBCStringToDate(String date) throws ParseException {
        String[] temp1 = date.split(",");
        String[] fullDate = temp1[1].split(" ");
        String month = fullDate[1];
        String day = fullDate[2];
        String year = "";
        for(int i=0;i<4;i++)
            year += fullDate[3].charAt(i);
        String finalDate =month+"/"+day+"/"+year;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM/dd/yyyy");
        return simpleDateFormat.parse(finalDate);
    }
    //template method should be replaced with method that validate all the date form
    public static Date ConvertMoneyWeekStringToDate(String date) throws ParseException {
        String[] temp = date.split("-");
        String day =temp[0];
        String month = temp[1];
        String year = temp[2];
        String finalDate = month+"/"+day+"/"+year;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM/dd/yy");
        return simpleDateFormat.parse(finalDate);
    }
}
