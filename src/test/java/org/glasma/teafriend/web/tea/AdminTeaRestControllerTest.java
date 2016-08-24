package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.TeaTestData;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.service.TeaService;
import org.glasma.teafriend.web.AbstractControllerTest;
import org.glasma.teafriend.web.json.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.glasma.teafriend.TeaTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class AdminTeaRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = AdminTeaRestController.ADMIN_TEA_REST_URL + '/';

    @Autowired
    TeaService service;

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + WHITE_TEA_ID).contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
        MATCHER.assertCollectionEquals(Arrays.asList(TeaTestData.BLACK, TeaTestData.ULUN), service.getAll());
    }

    @Test
    public void testUpdate() throws Exception {
        Tea updated = new Tea(ULUN);
        updated.setName("Updated");
        mockMvc.perform(put(REST_URL + ULUN_TEA_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        MATCHER.assertEquals(updated, service.get(ULUN_TEA_ID));
    }

    @Test
    public void testCreate() throws Exception {
        TestTea expected = new TestTea("НовыйЧай", "Шен Пуэр", "Китай", "Очень вкусный");
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(expected.asTea())))
                .andExpect(status().isCreated());

        Tea returned = MATCHER.fromJsonAction(action);
        expected.setId(returned.getId());

        MATCHER.assertEquals(expected, returned);
        MATCHER.assertCollectionEquals(
                Arrays.asList(TeaTestData.BLACK, TeaTestData.WHITE, TeaTestData.ULUN, expected), service.getAll());
    }
}
