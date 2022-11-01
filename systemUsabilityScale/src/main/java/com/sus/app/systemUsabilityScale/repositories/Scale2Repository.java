package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Scale2Repository extends JpaRepository<Scale2, Long> {

    @Query("SELECT score FROM scales2")
    List<Double> findScores ();
}
