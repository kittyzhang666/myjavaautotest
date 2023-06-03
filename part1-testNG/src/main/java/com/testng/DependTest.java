package com.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void test1(){
        System.out.println("this is test 1");
        throw new RuntimeException();
    }
    @Test
    public void test2(){
        System.out.println("this is test 2");
    }
}
