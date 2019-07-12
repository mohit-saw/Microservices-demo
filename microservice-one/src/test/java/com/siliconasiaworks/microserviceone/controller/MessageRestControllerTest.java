package com.siliconasiaworks.microserviceone.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class MessageRestControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private MessageRestController messageRestController;
    @Before
    public void setUp() throws Exception {

        mockMvc = MockMvcBuilders.standaloneSetup(messageRestController)
                .build();
    }

    @Test
    public void getMessage() throws Exception {

        mockMvc.perform(get("/settings"))
                .andExpect(status().isOk());
    }
}