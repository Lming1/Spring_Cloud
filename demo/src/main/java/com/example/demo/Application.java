package com.example.demo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@SpringBootApplication
//@EnableConfigServer
//@Configuration
public class Application {

//    private Log log = LogFactory.getLog(getClass());
//
//    @Bean
//    static PropertySourcesPlaceholderConfigurer pspc() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }
//
//    @Configuration
//    @Profile("prod")
//    @PropertySource("some-prod.properties")
//    public static class ProdConfiguration {
//        @Bean
//        InitializingBean init() {
//            return () -> LogFactory.getLog(getClass()).info("prod InitializingBean");
//        }
//    }
//
//    @Configuration
//    @Profile({ "default", "dev" })
//    @PropertySource("some.properties")
//    public static class DefaultConfiguration {
//        @Bean
//        InitializingBean init() {
//            return () -> LogFactory.getLog(getClass()).info("default InitializingBean");
//        }
//    }
//
//    @Bean
//    InitializingBean which(Environment e, @Value("${configuration.projectName}") String projectName) {
//        return () -> {
//            log.info("activeProfiles: '" + StringUtils.arrayToCommaDelimitedString(e.getActiveProfiles()) + "'");
//            log.info("configuration.projectName: " + projectName);
//        };
//    }
//
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
//        ac.getEnvironment().setActiveProfiles("dev");
//        ac.register(Application.class);
//        ac.refresh();
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
