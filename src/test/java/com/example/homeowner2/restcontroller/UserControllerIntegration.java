package com.example.homeowner2.restcontroller;
import com.example.homeowner2.domain.User2;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest //Sets up a random port test
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc // Tells Spring to use MockMVC
// Directs the controller test class to the dummy data inside the sql file.
@Sql(scripts={"classpath:test-schema.sql", "classpath:test-data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class UserControllerIntegration {

    @Autowired
    private MockMvc mvc;

    @Autowired
    // Maps object to JSON
    private ObjectMapper mapper;

    @Test
    public void getAllUsersTest() throws Exception {
        String listOfUsers=this.mapper.writeValueAsString(List.of(
                new User2(1l,"John", "Smith", "johnsmith@hotmail.com", 2L, 300000L)
        ));

        //RequestBuilder request = (RequestBuilder) get("/user/getAll");

        //ResultMatcher status= status().isOk();
        //ResultMatcher content = (ResultMatcher) content().json(listOfUsers);
        mvc.perform(get("/user/getAll").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(listOfUsers));
    }
    @Test
    public void getByOneTest() throws Exception {
        String user=this.mapper.writeValueAsString(
                new User2(1l,"John", "Smith", "johnsmith@hotmail.com", 2L, 300000L)
        );
        mvc.perform(get("/user/getOne/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(user));
    }

}