package service.stringUtils;

public class MaskStringTest {
    public static void main(String args[]) {
        String emiratesID = "748000000000002";
        System.out.println(emiratesID);
        System.out.println(emiratesID.length());
        System.out.println(emiratesID.substring(emiratesID.length()-4));
        String emiratesNumber = emiratesID.substring(emiratesID.length()-4);
        System.out.println(emiratesID.substring(0,emiratesID.length()-4).length());

        String maskedPart = emiratesID.substring(0,emiratesID.length()-4).replaceAll("[A-Za-z0-9]","X");
        System.out.println((maskedPart+emiratesNumber));
        /*String maskedEmirates = emiratesID.substring(0,emiratesID.length()-3).replaceAll("X","X");
        System.out.println(maskedEmirates);*/
    }
}
