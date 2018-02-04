package com.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wb-chenchi on 2018/1/18.
 */
public class testunicode2utf8 {

    private final static String DATA = "dubbo%3A%2F%2F172.16.101.48%3A41764%2Fdubbo%3A%2F%2F172.16.101.48%3A41764%2F";
    public static void main(String[] args) {

        System.out.println("ip: " + getIpAndPort(0) + "   port:" + getIpAndPort(1));
    }

    public static String getIpAndPort(Integer type) {

        String result = "";
        Pattern pattern = type == 0 ? Pattern.compile("%2F(.*?)%3A") : Pattern.compile("%3A(.*?)%2F");
        Matcher matcher = pattern.matcher(DATA);
        while (matcher.find()) {
            result = matcher.group().replaceAll("%2F", "").replaceAll("%3A", "");

        }
        return result;
    }
}
