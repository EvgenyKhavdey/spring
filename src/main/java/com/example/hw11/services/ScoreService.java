package com.example.hw11.services;

import com.example.hw11.model.Score;
import com.example.hw11.repositories.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void userIns() {
        Score score = new Score();
        score.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", GenericPropertyMatchers.startsWith().ignoreCase());
        List<Score> list = scoreRepository.findAll(Example.of(score, matcher));
        for (Score sc : list){
            sc.setBall(sc.getBall() + 10);
            scoreRepository.save(sc);
        }
    }

    public void userDec() {
        Score score = new Score();
        score.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", GenericPropertyMatchers.startsWith().ignoreCase());
        List<Score> list = scoreRepository.findAll(Example.of(score, matcher));
        for (Score sc : list){
            sc.setBall(sc.getBall() - 10);
            scoreRepository.save(sc);
        }
    }

    public Score userCurrent() {
        Score score = new Score();
        score.setName(name);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", GenericPropertyMatchers.startsWith().ignoreCase());
        List<Score> list = scoreRepository.findAll(Example.of(score, matcher));
        for (Score sc : list){
            score = sc;
        }
        return score;
    }

    public Score userScore(Integer id) {
        Score score = (Score) scoreRepository.findAllById(Collections.singleton(id));
        return score;
    }
}
