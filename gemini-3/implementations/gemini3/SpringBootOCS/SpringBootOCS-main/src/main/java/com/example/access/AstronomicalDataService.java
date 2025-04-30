package com.example.access;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.*;
import edu.gemini.app.ocs.model.AstronomicalData;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AstronomicalDataService {

    private final OCS ocs = new OCS();

    public AstronomicalData getAstronomicalDataByPlanId(int planId) throws IOException {
        SciencePlan sp = ocs.getSciencePlanByNo(planId);
        return ocs.getAstronomicalData(sp);
    }
}
