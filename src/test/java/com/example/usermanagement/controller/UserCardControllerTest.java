package com.example.usermanagement.controller;

import com.example.usermanagement.entity.UserCard;
import com.example.usermanagement.service.UserCardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserCardController.class)
@AutoConfigureMockMvc
public class UserCardControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserCardService userCardService;

    @Autowired
    private ObjectMapper objectMapper;

    List<UserCard> userCards = new ArrayList<>();
    UserCard testUserCard;
    UserCard testUserCard2;

    @BeforeEach
    void setup() {

        userCards = new ArrayList<UserCard>();
        testUserCard = new UserCard("test", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        testUserCard2 = new UserCard("test", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");

        testUserCard.setId(1L);
        testUserCard2.setId(2L);
        // Setup my return variables
        userCards.add(testUserCard);
        userCards.add(testUserCard2);

        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetAllUserCards() throws Exception{
        // Setup mocked response
        Mockito.when(userCardService.findAllUserCards()).thenReturn(userCards);

        // Run test
        mockMvc.perform(MockMvcRequestBuilders.get("/api/usercard"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", hasSize(2)));

        // Validate that the right service was called
        Mockito.verify(userCardService, times(1)).findAllUserCards();
    }

    @Test
    void shouldGetAUserCardByid() throws Exception {
        // Setup mocked response
        Mockito.when(userCardService.findUserCardById(1L)).thenReturn(testUserCard);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/usercard/1"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$.*", hasSize(1)));

        // Validate that the right service was called
        Mockito.verify(userCardService, times(1)).findUserCardById(1L);
    }

    @Test
    void shouldCreateAUserCard() throws Exception {
        // Setup mocked response
        Mockito.when(userCardService.findUserCardById(3L)).thenReturn(testUserCard);
        UserCard cardToPost = new UserCard("I am card3", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        cardToPost.setId(3L);
        String cardToPostStr = objectMapper.writeValueAsString(cardToPost);


        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/usercard")
                        .contentType((MediaType.APPLICATION_JSON))
                        .content(cardToPostStr))
                .andExpect(status().is2xxSuccessful());

        // Validate that the right service was called
        Mockito.verify(userCardService, times(1)).saveUserCard();
    }


}