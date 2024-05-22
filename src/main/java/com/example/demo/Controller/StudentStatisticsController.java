package com.example.demo.Controller;

import com.example.demo.Services.StudentStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/statistics")
public class StudentStatisticsController {

    @Autowired
    private StudentStatisticsService studentStatisticsService;

    @GetMapping("/absenteeism-rate")
    public ResponseEntity<Double> getAbsenteeismRate() {
        double absenteeismRate = studentStatisticsService.calculateAbsenteeismRate();
        return ResponseEntity.ok(absenteeismRate);
    }

    @GetMapping("/success-rate")
    public ResponseEntity<Double> getSuccessRate() {
        double successRate = studentStatisticsService.calculateSuccessRate();
        return ResponseEntity.ok(successRate);
    }
}
