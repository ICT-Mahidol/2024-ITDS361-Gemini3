package com.example.observ;

import edu.gemini.app.ocs.model.ObservingProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/program")
public class ObservingProgramController {

    @Autowired
    private ObservingProgramService observingProgramService;

    // แสดงฟอร์มสำหรับกรอก planId เพื่อสร้าง Observing Program
    @GetMapping("/new")
    public String showForm() {
        return "program_form";
    }

    // รับ planId จาก form แล้วสร้าง Observing Program ด้วย OCS
    @PostMapping("/save")
    public String createObservingProgram(@RequestParam("planId") int planId, Model model) {
        ObservingProgram op = observingProgramService.createObservingProgram(planId);
        model.addAttribute("message", "Observing Program for Plan ID " + planId + " has been created successfully.");
        model.addAttribute("observingProgram", op);
        return "program_result";
    }

    // แสดงผล Observing Program ที่เคยสร้างไว้จาก planId
    @GetMapping("/view")
    public String viewObservingProgram(@RequestParam("planId") int planId, Model model) {
        ObservingProgram op = observingProgramService.getObservingProgramByPlan(planId);
        if (op != null) {
            model.addAttribute("message", "Observing Program found for Plan ID " + planId);
            model.addAttribute("observingProgram", op);
        } else {
            model.addAttribute("message", "No Observing Program found for Plan ID " + planId);
        }
        return "program_result";
    }
}