package service.exceptionUtils;

import java.io.FileNotFoundException;

public class ExceptionSubClass {
    public static void main(String args[]) {
        try {
            throw new FileNotFoundException();
        } catch (Exception ex) {
            if(ex instanceof FileNotFoundException){
                System.out.println(true);
            }

        }
    }
}
