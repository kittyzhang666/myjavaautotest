package com.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name,int age){
        System.out.println("name is "+name+";age is "+age);
    }
    @DataProvider(name="data")
    public Object[][] providerData(){
        Object[][] o=new Object[][]{
                {"zhangsan",20},
                {"lisi",18},
                {"wangwu",21}
        };
        return o;
    }
    @Test(dataProvider = "methodProvider")
    public void test01(String name, int age) {
        System.out.println("test01方法：name:" + name + ",age:" + age);
    }
    @Test(dataProvider = "methodProvider")
    public void test02(String name, int age) {
        System.out.println("test02方法：name:" + name + ",age:" + age);
    }
    @DataProvider(name = "methodProvider")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test01")) {
            result = new Object[][]{
                    {"zhangsan", 11},
                    {"lisi", 21}
            };
        } else if (method.getName().equals("test02")) {
            result = new Object[][]{
                    {"wangwu", 50},
                    {"zhaoliu", 60}
            };
        }return result;
    }



}
