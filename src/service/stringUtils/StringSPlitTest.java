package service.stringUtils;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class StringSPlitTest {
    static String score ="549";
    static String buckets [] = {"-540","541-599"};
    public static void main(String args[]) {
        /*for(String s : buckets) {
            String[] ss = s.trim().split("-");
            if(Integer.parseInt(score)>=Integer.parseInt(ss[0]) && Integer.parseInt(score)<=Integer.parseInt(ss[1])){
                System.out.println(s);
            }

        }*/



        String x = "National|1000,GCC|5,EXPAT|5";
        String y = "NATIONAL";
        System.out.println(getSimCap(x,y));
    }

    public  static  String getSimCap(String x, String y ) {
        String simCap = null;
        final String[] nationSimCapMap = x.split(",");
        for(final String nationSimCap : nationSimCapMap) {
System.out.println(nationSimCap);
                    final String[] nationSimCapSplit = nationSimCap.trim().split("\\|");
            System.out.println(nationSimCapSplit[0]);
            System.out.println(nationSimCapSplit[1]);
                    if(null != nationSimCapSplit && nationSimCapSplit[0].trim().equalsIgnoreCase(y.trim())) {
                        simCap =  nationSimCapSplit[1].trim();
                        break;
                    }
                }


        return simCap;
    }
}