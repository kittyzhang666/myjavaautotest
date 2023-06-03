package com.testng.MultiThread;

import org.testng.annotations.Test;

public class MultiThreadOnAnnotion {
    @Test(threadPoolSize = 2,invocationCount = 5)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id: %s%n",Thread.currentThread().getId());
}
}

