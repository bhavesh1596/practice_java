package service.collectionUtils;

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class HashMapUtils {

    public static void main(String args[]) {
        Map<String , String> customerNationalityClassMap = new HashMap<>();
        customerNationalityClassMap.put("NATIONAL","United Arab Emirates");
        customerNationalityClassMap.put("GCC","Saudi Arabia, Qatar, Kuwait, Oman, Bahrain");
        customerNationalityClassMap.put("EXPAT","Others");

        String getMappedKey = getMapKeyOf("ins",customerNationalityClassMap);
        System.out.println(getMappedKey);


    }

    private static String getMapKeyOf(String country, Map<String, String> customerNationalityClassMap) {
        String selected = null;
        point:
        for(String key : customerNationalityClassMap.keySet()) {
            final String s = customerNationalityClassMap.get(key);
            final String[] split = s.split(",");
            System.out.println(split.length);
            for(String ss : split) {
                if(country.trim().equalsIgnoreCase(ss.trim())) {
                    selected = key;

                }
                break point;
            }

        }
        if(null == selected) {
            selected = "EXPAT";
        }

return selected;
    }
}
