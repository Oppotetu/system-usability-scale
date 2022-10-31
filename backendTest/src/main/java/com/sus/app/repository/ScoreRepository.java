package com.sus.app.repository;

import com.sus.app.systemUsabilityScale.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ScoreRepository extends JpaRepository<Score, Integer> {

/*
    List<Score> findByAboveAverage(Boolean aboveAverage);
*/

/*    @Query("UPDATE Score t SET t.score = :score WHERE t.id = :id")
    @Modifying
    public void updateScore(Integer id, int Score);*/
}
