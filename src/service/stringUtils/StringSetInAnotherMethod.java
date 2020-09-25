package service.stringUtils;

import java.util.UUID;

public class StringSetInAnotherMethod {
    String s;
    public static void main(String args[]) {
        Long first = 0L;
        passFirstToSecond(first);
        System.out.println("First method : "+first);
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString().length());
        System.out.println(uuid.toString().replaceAll("[^0-9]", "").length());

        String s = null;
        new StringSetInAnotherMethod().setString(s);
        System.out.println("String s : "+s);
    }

    private  void setString(String s) {
    this.s = s;
    }


    private static void passFirstToSecond(Long first) {
        first = System.currentTimeMillis();
        System.out.println("In 2nd method : "+first);
    }
}
