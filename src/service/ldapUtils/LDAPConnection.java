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
        env.put(Context.PROVIDER_URL, "ldap://XXX:XXX");
        env.put(Context.SECURITY_PRINCIPAL, "uid=X,ou=People,dc=du,dc=ae");
        env.put(Context.SECURITY_CREDENTIALS, "XX");
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
        env.put(Context.PROVIDER_URL, "ldap://XX:XX");
        env.put(Context.SECURITY_PRINCIPAL, "uid=X,ou=People,dc=du,dc=ae");
        env.put(Context.SECURITY_CREDENTIALS, "XXX");
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