package service.dateCalendarUtils;

import java.util.Calendar;
import java.util.Date;

public class AddTimestamp {
    public static void main(String args[]) {
        Date date = new Date();
        System.out.println("current date and time "+date);
//        date.setTime(date.getTime()+(60000L*5L));
      //  System.out.println("After minutes date and time "+date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE,5);
        Date plus5 = c.getTime();
        System.out.println(plus5);
        System.out.println("After minutes date and time "+plus5);

    }
}
