package com.testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class logTest {
    @Test
    public void testlog(){
        Reporter.log("run ok");
        throw new RuntimeException("my error log");
    }
}
