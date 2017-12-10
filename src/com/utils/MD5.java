package com.utils;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {
    public static String md5(String input)  {
        String result = input;
        if(input != null) {
            try {

                MessageDigest md = MessageDigest.getInstance("MD5"); //or "SHA-1"
                md.update(input.getBytes());
                BigInteger hash = new BigInteger(1, md.digest());
                result = hash.toString(16);
                while(result.length() < 32) { //40 for SHA-1
                    result = "0" + result;
                }
            }catch (Exception ex){
                System.out.println();
            }
        }
        return result;
    }



}
