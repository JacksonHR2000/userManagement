package com.example.usermanagement.service;

import com.example.usermanagement.entity.UserCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.example.usermanagement.repo.UserCardRepository;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class UserCardServiceTest {

    // Setup mockMvc
    MockMvc mockMvc;
    @Mock
    UserCardRepository userCardRepository;

    @InjectMocks
    UserCardService userCardService;

    List<UserCard> userCards;
    UserCard testUserCard;
    UserCard testUserCard2;

    @BeforeEach
    void setup() {
        // Declare my return variables
        testUserCard = new UserCard("test", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        testUserCard2 = new UserCard("test", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");

        testUserCard.setId(1L);
        testUserCard2.setId(2L);
        // Setup my return variables
        userCards = new ArrayList<UserCard>();
        userCards.add(testUserCard);
        userCards.add(testUserCard2);

        // Instanciates mocked objects
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldFindAllUserCards() {
        // Setup simulated return data for the test
        when(userCardRepository.findAll()).thenReturn(userCards);

        List<UserCard> listOfUserCards = userCardService.findAllUserCards();

        verify(userCardRepository, times(1)).findAll();
        assertThat(listOfUserCards).isEqualTo(userCards);

    }

    @Test
    void shouldFindUserCardById() {
        // Setup simulated return
        when(userCardRepository.findById(1L)).thenReturn(Optional.of(testUserCard));

        // Execute my findById
        UserCard myReturn = userCardService.findUserCardById(1L);

        // Verify
        verify(userCardRepository, times(1)).findById(1L);
    }

    @Test
    void shouldSaveNewUserCard() {
        // Setup simulated return
        UserCard cardToSave = new UserCard("I am a card fella", "Dan's house", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        when(userCardRepository.findById(3L)).thenReturn(Optional.of(cardToSave));
        cardToSave.setId(3L);
        when(userCardRepository.save(cardToSave)).thenReturn(cardToSave);

        // Execute save
        UserCard cardReturn = userCardService.saveUserCard(cardToSave);

        // Validate
        verify(userCardRepository, times(1)).save(cardToSave);
        assertThat(userCardRepository.findById(3L)).get().isEqualTo(cardReturn);
//        assertThat(cardToSave).isSameAs(cardReturn);
    }

    @Test
    void shouldDeleteUserCardById() {
        // Setup simulated return
        UserCard cardToDelete = new UserCard("I am a card fella", "Dan's house", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        cardToDelete.setId(1L);
        when(userCardRepository.save(cardToDelete)).thenReturn(cardToDelete);
        when(userCardRepository.existsById(1L)).thenReturn(true);


        // Execute delete without the controller
        userCardService.saveUserCard(cardToDelete);
        userCardService.delete(1L);

        // Validate
        verify(userCardRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldUpdateUserCardById() {
        // Setup simulated return
        UserCard cardToUpdate = new UserCard("I am a card fella", "Dan's house", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        UserCard cardUpdates = new UserCard(null, "Dirty Dan's house", "Night City", null, null, null, null);
        UserCard cardPostUpdate = new UserCard("I am a card fella", "Dan's house", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");

        cardToUpdate.setId(1L);
        cardUpdates.setId(1L);
        cardPostUpdate.setId(1L);
        when(userCardRepository.existsById(1L)).thenReturn(true);
        when(userCardRepository.findById(1L)).thenReturn(Optional.of(cardPostUpdate));

        // Execute update
        userCardService.partialUpdate(1L, cardUpdates);

        // Validate
        verify(userCardRepository.existsById(1L));
        verify(cardPostUpdate.getName());
    }

}
