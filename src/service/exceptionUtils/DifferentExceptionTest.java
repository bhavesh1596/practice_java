package service.exceptionUtils;

public class DifferentExceptionTest {
    public static void main(String args[]) {
        try {
            String.valueOf(13254);
            callA();
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array caught");
        }
    }

    private static void callA() throws ArrayIndexOutOfBoundsException{
        try {
            throw new ArrayIndexOutOfBoundsException();
        }
        catch (ArrayIndexOutOfBoundsException se){
            throw  se;
        }
        catch (Exception e) {
            System.out.println("Failed");
        }
    }
}
