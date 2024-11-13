package com.process.processes.controller;

import com.process.processes.model.Process;
import com.process.processes.model.RRRequest;

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

    @PostMapping("/sjf")
    public List<Process> execute_SJF(@RequestBody List<Process> processes) {
        scheduler_service.execute_SJF(processes);
        return processes;
    }
    
    @PostMapping("/rr")
    public List<Process> execute_RR(@RequestBody RRRequest rrRequest) {
        List<Process> processes = rrRequest.getProcesses();
        int quantum = rrRequest.getQuantum();

        scheduler_service.execute_RR(processes, quantum);
        return processes;
    }
    
    @PostMapping("/priority")
    public List<Process> execute_priority(@RequestBody List<Process> processes) {
        scheduler_service.execute_priority(processes);
        return processes;
    }
    
    @PostMapping("/lot")
    public List<Process> execute_LOT(@RequestBody List<Process> processes) {
        scheduler_service.execute_LOT(processes);
        return processes;
    }
}
