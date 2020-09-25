package service.stringUtils;

public class StringReplaceTest {
    public static void main(String args[]) {
        String a = "Please deactivate the existing bundle {} and try activating the new bundle again {} {} {}";
        String b = a.replace("{}","National Data 10 GB");
        System.out.println(b);
    }
}
