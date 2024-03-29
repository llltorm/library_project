package net.project.library.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = HomeController.class)
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
@AutoConfigureMockMvc
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void test_showHomePage() throws Exception {
        mockMvc.perform(get("/home"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_redirectHomePage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}
