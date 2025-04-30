package com.example.access;

import edu.gemini.app.ocs.model.AstronomicalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/data")
public class AstronomicalDataController {

    @Autowired
    private AstronomicalDataService astronomicalDataService;

    // แสดงฟอร์มให้กรอก Science Plan ID
    @GetMapping("/form")
    public String showDataForm() {
        return "data_form";
    }

    // ดึงข้อมูล astronomical data ตาม Science Plan ID
    @PostMapping("/get")
    public String getAstronomicalData(@RequestParam("planId") int planId, Model model) {
        try {
            AstronomicalData data = astronomicalDataService.getAstronomicalDataByPlanId(planId);
            model.addAttribute("message", "Data found for Plan ID " + planId);
            model.addAttribute("astroData", data);
        } catch (IOException e) {
            model.addAttribute("message", "Failed to retrieve data: " + e.getMessage());
        }
        return "data_result";
    }
}