package service.dateCalendarUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String args[]) {

        System.out.println("Enter date of birth in dd-MM-yyy format : ");
        String dob = new Scanner(System.in).next();
        System.out.println(dob);
        if(null != dob) {
            String error = "";
            try {
                SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy");
                sf.setLenient(false);
                Date birthDate = sf.parse(dob);
                long birthMili = birthDate.getTime();
                Calendar c = Calendar.getInstance();
                c.setTimeInMillis(birthMili);
                int birthDayOfYear = c.get(Calendar.DAY_OF_YEAR);
                System.out.println("birthDayOfYear : "+birthDayOfYear);
                int birthYear = c.get(Calendar.YEAR);
                System.out.println("Birth Year : "+birthYear);
                Date currentDate = new Date();
                long currentMili = currentDate.getTime();
                c.setTimeInMillis(currentMili);
                int todayDayOfYear = c.get(Calendar.DAY_OF_YEAR);
                System.out.println("todayDayOfYear : "+todayDayOfYear);
                int currentYear = c.get(Calendar.YEAR);
                System.out.println("currentYear : "+currentYear);
                if(birthYear <= currentYear) {
                    int age =(currentYear - birthYear);
                    if( (todayDayOfYear < birthDayOfYear) && (age > 0) ) {
                        age-=1;
                    }
                    System.out.println("Age is "+age);
                }
                else {
                    error = "Birth Year cannot be greater than Current Year";
                }
            System.out.println(error);
            }
            catch (ParseException e) {
                System.out.println("Unable to parse date "+dob);
            }
        }
    }
}
