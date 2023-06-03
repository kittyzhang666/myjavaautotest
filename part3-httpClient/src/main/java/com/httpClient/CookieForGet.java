package com.httpClient;

import org.apache.http.client.CookieStore;
import org.testng.annotations.BeforeTest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class CookieForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url= bundle.getString("test.url");
    }
    @Test
    public void testGetCookie() throws IOException {
        String result;
        String uri=bundle.getString("getCookie.uri");
        String testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("（一）testGetCookie()运行结果：");
        System.out.println(result);
        //获取cookies信息
        this.store= client.getCookieStore();
        List<org.apache.http.cookie.Cookie> cookieList=store.getCookies();
        for (Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+";Cookie value="+value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookie"})
    public void testGetWithCookies() throws IOException {
        //设置uri为配置项中的test.get.with.cookie
        String uri=bundle.getString("test.get.with.cookie");
        //配置项中的test.url与test.get.with.cookie进行拼接，形成一个测试url
        String testUrl = this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //设置cookies信息
        client.setCookieStore((org.apache.http.client.CookieStore) this.store);
        HttpResponse response = client.execute(get);
        //获取响应状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("（二）testGetWithCookies()运行结果：");
        System.out.println("statusCode="+statusCode);
        if(statusCode==200){
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }
    }
}