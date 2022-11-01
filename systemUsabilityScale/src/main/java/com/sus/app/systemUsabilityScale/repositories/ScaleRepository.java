package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ScaleRepository extends JpaRepository<Scale, Long> {

/*    @Query("SELECT e.score FROM scales e WHERE id = ?1")
    List<Object[]> findByBlaBla(int id);*/
}
