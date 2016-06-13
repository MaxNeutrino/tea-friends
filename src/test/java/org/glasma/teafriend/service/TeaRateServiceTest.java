package org.glasma.teafriend.service;

import org.glasma.teafriend.TeaRateTestData;
import org.glasma.teafriend.TeaTestData;
import org.glasma.teafriend.model.Role;
import org.glasma.teafriend.model.TeaRate;
import org.glasma.teafriend.model.User;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class TeaRateServiceTest {

    @Autowired
    protected TeaRateService service;

    @Autowired
    protected UserService userService;

    @Test
    public void testSetRate() {
        User user = new User(null, "New", "new@gmail.com", "newPass", Collections.singleton(Role.ROLE_USER));
        userService.save(user);
        TeaRateTestData.TestTeaRate ttr = new TeaRateTestData.TestTeaRate(4, user, TeaTestData.ULUN);
        TeaRate created = service.setRate(ttr.asTeaRate(), user.getId(), TeaTestData.ULUN_TEA_ID);
        ttr.setId(created.getId());

        TeaRateTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(TeaRateTestData.USER_TEA_RATE, TeaRateTestData.ADMIN_TEA_RATE, ttr),
                service.getAllByTea(TeaTestData.ULUN_TEA_ID)
        );
    }

    @Test
    public void testGetAllByTea() {
        List<TeaRate> all = service.getAllByTea(TeaTestData.ULUN_TEA_ID);
        TeaRateTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(TeaRateTestData.USER_TEA_RATE, TeaRateTestData.ADMIN_TEA_RATE), all
        );
    }

    @Test
    public void testDelete() {
        service.delete(TeaRateTestData.USER_TEA_RATE_ID);
        TeaRateTestData.MATCHER.assertCollectionEquals(
                Collections.singletonList(TeaRateTestData.ADMIN_TEA_RATE), service.getAllByTea(TeaTestData.ULUN_TEA_ID)
        );
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() {
        service.delete(1);
    }

    @Test
    public void testDeleteAll() {
        service.deleteAll(TeaTestData.ULUN_TEA_ID);
        Assert.assertEquals(service.getAllByTea(TeaTestData.ULUN_TEA_ID).size(), 0);
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDeleteAll() {
        service.deleteAll(2);
    }

}
