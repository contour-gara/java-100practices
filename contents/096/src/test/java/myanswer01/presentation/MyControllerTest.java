package myanswer01.presentation;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.springframework.http.HttpStatus.OK;

@WebMvcTest
class MyControllerTest {
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    void helloエンドポイントが200を返す() {
        given()
                .when()
                .get("/hello")
                .then()
                .status(OK);
    }

    @Test
    void goodbyeエンドポイントが200を返す() {
        given()
                .when()
                .get("/goodbye")
                .then()
                .status(OK);
    }
}
