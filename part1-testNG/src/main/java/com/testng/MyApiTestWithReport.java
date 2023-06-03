package com.testng;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyApiTestWithReport {
    @Test
    public void test01(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test02(){
        Assert.assertEquals(1,1);
    }


    @Test
    public void test03(){
        Assert.assertEquals("aaa","aaa");
    }


    @Test
    public void logTest(){
        Reporter.log("this is my log");
        throw new RuntimeException("this is exception");
    }

}
