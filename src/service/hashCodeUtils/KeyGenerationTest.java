package service.hashCodeUtils;

import service.hashCodeUtils.HashUtils;

import java.util.HashMap;
import java.util.Map;

public class KeyGenerationTest {
    public static void main (String args[]) {
        String secureSecret = "02AD5F09FFBE4BFF158C481E50EC06F4"; // MIGS ne diya hai muje
        Map<String, String> fields = new HashMap<>();
        fields.put("vpc_AccessCode","53441E54");
        fields.put("vpc_Command","pay");
        fields.put("vpc_OrderInfo","ORDER21842049-000001664247");
        fields.put("vpc_CardSecurityCode","***");
        fields.put("vpc_CardExp","2105");
        fields.put("vpc_CardNum","5123************");
        fields.put("vpc_ReturnURL","http://172.24.108.102:8100/Post_Migs?env=preprod");
        fields.put("vpc_gateway","ssl");
        //fields.put("vpc_Addendumdata","/VER/1//SVC/1//OVR/N//CLN/dummy//CCT/dummy//CAC/1.28033114//CA1/dummy//UMI/21842049//PT1/prepaid//PR1/Low//PQ1/1//PP1/2500//CEM/dsfsd@du.ae//UP1/consumer//CFN/dummy//NAT/AE//UP2/AE/");
        fields.put("vpc_Version","1");
        fields.put("vpc_card","Mastercard");
        fields.put("vpc_Locale","en");
        fields.put("vpc_Merchant","TEST803634000");
        fields.put("vpc_Amount","2500");
        fields.put("vpc_MerchTxnRef","000001664247");
        // get SHA hash
        String secureHash = HashUtils.getSHAhashAllFields(fields,secureSecret);
        System.out.println("SecureHash key generated using migs private key "+secureSecret+"\n which will be sent to MIGS : "+secureHash+"\n MIGS in return will use the same private key "+secureSecret+"\n and produce another key at its end\n and compare with the one provided " +
                "by DSL\n, if key matches it will process\n, else will consider fradulent and injected : \n"+secureHash);
    }
}
//
/*map.put(VPC_RETURN_URL,returnUrl);
        map.put(VPC_MERCHANT,refdata.getVpc_Merchant());
        map.put(VPC_COMMAND, refdata.getVpc_Command());
        map.put(VPC_VERSION, refdata.getVpc_Version());
        map.put(VPC_ACCESS_ACODE,refdata.getVpc_AccessCode());
        map.put(VPC_SECUREHASHKEY,refdata.getVpc_SecureHash());
        map.put(VPC_VIRTUALPAYMENTCLIENT_URL,refdata.getVpc_VirtualPaymentClientURL());
        map.put(VPC_GATEWAY,refdata.getVpc_gateway());*/

        /*"vpc_Command": "pay",
        "vpc_OrderInfo": "ORDER21842049-000001664247",
        "vpc_CardSecurityCode": "***",
        "vpc_CardExp": "2105",
        "vpc_CardNum": "5123************",
        "vpc_ReturnURL": "http://172.24.108.102:8100/Post_Migs?env=preprod",
        "vpc_gateway": "ssl",
        "vpc_Addendumdata": "/VER/1//SVC/1//OVR/N//CLN/dummy//CCT/dummy//CAC/1.28033114//CA1/dummy//UMI/21842049//PT1/prepaid//PR1/Low//PQ1/1//PP1/2500//CEM/dsfsd@du.ae//UP1/consumer//CFN/dummy//NAT/AE//UP2/AE/",
        "vpc_Version": "1",
        "vpc_card": "Mastercard",
        "vpc_Locale": "en",
        "vpc_Merchant": "TEST803634000",
        "vpc_Amount": "2500",
        "vpc_MerchTxnRef": "000001664247"*/


//ACF8145D8447DADBFEBCEA6A080142A0BF8A82512531290F6E502D06C4EF47A1