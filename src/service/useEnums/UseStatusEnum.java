package service.useEnums;

import service.enums.Status;

public class UseStatusEnum {
    public static void main(String args[]) {
        Status ok = Status.valueOf("OK");
        System.out.println(ok.getValue() + " : "+ok.getValue2());
        System.out.println(Status.OK.equals(Status.NOT_OK));
    }
}
