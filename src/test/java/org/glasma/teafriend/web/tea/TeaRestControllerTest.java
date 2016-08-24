package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.TestUtil;
import org.glasma.teafriend.service.TeaService;
import org.glasma.teafriend.web.AbstractControllerTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static org.glasma.teafriend.TeaTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TeaRestControllerTest extends AbstractControllerTest {
    private static final String REST_URL = TeaRestController.TEA_REST_URL + '/';

    @Autowired
    TeaService service;

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + WHITE_TEA_ID))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentMatcher(WHITE));
    }

    @Test
    public void testGetAll() throws Exception {
        TestUtil.print(mockMvc.perform(get(REST_URL).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(MATCHER.contentListMatcher(BLACK, WHITE, ULUN)));
    }

    @Test
    public void testSearchByName() throws Exception {
        mockMvc.perform(get(REST_URL + "search/" + BLACK.getName()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentListMatcher(BLACK));
    }

    @Test
    public void testGetFilteredList() throws Exception {
        mockMvc.perform(get(REST_URL + BLACK.getCategory() + "/" + BLACK.getCountry()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MATCHER.contentListMatcher(BLACK));
    }
}
