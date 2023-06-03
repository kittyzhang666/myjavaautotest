package com.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    //最基本的注解，用来把方法标记为测试的一部分
    @Test
    public void testCase1(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
        System.out.println("this is test Case NO.1");
    }

    @Test
    public void testCase2(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
        System.out.println("this is test Case NO.2");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod-测试方法之前运行");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod-测试方法之后运行");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass-类运行之前运行的方法");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass-类运行之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");
    }
}