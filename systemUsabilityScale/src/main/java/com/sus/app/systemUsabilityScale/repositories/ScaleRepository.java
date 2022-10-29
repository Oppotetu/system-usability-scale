package com.sus.app.systemUsabilityScale.repositories;

import com.sus.app.systemUsabilityScale.models.Scale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScaleRepository extends JpaRepository<Scale, Long> {
}
