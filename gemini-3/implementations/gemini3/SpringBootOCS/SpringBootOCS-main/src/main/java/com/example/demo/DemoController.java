package com.example.demo;

import edu.gemini.app.ocs.OCS;
import edu.gemini.app.ocs.model.SciencePlan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class DemoController {
    @CrossOrigin
    @GetMapping("/")
    public ArrayList<SciencePlan> getAllSciencePlans() {
        OCS o = new OCS();
        System.out.println(o.getAllSciencePlans());
        return o.getAllSciencePlans();
    }

    @CrossOrigin
    @GetMapping("/sp")
    public SciencePlan getSciencePlan(@RequestParam(name="id", required=false, defaultValue="1") int id) {
        OCS o = new OCS();
        return o.getSciencePlanByNo(Integer.valueOf(id));
    }
}
