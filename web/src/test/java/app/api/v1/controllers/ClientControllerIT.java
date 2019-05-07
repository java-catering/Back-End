package app.api.v1.controllers;

import app.DAO_models.RegisterForm;
import app.models.User;
import app.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(MockitoExtension.class)
class ClientControllerIT
{
    @Mock
    UserService userService;

    MockMvc mockMvc;

    @InjectMocks
    ClientController controller;

    private final User user = new User()
            .builder()
            .email("e@example.com")
            .first_name("eric")
            .last_name("g")
            .password("123")
            .build();

    private final String REGISTER = "/api/v1/client/register";

    private final String LOGIN = "/api/v1/client/login";

    private final String UPDATE = "/api/v1/client/update";

    private RegisterForm registerForm;

    private String json;

    @BeforeEach
    void setUp()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void registerClient() throws Exception
    {
        registerForm = new RegisterForm()
                .builder()
                .email("e@example.com")
                .first_name("eric")
                .last_name("g")
                .password("123")
                .build();

        when(userService.save(any())).thenReturn(user);

        ObjectMapper mapper = new ObjectMapper();

        json =  mapper.writeValueAsString(registerForm);

        mockMvc.perform(post(REGISTER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn().getResponse().getContentLength();
    }

    @Test
    void registerClientThrowError() throws Exception
    {
        registerForm = new RegisterForm()
                .builder()
                .email("e@example.com")
                .last_name("G")
                .password("123")
                .build();

        ObjectMapper mapper = new ObjectMapper();

        json =  mapper.writeValueAsString(registerForm);

        mockMvc.perform(post(REGISTER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    void updateClient() throws Exception
    {
        registerForm = new RegisterForm()
                .builder()
                .email("e@example.com")
                .first_name("eric")
                .last_name("G")
                .password("123")
                .build();

        ObjectMapper mapper = new ObjectMapper();

        json =  mapper.writeValueAsString(registerForm);

        mockMvc.perform(post(REGISTER)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    void loginClient()
    {
    }
}