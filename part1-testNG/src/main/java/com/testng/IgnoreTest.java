package com.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore 1 run");
    }
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore 2 run");
    }
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore 3 run");
    }
}
