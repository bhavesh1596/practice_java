package service.dateCalendarUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateBeforeAfter {
    public static void main(String args[]) throws ParseException {
        final String date = "29";
        Date beenSetDate = setDayInCurrentMonthAndYear(date);
        System.out.println(beenSetDate);
        System.out.println("Date set is before current date "+beenSetDate.before(new Date()));
        System.out.println("Date set is after current date "+beenSetDate.after(new Date()));
        if(beenSetDate.after(new Date())) {
            Date oneMonthAGo = setOneMonthAgosDate(beenSetDate);
            System.out.println(oneMonthAGo);
        }
    }

    private static Date setOneMonthAgosDate(Date beenSetDate) {
        Calendar c = Calendar.getInstance();
        c.setTime(beenSetDate);
        c.add(Calendar.MONTH,-1);
        return c.getTime();
    }

    private static Date setDayInCurrentMonthAndYear(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date));
        return c.getTime();
    }
}
