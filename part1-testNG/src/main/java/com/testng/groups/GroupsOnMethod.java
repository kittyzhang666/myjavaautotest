package com.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {
    @Test(groups="manager")
    public void test01(){
        System.out.println("这是管理端组的测试方法test01");
    }
    @Test(groups="manager")
    public void test02(){
        System.out.println("这是管理端组的测试方法test02");
    }
    @Test(groups="user")
    public void test03(){
        System.out.println("这是用户端组的测试方法test03");
    }
    @Test(groups="user")
    public void test04(){
        System.out.println("这是用户端组的测试方法test04");
    }
    @BeforeGroups("manager")
    public void beforeGroupsOnManager(){
        System.out.println("这是管理端组之前运行的方法===========");
    }

    @AfterGroups("manager")
    public void afterGroupsOnManager(){
        System.out.println("这是管理端组之后运行的方法============");
    }
    @BeforeGroups("user")
    public void beforeGroupsOnUser(){
        System.out.println("这是用户端组之前运行的方法============");
    }

    @AfterGroups("user")
    public void afterGroupsOnUser(){
        System.out.println("这是用户端组之后运行的方法===========");
    }

}

