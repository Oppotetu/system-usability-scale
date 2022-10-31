package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ScaleRepository extends JpaRepository<Scale, Long> {

/*    @Query(value = "SELECT * FROM SCALES", nativeQuery = true)
    List<Scale> findAllScales();*/

}


