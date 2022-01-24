package com.example.demo;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

public class AES256Cipher {
    private static volatile AES256Cipher INSTANCE;

    final static String secretKey = "ljwojPWxX2BjyskV6bhlwQsj23mis1ws";
    static String IV = "0000000000000000";

    public static AES256Cipher getInstance() {
        if (INSTANCE == null) {
            synchronized (AES256Cipher.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AES256Cipher();
                }
            }
        }

        return INSTANCE;
    }

    private AES256Cipher() {
    }

    public String AES_Encode(String str) throws Exception {
        byte[] keyData = secretKey.getBytes();
        SecretKey secretKey = new SecretKeySpec(keyData, "AES");

        Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
        c.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(IV.getBytes()));

        byte[] encrypted = c.doFinal(str.getBytes(StandardCharsets.UTF_8));
        String enStr = new String(Base64.encodeBase64(encrypted));

        return enStr;
    }
}
