package service.others;

public class FillsToAED {
    public static void main(String args[]) {
        long amountInFils = 10036;
        String amountInAED = convertFilsToAED(amountInFils);
        System.out.println(amountInAED);
    }

    private static String convertFilsToAED(long amountInFils) {
        String amountInAED = null;
        amountInAED = String.valueOf((float)amountInFils/100);
        return amountInAED;
    }
}