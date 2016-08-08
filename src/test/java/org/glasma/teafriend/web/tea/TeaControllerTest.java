package org.glasma.teafriend.web.tea;

import org.glasma.teafriend.web.AbstractControllerTest;
import org.junit.Test;
import org.glasma.teafriend.TeaTestData;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class TeaControllerTest extends AbstractControllerTest {

    @Test
    public void testTeaList() throws Exception {
        mockMvc.perform(get("/teas"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("teaList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/teaList.jsp"))
                .andExpect(model().attribute("teaList", hasSize(3)))
                .andExpect(model().attribute("teaList", hasItem(
                        allOf(
                                hasProperty("id", is(TeaTestData.WHITE_TEA_ID)),
                                hasProperty("name", is(TeaTestData.WHITE.getName()))
                        )
                )));
    }
}
