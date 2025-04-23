package org.service;

import org.entity.UserCard;
import org.repo.UserCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCardService {

    UserCardRepository userCardRepository;

    // Constructor.
    // Assigns a repository
    public UserCardService(UserCardRepository userCardRepository) {this.userCardRepository = userCardRepository; }

    public List<UserCard> findAllUserCards() {
        return userCardRepository.findAll();
    }

    public Optional<UserCard> findUserCardById(long l) {
        return userCardRepository.findById(l);
    }

    public UserCard saveUserCard(UserCard cardToSave) {
        return userCardRepository.save(cardToSave);
    }
}