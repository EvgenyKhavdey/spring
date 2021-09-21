package com.example.hw11.controllers;

import com.example.hw11.entities.User;
import com.example.hw11.services.ScoreService;
import com.example.hw11.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@Profile("dao")
@Slf4j
@RequiredArgsConstructor
public class DaoController {

    private final UserService userService;
    private final ScoreService scoreService;

    @GetMapping("/dao")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("unable to fing user by username: " + principal.getName()));
        scoreService.setName(principal.getName());
        return "authenticated: " + user.getUsername() + " : " + user.getEmail();
    }

}
