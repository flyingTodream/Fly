package com.common.utils;
 
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.management.openmbean.InvalidKeyException;

public class StringEncode {
	
	
	 //加密
     public static String encodeString(String str) {
        String result = "";
        try {
            DESKeySpec keySpec = new DESKeySpec("CampusHelper".getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            sun.misc.BASE64Encoder base64encoder = new sun.misc.BASE64Encoder();
            sun.misc.BASE64Decoder base64decoder = new sun.misc.BASE64Decoder();

            // ENCODE plainTextPassword String
            byte[] cleartext = str.getBytes("UTF8");

            Cipher cipher = Cipher.getInstance("DES"); // cipher is not thread
                                                        // safe
            cipher.init(Cipher.ENCRYPT_MODE, key);
            result = base64encoder.encode(cipher.doFinal(cleartext));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
   
  //解密
    public static String deencodeString(String encryptedPwd)
            throws InvalidKeyException, UnsupportedEncodingException {
        String result = "";
        try {
            DESKeySpec keySpec = new DESKeySpec("CampusHelper".getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            sun.misc.BASE64Encoder base64encoder = new sun.misc.BASE64Encoder();
            sun.misc.BASE64Decoder base64decoder = new sun.misc.BASE64Decoder();

            // DECODE encryptedPwd String
            byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encryptedPwd);

            Cipher cipher = Cipher.getInstance("DES");// cipher is not thread
                                                        // safe
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainTextPwdBytes = (cipher.doFinal(encrypedPwdBytes));
            result = new String(plainTextPwdBytes);
        } catch (Exception e) {

            System.out.println("解密失败:"+encryptedPwd);
            result=againDecrypt(encryptedPwd);
        }
        return result;
    }
  
    public static String againDecrypt(String encryptedPwd)
            throws InvalidKeyException, UnsupportedEncodingException {
        String result = "";
        try {
            encryptedPwd=URLDecoder.decode(encryptedPwd,"utf-8");
            DESKeySpec keySpec = new DESKeySpec("CampusHelper".getBytes("UTF8"));
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(keySpec);
            sun.misc.BASE64Encoder base64encoder = new sun.misc.BASE64Encoder();
            sun.misc.BASE64Decoder base64decoder = new sun.misc.BASE64Decoder();

            // DECODE encryptedPwd String
            byte[] encrypedPwdBytes = base64decoder.decodeBuffer(encryptedPwd);

            Cipher cipher = Cipher.getInstance("DES");// cipher is not thread
                                                        // safe
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] file=cipher.doFinal(encrypedPwdBytes);
            byte[] plainTextPwdBytes = (file);
            result = new String(plainTextPwdBytes);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("重新解密失败:"+encryptedPwd);

        }
        return result;
    }
  

}