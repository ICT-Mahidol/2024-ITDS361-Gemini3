package com.example.execute;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApprovedSciencePlanRepository extends JpaRepository<ApprovedSciencePlan, Long> {
    List<ApprovedSciencePlan> findByStatus(String status);
}
