package com.example.testing;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


// ApplicationContext 로딩. 기본 통합 테스트
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationContextTests {
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void contextLoads() throws Throwable {
        Assert.assertNotNull("the application context should have loaded", this.applicationContext);
    }
}
