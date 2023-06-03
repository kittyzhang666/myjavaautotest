package com.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "user")
public class GroupsOnClass2 {
    public void user01(){
        System.out.println("GroupsOnClass02中的user01");
    }
    public void user02(){
        System.out.println("GroupsOnClass02中的user02");
    }

}
