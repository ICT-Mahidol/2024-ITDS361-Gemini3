package com.example.access;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AstronomicalDataRepository extends JpaRepository<AstronomicalData, Long> {
    List<AstronomicalData> findByObjectNameContainingIgnoreCase(String objectName);
}
