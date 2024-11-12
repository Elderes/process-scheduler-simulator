package com.process.processes.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.process.processes.model.Process;

@Service
public class SchedulerService {
    private int exchange_time;

    public SchedulerService() {
        this.exchange_time = 2; // Time unity exchange
    }

    // FIFO algorithm implementation
    public void execute_FIFO(List<Process> processes) {
        int actual_time = 0;

        for (Process process : processes)
        {
            // Idle simulation
            if (process.getArrival_time() > actual_time)
            {
                actual_time = process.getArrival_time();
            }

            // Execute process and update time
            process.setEnd_time(actual_time + process.getExecution_time());
            process.calculate_return_time();
            actual_time = process.getEnd_time() + exchange_time;
        }
    }

    public void execute_SJF() {

    }

    public void execute_RR() {

    }

    public void execute_priority() {

    }

    public void execute_LOT() {

    }
}
