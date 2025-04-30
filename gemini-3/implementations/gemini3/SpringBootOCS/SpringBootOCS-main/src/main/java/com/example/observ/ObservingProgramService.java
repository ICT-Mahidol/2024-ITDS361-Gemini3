package com.example.observ;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.*;
import edu.gemini.app.ocs.model.ObservingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservingProgramService {

    private final OCS ocs = new OCS();

    @Autowired
    private ObservingProgramRepository repository;

    public ObservingProgram createObservingProgram(int planNo) {
        // ดึง Science Plan ตามหมายเลขที่ระบุ
        SciencePlan sp = ocs.getSciencePlanByNo(planNo);

        // กำหนดตำแหน่งกล้องโทรทรรศน์
        TelePositionPair[] pairs = {
                new TelePositionPair(35.0, 40.0),
                new TelePositionPair(50.0, 60.0),
                new TelePositionPair(80.0, 15.0)
        };

        // สร้าง Observing Program
        ObservingProgram op = ocs.createObservingProgram(
                sp,
                "GNZ",                           // opticsPrimary
                2.0,                             // fStop
                10.0,                            // opticsSecondaryRMS
                45.0,                            // foldMirrorDegree
                ObservingProgramConfigs.FoldMirrorType.CASSEGRAIN_FOCUS,
                2,                               // moduleContent
                ObservingProgramConfigs.CalibrationUnit.Xenon,
                ObservingProgramConfigs.LightType.CerroPachonSkyEmission,
                pairs
        );

        // ตรวจสอบเงื่อนไขความเหมาะสม
        op.validateObservingCondition(op);

        // บันทึกลงระบบ
        ocs.saveObservingProgram(op);

        // คืนค่าผลลัพธ์ที่สร้าง
        return op;
    }

    public ObservingProgram getObservingProgramByPlan(int planNo) {
        SciencePlan sp = ocs.getSciencePlanByNo(planNo);
        return ocs.getObservingProgramBySciencePlan(sp);
    }
}
