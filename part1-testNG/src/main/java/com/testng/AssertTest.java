package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
public class AssertTest {
    @Test
    public void test01(){
        Assert.assertEquals(1,2);}
    @Test
    public void test02(){
        Assert.assertEquals(1,1);}
    @Test
    public void test03(){
        Assert.assertEquals("abc","abc");}
}

