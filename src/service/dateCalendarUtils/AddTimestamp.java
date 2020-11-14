package service.dateCalendarUtils;

import java.util.Calendar;
import java.util.Date;

public class AddTimestamp {
    public static void main(String args[]) {
        int fromPreviousHours = -8;
        int tillPreviousMinutes = -5;
        Date date = new Date();
       // System.out.println("current date and time "+date);
//        date.setTime(date.getTime()+(60000L*5L));
      //  System.out.println("After minutes date and time "+date);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE,tillPreviousMinutes);
        Date endTime = c.getTime();
       // System.out.println("End time "+endTime.toString());

        //c.clear();
        c.setTime(date);
        c.add(Calendar.HOUR,fromPreviousHours);
        Date startTime = c.getTime();
        //System.out.println("Start time "+startTime.toString());

        /*Date plus5 = c.getTime();
        System.out.println(plus5);
        System.out.println("After minutes date and time "+plus5);*/

        setTimeOut();


    }

    private static void setTimeOut() {
        Calendar c = Calendar.getInstance();
        System.out.println("Before timeout ,"+c.getTime());
        c.add(Calendar.SECOND,600*(-1));
        System.out.println("After timeout ,"+c.getTime());
    }
}
