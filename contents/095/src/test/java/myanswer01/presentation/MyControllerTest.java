package myanswer01.presentation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class MyControllerTest {
    @Autowired
    private MyController sut;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(sut).build();
    }

    @Test
    void helloエンドポイントが200を返す() throws Exception {
        mockMvc.perform(get("/hello")).andExpect(status().isOk());
    }

    @Test
    void goodbyeエンドポイントが200を返す() throws Exception {
        mockMvc.perform(get("/goodbye")).andExpect(status().isOk());
    }
}
