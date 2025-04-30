package com.example.execute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/execute")
public class ApprovedSciencePlanController {

    @Autowired
    private ApprovedSciencePlanService approvedSciencePlanService;

    // แสดงฟอร์มให้ใส่ planId สำหรับ execute
    @GetMapping("/form")
    public String showExecuteForm() {
        return "execute_form";
    }

    // ดำเนินการ execute plan ถ้าสถานะคือ Approved
    @PostMapping("/run")
    public String executeApprovedPlan(@RequestParam("planId") Long planId, Model model) {
        var result = approvedSciencePlanService.executePlan(planId);
        if (result != null) {
            model.addAttribute("message", "Plan ID " + planId + " has been executed.");
        } else {
            model.addAttribute("message", "Plan ID " + planId + " could not be executed (not approved or not found)." );
        }
        return "execute_result";
    }
}