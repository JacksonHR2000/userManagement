package com.example.usermanagement.service;

import com.example.usermanagement.entity.UserCard;
import com.example.usermanagement.repo.UserCardRepository;
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

    public UserCard findUserCardById(long l) {
        return userCardRepository.findById(l).get();
    }

    public UserCard saveUserCard(UserCard cardToSave) {
        return userCardRepository.save(cardToSave);
    }

    public void delete(Long l) {
        // If data wasnt found
        if (!userCardRepository.existsById(l)) {
            System.out.println("UserCard not found with id: " + l);
            return;
        }

        // Data was found
        userCardRepository.deleteById(l);
    }

    public Optional<UserCard> partialUpdate(Long l, UserCard card) {
        UserCard existingCard = userCardRepository.findById(l).orElse(null);
        if (existingCard == null) {
            // Send back not found status code
            System.out.println("UserCard not found with id " + l);
        }

        // Update all data members
        if (card.getName() != null) {
            existingCard.setName(card.getName());
        }

        if (card.getAddress() != null) {
            existingCard.setAddress(card.getAddress());
        }

        if (card.getCity() != null) {
            existingCard.setCity(card.getCity());
        }

        if (card.getState() != null) {
            existingCard.setState(card.getState());
        }


        if (card.getEmail() != null) {
            existingCard.setEmail(card.getEmail());
        }

        if (card.getPhone() != null) {
            existingCard.setPhone(card.getPhone());
        }

        if (card.getImgLink() != null) {
            existingCard.setImgLink(card.getImgLink());
        }

        return Optional.of(userCardRepository.save(existingCard));
    }
}