/*
package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.AllScores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<AllScores, Long> {

    @Query(value = "SELECT SCORES FROM SCALES", nativeQuery = true)
    List<AllScores> findAllScores();

    @Query(value = "SELECT new com.sus.app.systemUsabilityScale.models.AllScores(scores) FROM SCALES2)",
    nativeQuery = true)
    List<AllScores> findAllScores();


}
*/
