package com.joheul.common;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class JavaCipher {

	private static String key = "bizetfkdltpstm!q2w3e4r";

	/**
	 * 암호화
	 */
	public static String Encrypt(String str) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length){
			len = keyBytes.length;
		}

		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
		byte[] results = cipher.doFinal(str.getBytes("UTF-8"));
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(results);
	}

	/**
	 * 복원화
	 */
	public static String Decrypt(String str) throws Exception {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] keyBytes = new byte[16];
		byte[] b = key.getBytes("UTF-8");
		int len = b.length;
		if (len > keyBytes.length){
			len = keyBytes.length;
		}
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] results = cipher.doFinal(decoder.decodeBuffer(str));
		return new String(results, "UTF-8");
	}
	
	
	public static String getMD5(String str){
        
        String rtnMD5 = "";
      
        
        try {
            //MessageDigest 인스턴스 생성
            MessageDigest md = MessageDigest.getInstance("MD5");
            //해쉬값 업데이트
            md.update(str.getBytes());
            //해쉬값(다이제스트) 얻기
            byte byteData[] = md.digest();

           
            
            StringBuffer sb = new StringBuffer();
            
            //출력
            for(byte byteTmp : byteData) {
                sb.append(Integer.toString((byteTmp&0xff) + 0x100, 16).substring(1));
                /*
                int tmp1 = (byteTmp & 0xff);
                int tmp2 = ((byteTmp&0xff) + 0x100);
                
                System.out.println(byteTmp +" : "+ tmp1 +" : "+ tmp2 
                        +" : "+Integer.toString((byteTmp&0xff)+0x100, 16)
                        +" : "+(Integer.toString((byteTmp&0xff) + 0x100, 16).substring(1)));
                */
                
                // byte 타입의 범위 : -128~127 ( -2^7 ~ 2^7-1 )
                //-129 + 256 = 127
                // 0x100 = 256
            }
            rtnMD5 = sb.toString();
        } catch (Exception e) {
            e.printStackTrace(); 
            rtnMD5 = null; 
        }
        return rtnMD5;
    }
}