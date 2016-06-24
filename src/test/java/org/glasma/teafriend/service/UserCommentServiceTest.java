package org.glasma.teafriend.service;

import org.glasma.teafriend.TeaTestData;
import org.glasma.teafriend.UserCommentTestData;
import org.glasma.teafriend.UserTestData;
import org.glasma.teafriend.model.UserComment;
import org.glasma.teafriend.util.exception.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.glasma.teafriend.Profiles.POSTGRES;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@ActiveProfiles(POSTGRES)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class UserCommentServiceTest {

    @Autowired
    UserCommentService service;

    @Autowired
    UserService userService;

    @Test
    public void testGet() {
        UserComment comment = service.get(UserCommentTestData.COMMENT_ID);
        UserCommentTestData.MATCHER.assertEquals(UserCommentTestData.COMMENT, comment);
    }

    @Test(expected = NotFoundException.class)
    public void testGetNotFound() {
        service.get(1);
    }

    @Test
    public void testGetAllByUser() {
        List<UserComment> comments = service.getAllByUser(UserTestData.USER_ID);
        UserCommentTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(UserCommentTestData.COMMENT, UserCommentTestData.COMMENT2), comments
        );
    }

    @Test
    public void testGetAllByTea() {
        List<UserComment> comments = service.getAllByTea(TeaTestData.ULUN_TEA_ID);
        UserCommentTestData.MATCHER.assertCollectionEquals(
                Collections.singletonList(UserCommentTestData.COMMENT), comments
        );
    }

    @Test
    public void testSave() {
        UserCommentTestData.TestUserComment tuc = new UserCommentTestData.TestUserComment(
                null, "Это новый комментарий"
        );

        UserComment created = service.save(tuc.asUserComment(), UserTestData.USER_ID, TeaTestData.BLACK_TEA_ID);
        tuc.setId(created.getId());
        UserCommentTestData.MATCHER.assertCollectionEquals(
                Arrays.asList(tuc, UserCommentTestData.COMMENT, UserCommentTestData.COMMENT2),
                service.getAllByUser(UserTestData.USER_ID)
        );
    }

    @Test
    public void testDelete() {
        service.delete(UserCommentTestData.COMMENT_ID);
        UserCommentTestData.MATCHER.assertCollectionEquals(
                Collections.singletonList(UserCommentTestData.COMMENT2), service.getAllByUser(UserTestData.USER_ID)
        );
    }

    @Test(expected = NotFoundException.class)
    public void testNotFoundDelete() {
        service.delete(1);
    }
}
