package service.hashCodeUtils;



import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;



@SuppressWarnings("unchecked")
public class HashUtils {


    public static final String VPC_ = "vpc_";
    public static final String USER_ = "user_";

    public static Map<String, String> hashedMap(Map<String, String> map) {
        if (null != map && !map.isEmpty()) {
            Map<String, String> hashFields = new HashMap<String, String>();
            Set<String> keys = map.keySet();
            for (String key : keys) {
                if (key.length() > 5 && ((!key.equals("vpc_SecureHash") && !key
                        .equals("vpc_SecureHashType"))
                        && key.substring(0, 4).equals(VPC_)
                        || key.substring(0, 5).equals(USER_))) {
                    hashFields.put(key, map.get(key));
                }
            }
            return hashFields;
        }
        return null;
    }

    public static String getSHAhashAllFields(Map fields, String secureSecret) {
        List fieldNames = new ArrayList(fields.keySet());
        Collections.sort(fieldNames);
        StringBuilder buf = new StringBuilder();
        Iterator itr = fieldNames.iterator();
        while (itr.hasNext()) {
            String fieldName = (String) itr.next();
            String fieldValue = (String) fields.get(fieldName);
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                buf.append(fieldName).append("=").append(fieldValue);
                if (itr.hasNext()) {
                    buf.append('&');
                }
            }
        }

        byte[] mac = null;
        try {
            byte []  b = fromHexString(secureSecret, 0, secureSecret.length());
            SecretKey key = new SecretKeySpec(b, "HmacSHA256");
            Mac m = Mac.getInstance("HmacSHA256");
            m.init(key);
            m.update(buf.toString().getBytes("ISO-8859-1"));
            mac = m.doFinal();
        } catch(Exception e) {
            System.out.println("Exception occured while get SHA key for all fields "+e);
        }
        return hex(mac);
    }

    private static final char[] HEX_TABLE = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};


    public static byte[] fromHexString(String s, int offset, int length)
    {
        if ((length%2) != 0)
            return null;
        byte[] byteArray = new byte[length/2];
        int j = 0;
        int end = offset+length;
        for (int i = offset; i < end; i += 2)
        {
            int high_nibble = Character.digit(s.charAt(i), 16);
            int low_nibble = Character.digit(s.charAt(i+1), 16);
            if (high_nibble == -1 || low_nibble == -1)
            {
                // illegal format
                return null;
            }
            byteArray[j++] = (byte)(((high_nibble << 4) & 0xf0) | (low_nibble & 0x0f));
        }
        return byteArray;
    }

    static String hex(byte[] input) {

        StringBuilder sb = new StringBuilder(input.length * 2);
        for (byte anInput : input) {
            sb.append(HEX_TABLE[(anInput >> 4) & 0xf]);
            sb.append(HEX_TABLE[anInput & 0xf]);
        }
        return sb.toString();
    }
}
