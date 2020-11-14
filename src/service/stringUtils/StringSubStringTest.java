package service.stringUtils;

public class StringSubStringTest {
    public static void main(String args[]) {
        String machineReadZone = "ILARE09221645507841978158768557804230M2012157PSE<<<<<<<<<<<5ZAQOUT<<MOHAMMED<N<A<<<<<<<<<<";
        String eid = machineReadZone.substring(15,30);
        System.out.println(eid);
        String dob = machineReadZone.substring(31,37);
        System.out.println(dob);
        String exp = machineReadZone.substring(39,45);
        System.out.println(exp);
        String nationality = machineReadZone.substring(46,49);
        System.out.println(nationality);

    }
}
