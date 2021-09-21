package com.example.hw11.controllers;

import com.example.hw11.services.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final ScoreService scoreService;

    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/app/score/inc")
    public String userInc() {
        scoreService.userIns();
        return "бал увеличен на 10";
    }

    @GetMapping("/app/score/dec")
    public String userDec() {
        scoreService.userDec();
        return "бал уменьшен на 10";
    }

    @GetMapping("/app/score/get/current")
    public String userCurrent() {
        return "Бал " + scoreService.userCurrent().getName() + " равен " + scoreService.userCurrent().getBall();
    }

    @GetMapping("/app/score/get/{id}")
    public String userScore(@PathVariable Integer id) {
        return "Бал " + scoreService.userScore(id).getName() + " равен " + scoreService.userScore(id).getBall();
    }
}
