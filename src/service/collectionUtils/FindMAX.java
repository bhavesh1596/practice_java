package service.collectionUtils;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMAX {
    /*
     *
     *999.1899897
999.1883291
999.1849976
999.1566671
999.1208293
999.1141764
     *
     */

    public static void main (String args[]) {
        List<String> ccScoreList = new ArrayList<>(Arrays.asList("999.1141764","999.1208293","999.1566671","1000","1000.0111111111111111111111111"));
        double max = -1;
        for(String x : ccScoreList) {
                double num = new BigDecimal(x).doubleValue();
                if(num > max) {
                    max = num;
                }
            }
            System.out.println(max);
String doubleStr = "1000.0111111111111111111111111";
Double d = Double.parseDouble(doubleStr);
        System.out.println(d);
        System.out.println(String.valueOf(max).equals(d.toString()));
        }

    }

