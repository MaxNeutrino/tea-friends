package org.glasma.teafriend.service;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.UserTestData;
import org.glasma.teafriend.model.Role;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.glasma.teafriend.UserTestData.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserServiceTest {

    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServiceTest.class);

    @Autowired
    protected UserService service;

    /*@Autowired
    protected DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }*/

    @Test
    public void testSave() throws Exception {
        TestUser tu = new TestUser(null, "New", "new@gmail.com", "newPass", Collections.singleton(Role.ROLE_USER));
        User created = service.save(tu.asUser());
        tu.setId(created.getId());
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, tu, USER), service.getAll());
    }

    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        service.save(new UserTestData.TestUser("Duplicate", "user@gmail.com", "newPass", Role.ROLE_USER).asUser());
    }

    @Test
    public void testDelete() throws Exception {
        service.delete(USER_ID);
        MATCHER.assertCollectionEquals(Collections.singletonList(ADMIN), service.getAll());
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() throws Exception {
        service.delete(0);
    }

    @Test
    public void testGet() throws Exception {
        User user = service.get(USER_ID);
        MATCHER.assertEquals(USER, user);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() throws Exception {
        service.get(1);
    }

    @Test
    public void testGetByEmail() throws Exception {
        User user = service.getByEmail("user@gmail.com");
        MATCHER.assertEquals(USER, user);

    }

    @Test
    public void testGetAll() throws Exception {
        Collection<User> all = service.getAll();
        MATCHER.assertCollectionEquals(Arrays.asList(ADMIN, USER), all);
    }

    @Test
    public void testUpdate() throws Exception {
        TestUser updated = new TestUser(USER);
        updated.setName("UpdatedName");
        service.update(updated.asUser());
        MATCHER.assertEquals(updated, service.get(USER_ID));
    }
}
