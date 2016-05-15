package org.glasma.teafriend.web;

import org.glasma.teafriend.UserTestData;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.repository.UserRepository;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.glasma.teafriend.web.User.AdminRestController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.glasma.teafriend.UserTestData.ADMIN;
import static org.glasma.teafriend.UserTestData.USER;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {

    @Autowired
    private AdminRestController controller;

    @Autowired
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        repository.save(USER);
        repository.save(ADMIN);
    }

    @Test
    public void testDelete() throws Exception {
        controller.delete(UserTestData.USER_ID);
        Collection<User> users = controller.getAll();
        Assert.assertEquals(users.size(), 1);
        Assert.assertEquals(users.iterator().next(), ADMIN);
    }

    @Test(expected = NotFoundException.class)
    public void testDeleteNotFound() throws Exception {
        controller.delete(10);
    }
}
