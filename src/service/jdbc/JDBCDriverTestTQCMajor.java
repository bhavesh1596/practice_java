package service.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCDriverTestTQCMajor {
    public static void main(String[] args) {
        processTQCMAJOR();
    }

    private static void processTQCMAJOR() {
        Connection con = getMajorDBConnection();
        PreparedStatement preparedStatement =null;
        ResultSet rs = null;
        System.out.println(con);
        try {
             preparedStatement = con.prepareStatement("select * from aecb_operation where rownum <=5");
            if(null != preparedStatement) {
                 rs = preparedStatement.executeQuery();
                if(null != rs) {
                    while (rs.next()) {
                        System.out.println( rs.getString(2) );
                    }
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

    private static Connection getMajorDBConnection() {
Connection con = null;
        try{
            String URL = "jdbc:oracle:thin:@172.24.108.182:1525:scrregr";
            String USER = "DSL_TQC_MAJOR_SERVICES";
            String PASS = "Welcome#123";
            Class.forName("oracle.jdbc.driver.OracleDriver");
             con= DriverManager.getConnection(URL,USER,PASS);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
