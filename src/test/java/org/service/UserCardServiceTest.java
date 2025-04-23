package org.service;

import org.apache.catalina.User;
import org.entity.UserCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.repo.UserCardRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

public class UserCardServiceTest {

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
        testUserCard = new UserCard(1L, "test", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        testUserCard2 = new UserCard(2L, "test", "myAddress", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");

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

    }

    @Test
    void shouldFindUserCardById() {
        // Setup simulated return
        when(userCardRepository.findById(1L)).thenReturn(Optional.of(testUserCard));

        // Execute my findById
        Optional<UserCard> myReturn = userCardService.findUserCardById(1L);

        // Verify
        verify(userCardRepository, times(1)).findById(1L);
    }

    @Test
    void shouldSaveNewUserCard() {
        // Setup simulated return
        UserCard cardToSave = new UserCard(3L, "I am a card fella", "Dan's house", "myCity", "ST", "name@email.com", "123-456-7890", "http://ur;");
        when(userCardRepository.save(cardToSave)).thenReturn(cardToSave);

        // Execute save
        UserCard cardReturn = userCardService.saveUserCard(cardToSave);

        // Validate
        verify(userCardRepository, times(1)).save(cardToSave);
        assert(cardToSave == cardReturn);
    }

    @Test
    void shouldDeleteUserCardById() throws Exception{
        // Setup simulated return
        doNothing().when(userCardService).deleteUserCard

    }

}
