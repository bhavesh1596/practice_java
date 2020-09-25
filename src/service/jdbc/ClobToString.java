package service.jdbc;

import javax.sql.rowset.serial.SerialClob;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;

public class ClobToString {
    public static void main(String args[]) throws SQLException, IOException {
        String jsonString = "{\"wcs\":{\"TRANSACTION\":\"Home troubleshoot\",\"TRANSACTION_TYPE\":\"revenue\",\"SUB_DETAILS_2\":\"TV\",\"MSISDN\":\"msisdn\",\"CUSTOMER_TYPE\":\"consumer\",\"SEGMENT\":\"fixed\"}}";

        java.sql.Clob clob = new SerialClob(jsonString.toCharArray());
        //System.out.println(clob);
final String convertedString = getClobString(clob);

        System.out.println(convertedString);
String jsonString2 = "{\"params\":{\"param\":[{\"name\":\"param1\",\"value\": \"val1\"},{\"name\": \"param2\",\"value\": \"val2\"},{\"name\": \"param3\",\"value\": \"val3\"}]}}";
        java.sql.Clob clob2 = new SerialClob(jsonString2.toCharArray());
        final String convertedString2 = getClobString(clob2);

        System.out.println(convertedString2);
    }

    public static String getClobString(Clob clob) {
        try(BufferedReader stringReader = new BufferedReader(
                clob.getCharacterStream())) {
            String singleLine = null;
            StringBuilder stringBuilder = new StringBuilder();
            while ((singleLine = stringReader.readLine()) != null) {
                stringBuilder.append(singleLine);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
