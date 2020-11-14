package service.mathUtils;

import java.text.ParseException;

public class RoundOffUtils {
    public static void main(String args[]) throws ParseException {
        String num = "200.5568";
        String roundNum = roundOf(num);
        System.out.println(roundNum);
    }

    private static String roundOf(String num) {
        Long round = Math.round(Double.parseDouble(num));
        return String.valueOf(round);
    }
}
