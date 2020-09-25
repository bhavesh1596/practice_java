package service.dateCalendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParseTest {
    public static void main(String args[]) throws ParseException {
       String dob = "15-14-2";
       SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        sf.setLenient(false);
        Date parseDate =sf.parse(dob);
        System.out.println(parseDate);
    }
}
