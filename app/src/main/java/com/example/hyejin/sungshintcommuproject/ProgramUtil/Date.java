package com.example.hyejin.sungshintcommuproject.ProgramUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Date {

    public static String dateToString(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        return format.format(date);
    }

    public static java.util.Date stringToDate(String date){
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

}
