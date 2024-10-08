package com.kenzie.appserver.controller;

import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.ChexMixBagCreateRequest;
import com.kenzie.appserver.service.ChexMixBagService;
import com.kenzie.appserver.service.model.ChexMixBagDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.andreinc.mockneat.MockNeat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@IntegrationTest
class ChexMixBagDTOControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    ChexMixBagService chexMixBagService;

    private final MockNeat mockNeat = MockNeat.threadLocal();

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void getById_Exists() throws Exception {
//        String id = UUID.randomUUID().toString();
//        String name = mockNeat.strings().valStr();
//
//        ChexMixBagDTO chexMixBagDTO = new ChexMixBagDTO(id, name);
//        ChexMixBagDTO persistedChexMixBagDTO = chexMixBagService.addNewChexMixBag(chexMixBagDTO);
//        mvc.perform(get("/chexMixBagDTO/{id}", persistedChexMixBagDTO.getId())
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(jsonPath("id")
//                        .value(is(id)))
//                .andExpect(jsonPath("name")
//                        .value(is(name)))
//                .andExpect(status().isOk());
    }

    @Test
    public void createExample_CreateSuccessful() throws Exception {
//        String name = mockNeat.strings().valStr();
//
//        ChexMixBagCreateRequest chexMixBagCreateRequest = new ChexMixBagCreateRequest();
//        chexMixBagCreateRequest.setType(name);
//
//        mapper.registerModule(new JavaTimeModule());
//
//        mvc.perform(post("/example")
//                        .accept(MediaType.APPLICATION_JSON)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(mapper.writeValueAsString(chexMixBagCreateRequest)))
//                .andExpect(jsonPath("id")
//                        .exists())
//                .andExpect(jsonPath("name")
//                        .value(is(name)))
//                .andExpect(status().isCreated());
    }
}