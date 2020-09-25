package service.keyWordUtils;

public class TestFinal {
    public static void main(String ar[]) {
        final int ONE;
        if(false) {
            ONE = 1;
        }
        else {
            ONE =2;
        }
        if(1!=ONE) {

        }
        final int TWO = 2;
        final int THREE = 3;
        final int FOUR = 4;
        System.out.println(ONE+TWO+THREE+FOUR);
    }
}
