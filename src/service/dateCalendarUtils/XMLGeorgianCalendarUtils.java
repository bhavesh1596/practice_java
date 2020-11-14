package service.dateCalendarUtils;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.*;


public class XMLGeorgianCalendarUtils {
    public static void main(String args[]) throws DatatypeConfigurationException {
        TimeZone tz = TimeZone.getTimeZone("GMT+9:00");
        Locale loc = new Locale("en", "IN", "IN");
        Calendar calendar = Calendar.getInstance(loc);
        GregorianCalendar gc = (GregorianCalendar) calendar;
        System.out.println(gc.toString());
        Date d = gc.getTime();
        System.out.println(d.toString());


        DatatypeFactory df = DatatypeFactory.newInstance();
        XMLGregorianCalendar xmlGregorianCalendar = df.newXMLGregorianCalendar(gc);
        final Date time = xmlGregorianCalendar.toGregorianCalendar().getTime();
        System.out.println(time.toString());



    }
}
