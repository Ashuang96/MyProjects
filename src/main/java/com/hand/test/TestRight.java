package com.hand.test;

import com.hand.utils.MD5Util;

public class TestRight {
    public static void main(String[] args) {
        String ad = "test";
        System.out.println(MD5Util.encrypt(ad));
    }
}
