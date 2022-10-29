package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ScoreRepository extends JpaRepository<Score, Integer> {

    List<Score> findByAboveAverage(Boolean aboveAverage);

    @Query("UPDATE Score t SET t.score = :score WHERE t.id = :id")
    @Modifying
    public void updateScore(Integer id, int Score);
}
