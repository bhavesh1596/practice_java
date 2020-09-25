package service.others;

public class TestIncrementOperatod {
    public static void main(String args[]) {
        int count = 0;
        if(count++==1){
            System.out.println("Considered count as "+count);
        }
        System.out.println(++count);
    }
}
