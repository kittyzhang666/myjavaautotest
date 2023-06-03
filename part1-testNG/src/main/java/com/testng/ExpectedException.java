package com.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){
        System.out.println("this is a failed test");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccsee(){
        System.out.println("this is a success test");
        throw new RuntimeException();
    }
}
