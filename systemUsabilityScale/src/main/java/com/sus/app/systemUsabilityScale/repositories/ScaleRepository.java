package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScaleRepository extends JpaRepository<Scale, Long> {

    @Query("SELECT AVG(score) FROM Scale")
    float findAverageScore();

    @Query("SELECT MIN(score) FROM Scale")
    float findLowestScore();

    @Query("SELECT MAX(score) FROM Scale")
    float findHighestScore();

    @Query("SELECT COUNT(score) FROM Scale")
    int findScoreCount();

/*    List<Scale> findAllScoresLastHour(
            Date evaluationTimeStart,
            Date evaluationTimeEnd
    )*/

}
