package service.ldapUtils;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.ArrayList;
import java.util.List;

public class LDAPQueryOperations {
    private static DirContext connection = null;
    public static void main(String args[]) throws NamingException {
        try {
            connection = LDAPConnection.tqcMajorDuWriteLDAPConnection();
            searchCustomerIDsOfMsisdn("971559537311","971551103594","6102561");//   971551103169
            //searchMSISDNsOfCustomerID("21561546");

        }
        finally {
            System.out.println("Finally closing..");
            LDAPConnection.closeTqcMajorDuLDAPConnection(connection);
        }
    }

    public static void searchMSISDNsOfCustomerID(String customerID) throws NamingException {
        //String searchFilter = "(uid=1)"; //  for one user
        //String searchFilter = "(&(uid=1)(cn=Smith))"; // and condition
        String searchFilter = "(customerID="+customerID+")"; // or condition
        String[] reqAtt = {"serviceNumber"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);
        if(null != connection) {
            NamingEnumeration users = connection.search("ou=Contracts,ou=customers,dc=du,dc=ae", searchFilter, controls);
            SearchResult result = null;
            while (users.hasMore()) {
                result = (SearchResult) users.next();
                Attributes attr = result.getAttributes();
                System.out.println(attr.get("serviceNumber"));
            }
        }
    }

    private static final String MSISDN_SEARCH_FILTER = "(serviceNumber={msisdn})";
    public static void searchCustomerIDsOfMsisdn(String serviceNumber1,String serviceNu2 , String serviceNumber3) throws NamingException {
        String reqCustID = "21561054";
        List<String> ldapCustIDs = new ArrayList<>();
        //String searchFilter = "(uid=1)"; //  for one user
        //String searchFilter = "(&(uid=1)(cn=Smith))"; // and condition
        StringBuilder serviceNumbers = new StringBuilder("(|");
        serviceNumbers.append(MSISDN_SEARCH_FILTER.replace("{msisdn}",serviceNumber1)).append(MSISDN_SEARCH_FILTER.replace("{msisdn}",serviceNu2)).append(MSISDN_SEARCH_FILTER.replace("{msisdn}",serviceNumber3)).append(")");
        //String searchFilter = "(|(serviceNumber="+serviceNumber1+")(serviceNumber="+serviceNu2+")(serviceNumber="+serviceNumber3+"))";
        System.out.println(serviceNumbers);
        String searchFilter = serviceNumbers.toString();
        String[] reqAtt = {"customerID"};
        SearchControls controls = new SearchControls();
        controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        controls.setReturningAttributes(reqAtt);
        if(null != connection) {
            NamingEnumeration users = connection.search("ou=Contracts,ou=customers,dc=du,dc=ae", searchFilter, controls);
            SearchResult result = null;
            String ldapCustomerID = "";
            while (users.hasMore()) {
                result = (SearchResult) users.next();
                Attributes attrs = result.getAttributes();
                if(null != attrs) {
                    Attribute custID = attrs.get("customerID");
                    System.out.println(custID.get().toString());
                    ldapCustIDs.add(custID.get().toString());
                }
            }
        }
        for(String ldapCustID : ldapCustIDs) {
            if(null != ldapCustID && !reqCustID.trim().equals(ldapCustID.trim())) {
                System.out.println("ERROR");
            }
            else {
                System.out.println("SUCCESS");
            }
        }
    }
}


