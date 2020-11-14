package service.stringUtils;

public class RemoveAllTest {
    public static void main(String args[]) {

    String emiratesID = "private String ratePlan;\n" +
            "    private String msisdn;\n" +
            "    private String accountCode;\n" +
            "    private String sourceSystem;\n" +
            "    private String sourceBundle;\n" +
            "    private String sourceBundleRevenue;\n" +
            "    private String targetBundle;\n" +
            "    private String targetBundleRevenue;\n" +
            "    private String revenue;\n" +
            "    private String subDetails1;\n" +
            "    private String subDetails2;\n" +
            "    private String customerType;\n" +
            "    private String segment;\n" +
            "    private String transactionStart;\n" +
            "    private String transactionStop;\n" +
            "    private String subSegment;\n" +
            "    private String valueSegment;\n" +
            "    private String userJourneyId;\n" +
            "    private String userJourneySequence;\n" +
            "    private String uniqueRequestId;\n" +
            "    private String subSubSegment;\n" +
            "    private String idTransaction;\n" +
            "    private String transactionType;\n" +
            "    private String transaction;\n" +
            "    private String status;\n" +
            "    private String errorMessage;\n" +
            "    private String machine;\n" +
            "    private String statusDetail;\n" +
            "    private String errorCode;\n" +
            "    private String errorDescription;\n" +
            "    private String transactionStartDetail;\n" +
            "    private String transactionStopDetail;";
    emiratesID = emiratesID.replace("private String","");
    System.out.println(emiratesID.replace(";",""));
    }
}
