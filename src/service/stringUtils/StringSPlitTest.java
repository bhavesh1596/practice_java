package service.stringUtils;

public class StringSPlitTest {
    static String score ="549";
    static String buckets [] = {"-540","541-599"};
    public static void main(String args[]) {
        for(String s : buckets) {
            String[] ss = s.trim().split("-");
            if(Integer.parseInt(score)>=Integer.parseInt(ss[0]) && Integer.parseInt(score)<=Integer.parseInt(ss[1])){
                System.out.println(s);
            }

        }
    }
}