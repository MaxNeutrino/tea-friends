package org.glasma.teafriend;

import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.web.tea.AbstractTeaController;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        try(GenericXmlApplicationContext appCtx = new GenericXmlApplicationContext()) {
            appCtx.getEnvironment().setActiveProfiles(Profiles.POSTGRES, Profiles.JPA);
            appCtx.load("spring/spring-app.xml", "spring/spring-db.xml");
            appCtx.refresh();

            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            AbstractTeaController teaRestController = appCtx.getBean(AbstractTeaController.class);
            teaRestController.create(new Tea(12, "Молочный оолонг", "Светлый улун", "Китай", "Очень вкусный", 0, 0));
            System.out.println();
        }
    }
}
