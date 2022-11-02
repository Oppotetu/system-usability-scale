package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.AllScores;
import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface ScaleRepository extends JpaRepository<Scale, Long> {

/*    @Query("SELECT e.score FROM scales e WHERE id = ?1")
    List<Object[]> findByBlaBla(int id);*/

/*    @Query("SELECT score FROM scales")
    List<Object[]> findScores();

    @Query("SELECT new com.sus.app.systemUsabilityScale.models.AllScores(score) from scales")
    AllScores findScore();*/

    @Query("SELECT AVG(score) FROM Scale")
    public float findAverageScore();
}
