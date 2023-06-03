package com.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 5000)
    public void testSuccess() throws InterruptedException{
        Thread.sleep(3000);
        System.out.println("3000毫秒后执行");
    }
    @Test(timeOut = 1000)
    public void testFailed() throws InterruptedException{
        Thread.sleep(3000);
        System.out.println("3000毫秒后执行");
    }
}
