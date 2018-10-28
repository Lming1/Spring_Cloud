package com.example.demo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

//@SpringBootApplication
//@EnableConfigServer
@Configuration
@PropertySource("some.properties")
public class Application {
    private final Log log = LogFactory.getLog(getClass());

    public static void main(String[] args) throws Throwable {
        new AnnotationConfigApplicationContext(Application.class);
    }

    @Bean
    static PropertySourcesPlaceholderConfigurer pspc()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("{configuration.projectName}")
    void setProjectName(String projectName) {
        log.info("setProjectName" + projectName);
    }


    @Value("${configuration.projectName}")
    private String fieldValue;


    @Autowired
    Application(@Value("${configuration.projectName}") String pn) {
        log.info("Application constructor: " + pn);
    }

    @Autowired
    void setEnviroment(Environment env) {
        log.info("setEnvironment:" + env.getProperty("configuration.projectName"));
    }

    @Bean
    InitializingBean both(Environment env, @Value("${configuration.projectName}") String projectName) {
        return () -> {
            log.info("@Bean with both dependencies (projectName) : " + projectName );
            log.info("@Bean with both dependencies (env) : " + env.getProperty("configuration.projectName"));
        };
    }

    @PostConstruct
    void afterPropertiesSet() throws Throwable {
        log.info("fieldValue: " + this.fieldValue);
    }



    //    public static void main(String[] args) {
    //        new ClassPathXmlApplicationContext("classic.xml");
    //    }
//    public void setConfigurationProjectName(String pn) {
    //        LogFactory.getLog(getClass()).info("the configuration project name is " + pn);
    //    }
}
