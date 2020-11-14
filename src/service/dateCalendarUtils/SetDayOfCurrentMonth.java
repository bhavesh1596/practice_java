package service.dateCalendarUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class SetDayOfCurrentMonth {
    public static void main(String args[]) throws ParseException {
        final String date = "01";
        setDayInCurrentMonthAndYear(date);
    }

    private static Date setDayInCurrentMonthAndYear(String date) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.DAY_OF_MONTH,Integer.parseInt(date));
        return c.getTime();
    }
}
