package service.jdbc;

import java.io.BufferedReader;
import java.sql.*;

public class JDBCDSLDevTest {

    private static String REQUEST_ID = "4eabcb5e-580a-4e4f-9b52-8c4bac11303c";
    public static void main(String[] args) {
        processClobReadWrite();
    }

    private static void processClobReadWrite() {
        Connection con = getDevDbConnection();
        PreparedStatement preparedStatement =null;
        ResultSet rs = null;
        Clob paramsClob = null;
        Clob wcsClob = null;
        System.out.println(con);
        try {
            preparedStatement = con.prepareStatement("select * from EXT_ACCESS where request_id = ?");
            if(null != preparedStatement) {
                preparedStatement.setString(1,REQUEST_ID);
                rs = preparedStatement.executeQuery();
                if(null != rs) {
                    rs.next();
                    paramsClob =  rs.getClob("PARAMS");
                    String paramsClobString = getClobString(paramsClob);
                    System.out.println(paramsClobString);
                    wcsClob = rs.getClob("WCS_LOG");
                    String wcsClobString = getClobString(wcsClob);
                    System.out.println(wcsClobString);
                }
            }
        }
        catch (Exception e) {
            System.out.println("processTQCMAJOR exception"+e.toString());
        }
        finally {

            closeResources(con, preparedStatement, rs);
        }
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
    private static Connection getDevDbConnection() {
        Connection con = null;
        try{
            String URL = "jdbc:oracle:thin:@172.24.108.187:1524:scrtqc2";
            String USER = "DSL_TQC_MINOR_SERVICES";
            String PASS = "Welcome#123";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection(URL,USER,PASS);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    private static void closeResources(Connection con, PreparedStatement preparedStatement, ResultSet rs) {
        if(null !=rs) {
            try {
                rs.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(null != preparedStatement) {
            try {
                preparedStatement.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(null !=con) {
            try {
                con.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
