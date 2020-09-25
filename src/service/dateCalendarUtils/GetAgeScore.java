package service.dateCalendarUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GetAgeScore {
    public static void main(String args[]) {
        try {
            Map<String, String> scoreMap = new HashMap<>();
            scoreMap.put("0-25", "93");
            scoreMap.put("26-30", "110");
            scoreMap.put("31-41", "119");
            scoreMap.put("42-51", "126");
            scoreMap.put("52+", "135");
            String maxAge = "52";
            String maxAgeKey = "52+";
            String ageScore = "";
            System.out.println("Enter Age : ");
            String age = new Scanner(System.in).next();
            int ageN = Integer.parseInt(age);
            if (ageN >= Integer.parseInt(maxAge)) {
                ageScore = scoreMap.get(maxAgeKey);
            } else {
                ageScore = getAgeScoreOf(ageN, scoreMap, maxAgeKey);
            }
            System.out.println("Age Score corresponding to age " + age + " is " + ageScore);
        }
        catch (Exception e) {
            System.out.println("Some error occured"+e.toString());
        }
    }

    private static String getAgeScoreOf(int ageN,Map<String,String> scoreMap,String maxAgeKey ){
        String ageScore ="";
        for(String key : scoreMap.keySet()) {
            if(key.equals(maxAgeKey)) {
                continue;
            }
            String [] range = key.trim().split("-");
            int lowerLimit = Integer.parseInt(range[0]);
            int upperLimit = Integer.parseInt(range[1]);
            if(ageN >= lowerLimit && ageN <= upperLimit) {
                ageScore = scoreMap.get(key);
                break;
            }
        }
        return ageScore;
    }
}
