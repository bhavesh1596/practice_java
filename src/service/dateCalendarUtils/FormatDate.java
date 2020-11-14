package service.dateCalendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    public static void main(String args[]) throws ParseException {
        System.out.println(formatDate(new Date(),"yyyyMMdd"));
    }

    private static Date formatDate(Date date , String pattern) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(pattern);
        String formmatedDateString = sf.format(date);
        System.out.println(formmatedDateString);
        return parseDate(formmatedDateString,pattern);
    }

    public static Date parseDate(String date, String datePattern) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(datePattern);
        sf.setLenient(false);
        Date parseDate = sf.parse(date);
        return parseDate;
    }
}


