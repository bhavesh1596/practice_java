package service.stringUtils;

public class StringRemoveHyphen {
    public static void main(String args[]) {
        String emiratesID = "748000000000002";
        String em2 = emiratesID.replaceAll("-","");
        System.out.println(em2);
    }
}