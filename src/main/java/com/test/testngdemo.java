package com.test;
import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by wb-chenchi on 2018/1/17.
 */

public class testngdemo {
    @Test
    public void test(){
        System.out.println("3");
        Assert.assertEquals(3, 3);

    }
    @Test
    public void test1(){
        int a,b;
        a=1;
        b=1;
        System.out.println("8");
        Assert.assertEquals(8,3);


    }
}
