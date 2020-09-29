package service.ldapUtils;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Properties;

public class LDAPConnection {

    public static DirContext tqcMajorDuLDAPConnection() {
        DirContext connection = null;
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://172.24.245.138:3389");
        env.put(Context.SECURITY_PRINCIPAL, "uid=tqcadmin,ou=People,dc=du,dc=ae");
        env.put(Context.SECURITY_CREDENTIALS, "Test12345");
        try {
             connection = new InitialDirContext(env);
            System.out.println("tqcMajorDuLDAPConnection! " + connection);
        } catch (AuthenticationException ex) {
            System.out.println("AuthenticationException : "+ex.getMessage());
        } catch (NamingException e) {
            System.out.println("NamingException :"+e);
        }
        return connection;
    }

    public static void closeTqcMajorDuLDAPConnection(DirContext connection) {
        if(null != connection) {
            try {
                connection.close();
            } catch (NamingException e) {
                System.out.println("NamingException :"+e);
            }
        }
    }

    public static DirContext tqcMajorDuWriteLDAPConnection() {
        DirContext connection = null;
        Properties env = new Properties();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://172.24.245.138:3389");
        env.put(Context.SECURITY_PRINCIPAL, "uid=WebPortalAdmin,ou=People,dc=du,dc=ae");
        env.put(Context.SECURITY_CREDENTIALS, "tqc@1234");
        try {
            connection = new InitialDirContext(env);
            System.out.println("tqcMajorDuWriteLDAPConnection! " + connection);
        } catch (AuthenticationException ex) {
            System.out.println("AuthenticationException : "+ex.getMessage());
        } catch (NamingException e) {
            System.out.println("NamingException :"+e);
        }
        return connection;
    }

}