package org.glasma.teafriend.web;

import org.glasma.teafriend.UserTestData;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.UserRepository;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.glasma.teafriend.web.user.AdminUserRestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Collection;

import static org.glasma.teafriend.UserTestData.ADMIN;
import static org.glasma.teafriend.UserTestData.USER;

public class AdminTest {
    private static ConfigurableApplicationContext appCtx;
    private static AdminUserRestController controller;

    @BeforeClass
    public static void beforeClass() {
        appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(appCtx.getBeanDefinitionNames()) + "\n");
        controller = appCtx.getBean(AdminUserRestController.class);
    }

    @Before
    public void setUp() throws Exception {
        UserRepository repository = appCtx.getBean(UserRepository.class);
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testDelete() throws Exception{
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(0);
    }
}
