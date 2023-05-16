package com.example.dbclmtest;

import com.example.dbclmtest.infrastructure.rest.spring.dto.NaceRequest;
import com.example.dbclmtest.infrastructure.rest.spring.dto.NaceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest(
        classes = com.example.dbclmtest.infrastructure.config.spring.DbclmtestApplication.class)
public class NaceDetailsTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @BeforeEach
    public void init() throws Exception {
        MvcResult result =
                mockMvc
                        .perform(MockMvcRequestBuilders.post("/nace/csv"))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        List<NaceResponse> nace =
                objectMapper.readValue(
                        result.getResponse().getContentAsString(), objectMapper.getTypeFactory().constructCollectionType(List.class, NaceResponse.class));
        Assertions.assertFalse(nace.isEmpty());
    }


    @Test
    void getNaceDetailsTest() throws Exception {
        MvcResult resultGet =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/nace/{order}", 398481L))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();
        NaceResponse response =
                objectMapper.readValue(
                        resultGet.getResponse().getContentAsString(), NaceResponse.class);
        Assertions.assertEquals(398481L, response.getOrder());

    }

    @Test
    void putNaceDetailsTest() throws Exception {

        NaceRequest request = NaceRequest.builder()
                .level(1)
                .parent("03.2")
                .description("Growing of tropical and subtropical fruits")
                .thisItemIncludes("This class includes:\n- growing of tropical and subtropical fruits.")
                .thisItemAlsoIncludes("Fresh fruit")
                .rulings("")
                .thisItemExcludes("Frozen fruit")
                .referenceToIsicRev("0123")
                .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(request);

        MvcResult resultGet =
                mockMvc
                        .perform(MockMvcRequestBuilders.put("/nace/{order}", 398481L).contentType(MediaType.APPLICATION_JSON)
                                .content(requestJson))
                        .andExpect(MockMvcResultMatchers.status().isOk())
                        .andReturn();

        NaceResponse response =
                objectMapper.readValue(
                        resultGet.getResponse().getContentAsString(), NaceResponse.class);
        Assertions.assertEquals(398481L, response.getOrder());
        Assertions.assertEquals("0123", response.getReferenceToIsicRev());
    }

}
