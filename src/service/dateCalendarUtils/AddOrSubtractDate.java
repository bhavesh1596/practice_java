package service.dateCalendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddOrSubtractDate {
    public static void main(String args[]) throws ParseException {
      /* String dob = "15-14-2";
       SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
        sf.setLenient(false);
        Date parseDate =sf.parse(dob);
        System.out.println(parseDate);*/

        String date = "30/09/2020";
        String datePattern = "dd/MM/yyyy";
        Date yyyymmddParsedDate = parseDate(date,datePattern);
        System.out.println(yyyymmddParsedDate.before(new Date()));
        Calendar c = null;
        if(yyyymmddParsedDate.before(new Date())){

            c  = Calendar.getInstance();
            c.setTime((yyyymmddParsedDate));
        }
        else {
            c = Calendar.getInstance();
            c.setTime((yyyymmddParsedDate));
            c.add(Calendar.MONTH,-1);

        }
        Date calcDate = c.getTime();
        if(null != calcDate) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            System.out.println(sdf.format(calcDate));

        }

    }

    public static Date parseDate(String date, String datePattern) throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(datePattern);
        sf.setLenient(false);
        Date parseDate = sf.parse(date);
        return parseDate;
    }
}
