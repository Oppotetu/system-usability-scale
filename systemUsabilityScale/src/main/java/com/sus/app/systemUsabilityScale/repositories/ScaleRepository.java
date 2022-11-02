package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScaleRepository extends JpaRepository<Scale, Long> {

/*    @Query("SELECT e.score FROM scales e WHERE id = ?1")
    List<Object[]> findByBlaBla(int id);*/

/*    @Query("SELECT score FROM scales")
    List<Object[]> findScores();

    @Query("SELECT new com.sus.app.systemUsabilityScale.models.AllScores(score) from scales")
    AllScores findScore();*/

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
