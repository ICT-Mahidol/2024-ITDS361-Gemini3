package com.example.execute;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovedSciencePlanService {

    private final OCS ocs = new OCS();

    @Autowired
    private ApprovedSciencePlanRepository repository;

    public ApprovedSciencePlan executePlan(Long id) {
        ApprovedSciencePlan plan = repository.findById(id).orElse(null);
        if (plan != null && "Approved".equalsIgnoreCase(plan.getStatus())) {
            ocs.updateSciencePlanStatus(plan.getId().intValue(), SciencePlan.STATUS.RUNNING);
            plan.setStatus("Executed");
            return repository.save(plan);
        }
        return null;
    }
}