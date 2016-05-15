package org.glasma.teafriend;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.web.Tea.TeaRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            TeaRestController teaRestController = appCtx.getBean(TeaRestController.class);
            teaRestController.create(new Tea(12, "Молочный оолонг", "Светлый улун", "Китай", "Очень вкусный"));
            System.out.println();
        }
    }
}
