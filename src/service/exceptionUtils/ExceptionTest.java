package service.exceptionUtils;

public class ExceptionTest {
    public static void main(String args[]) throws Exception{
        try {
            callA() ;
        }
        catch (Exception e) {
            System.out.println("Exception caught "+e.getMessage());
            throw  e;
        }
        finally {
            System.out.println("Finally ");
        }




    }

    private static void callA() throws NumberFormatException, Exception {
        System.out.println("hi");
        /*try {
            callNumberFormatException();
        }
        catch (NumberFormatException ee) {
            String errror1 = ee.toString().substring(0,255);
            String errror2 = ee.toString().length() > 255 ? ee.toString().substring(0,255) : ee.toString();
            System.out.println("NumberFormatException caught "+errror2);
        }*/
        String test = "ab";
        if(null == test || (null !=test && test.isEmpty())) {
            callNumberFormatException();
        }



    }

    private static void callNumberFormatException() {
        throw new NumberFormatException();
    }
}
