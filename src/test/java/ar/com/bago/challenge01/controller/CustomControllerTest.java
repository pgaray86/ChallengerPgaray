package ar.com.bago.challenge01.controller;

import ar.com.bago.challenge01.AbstractTest;
import ar.com.bago.challenge01.model.BasicResponse;
import ar.com.bago.challenge01.model.ErrorResponse;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class CustomControllerTest extends AbstractTest {

    @Test
    public void getFirstItem() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/basic/1").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assert status == HttpStatus.OK.value();

        BasicResponse basicResponse = mapFromJson(mvcResult.getResponse().getContentAsString(), BasicResponse.class);
        assert basicResponse.getId() == 1;
        assert basicResponse.getValue().equals("by default");
    }

    @Test
    public void getNotFoundItem() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/basic/78").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assert status == HttpStatus.NOT_FOUND.value();

        ErrorResponse errorResponse = mapFromJson(mvcResult.getResponse().getContentAsString(), ErrorResponse.class);
        assert errorResponse.getStatus() == 4001;
        assert errorResponse.getMessage().equals("Id 78 no encontrado");
    }

}
