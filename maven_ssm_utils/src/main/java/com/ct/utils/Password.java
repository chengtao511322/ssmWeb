package com.ct.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 用户加密类
 */
public class Password {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String getPassword(String password){
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }


    public static void main(String[] args) {
        String password = Password.getPassword("admin");
        System.out.println(password);
    }
}
