package com.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {
    @Test
    @Parameters({"name","age"})
    public void patameterTest01(String name,int age){
        System.out.println("姓名："+name+"，年龄："+age);
    }

}
