package org.glasma.teafriend.service;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.TeaTestData;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class TeaServiceTest {

    private final static LoggerWrapper LOG = LoggerWrapper.get(TeaServiceTest.class);

    @Autowired
    protected TeaService service;

    @Test
    public void testSave() {
        TeaTestData.TestTea tt = new TeaTestData.TestTea("НовыйЧай", "Шен Пуэр", "Китай", "Очень вкусный");
        Tea created = service.save(tt.asTea());
        tt.setId(created.getId());
        TeaTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(TeaTestData.BLACK, TeaTestData.WHITE, TeaTestData.ULUN, tt), service.getAll());
    }

    @Test
    public void testDelete() {
        service.delete(TeaTestData.WHITE_TEA_ID);
        TeaTestData.MATCHER.assertCollectionEquals(Arrays.asList(TeaTestData.BLACK, TeaTestData.ULUN), service.getAll());
    }

    @Test
    public void testUpdate() {
        TeaTestData.TestTea updated = new TeaTestData.TestTea(TeaTestData.ULUN);
        updated.setName("Обновлен");
        service.update(updated.asTea());
        TeaTestData.MATCHER.assertEquals(updated, service.get(TeaTestData.ULUN_TEA_ID));
    }

    @Test
    public void testGet() {
        Tea tea = service.get(TeaTestData.WHITE_TEA_ID);
        TeaTestData.MATCHER.assertEquals(tea, TeaTestData.WHITE);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() {
        service.get(1);
    }

    @Test
    public void testGetAll() {
        Collection<Tea> all = service.getAll();
        TeaTestData.MATCHER.assertCollectionEquals(Arrays.asList(TeaTestData.BLACK, TeaTestData.WHITE, TeaTestData.ULUN), all);
    }

    @Test
    public void testGetFilteredByCategory() {
        Collection<Tea> byCategory = service.getFilteredTeaList(TeaTestData.CATEGORY_WHITE, TeaTestData.CHOICE_ALL);
        TeaTestData.MATCHER.assertCollectionEquals(Collections.singletonList(
                TeaTestData.WHITE), byCategory);
    }

    @Test
    public void testGetFilteredByCountry() {
        Collection<Tea> byCountry = service.getFilteredTeaList(TeaTestData.CHOICE_ALL, TeaTestData.COUNTRY_INDIA);
        TeaTestData.MATCHER.assertCollectionEquals(Collections.singletonList(
                TeaTestData.BLACK), byCountry);
    }

    @Test
    public void testGetFilteredByCategoryAndCountry() {
        Collection<Tea> byCategoryAndCountry = service.getFilteredTeaList(
                TeaTestData.CATEGORY_WHITE, TeaTestData.COUNTRY_CHINA);
        TeaTestData.MATCHER.assertCollectionEquals(Collections.singletonList(
                TeaTestData.WHITE), byCategoryAndCountry);
    }
}
