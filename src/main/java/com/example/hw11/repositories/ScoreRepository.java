package com.example.hw11.repositories;

import com.example.hw11.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ScoreRepository extends JpaRepository<Score, Integer>, JpaSpecificationExecutor<Score> {

}
