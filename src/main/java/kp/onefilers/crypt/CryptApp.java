package kp.onefilers.crypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.security.Security;

/**
 * For running strong encryption algorithms like PBEWITHSHA256AND128BITAES-CBC-BC
 * we need to install the jce_policy files to the jre lib.
 */
public class CryptApp {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        StandardPBEStringEncryptor myFirstEncryptor = new StandardPBEStringEncryptor();
        myFirstEncryptor.setProviderName("BC");
        myFirstEncryptor.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC");
        myFirstEncryptor.setPassword("myPassword");

        String pass = "drowssap";

        String encPass = myFirstEncryptor.encrypt(pass);
        String decPass = myFirstEncryptor.decrypt(encPass);

        System.out.println("encPass : "+encPass);
        System.out.println("decPass : "+decPass);
    }
}
