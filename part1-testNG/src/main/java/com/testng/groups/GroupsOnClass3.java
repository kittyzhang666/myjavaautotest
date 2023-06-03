package com.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "manager")
public class GroupsOnClass3 {
    public void manager01(){
        System.out.println("GroupsOnClass03中的manager01");
    }
    public void manager02(){
        System.out.println("GroupsOnClass03中的manager02");
    }
}

