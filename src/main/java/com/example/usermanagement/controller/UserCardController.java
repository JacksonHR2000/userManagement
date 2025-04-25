package com.example.usermanagement.controller;

import com.example.usermanagement.entity.UserCard;
import com.example.usermanagement.service.UserCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class UserCardController {

    private final UserCardService userCardService;

    public UserCardController(UserCardService userCardService) { this.userCardService = userCardService; }

    @GetMapping("/usercard")
    public List<UserCard> getAllUserCards() {
        return userCardService.findAllUserCards();
    }

    @GetMapping("/usercard/{id}")
    public UserCard getUserCardById(@PathVariable Long id) {
        return userCardService.findUserCardById(id);
    }

    @PostMapping("/usercard")
    public UserCard createUserCard(@RequestBody UserCard cardToCreate) {
        return userCardService.saveUserCard(cardToCreate);
    }

    @PatchMapping("/usercard/{id}")
    public Optional<UserCard> updateUserCard(@PathVariable Long id, @RequestBody UserCard cardToUpdate) {
        return userCardService.partialUpdate(id, cardToUpdate);
    }
}