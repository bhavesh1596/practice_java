package service.enums;

public enum Status {
    OK("Success","SuccessFull"),
    NOT_OK("Failed","Failuree");

    String val,val2;
    Status(String value,String value2) {
        val = value;
        val2 = value2;
    }

    public String getValue() {
        return val;
    }

    public String getValue2() {
        return val2;
    }

}
