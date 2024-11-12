package com.process.processes.controller;

import com.process.processes.model.Process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.process.processes.service.SchedulerService;

@RestController
@RequestMapping("/scheduler")
public class SchedulerController {

    @Autowired
    private SchedulerService scheduler_service;

    @PostMapping("/fifo")
    public List<Process> execute_FIFO(@RequestBody List<Process> processes) {
        scheduler_service.execute_FIFO(processes);
        return processes;
    }
}
