package com.process.processes.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

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

    // SJF algorithm implementation
    public void execute_SJF(List<Process> processes) {
        processes.sort((p1, p2) -> Integer.compare(p1.getExecution_time(), p2.getExecution_time()));
        int actual_time = 0;
    
        for (Process process : processes) {
            if (process.getArrival_time() > actual_time) {
                actual_time = process.getArrival_time();
            }
            process.setEnd_time(actual_time + process.getExecution_time());
            process.calculate_return_time();
            actual_time = process.getEnd_time() + exchange_time;
        }
    }

    // Round Robin (circle) algorithm implementation
    public void execute_RR(List<Process> processes, int quantum) {
        int actual_time = 0;
        Queue<Process> queue = new LinkedList<>(processes);

        while (!queue.isEmpty()) {
            Process process = queue.poll();

            if (process.getArrival_time() > actual_time) {
                actual_time = process.getArrival_time();
            }

            if (process.getExecution_time() > quantum) {
                process.setExecution_time(process.getExecution_time() - quantum);
                actual_time += quantum;
                queue.add(process);
            } else {
                actual_time += process.getExecution_time();
                process.setEnd_time(actual_time);
                process.calculate_return_time();
            }
            actual_time += exchange_time;
        }
    }

    // Priority algorithm implementation
    public void execute_priority(List<Process> processes) {
        processes.sort((p1, p2) -> Integer.compare(p2.getPriority(), p1.getPriority())); // Ordenação pela prioridade
        int actual_time = 0;

        for (Process process : processes) {
            if (process.getArrival_time() > actual_time) {
                actual_time = process.getArrival_time();
            }
            process.setEnd_time(actual_time + process.getExecution_time());
            process.calculate_return_time();
            actual_time = process.getEnd_time() + exchange_time;
        }
    }

    // Lotery algorithm implementation
    public void execute_LOT(List<Process> processes) {
        Random random = new Random();
        int actual_time = 0;

        while (!processes.isEmpty()) {
            int totalTickets = processes.stream().mapToInt(Process::getPriority).sum();
            int winningTicket = random.nextInt(totalTickets) + 1;
            int cumulative = 0;

            Process selectedProcess = null;
            for (Process process : processes) {
                cumulative += process.getPriority();
                if (cumulative >= winningTicket) {
                    selectedProcess = process;
                    break;
                }
            }

            if (selectedProcess != null) {
                if (selectedProcess.getArrival_time() > actual_time) {
                    actual_time = selectedProcess.getArrival_time();
                }
                actual_time += selectedProcess.getExecution_time();
                selectedProcess.setEnd_time(actual_time);
                selectedProcess.calculate_return_time();
                processes.remove(selectedProcess);
            }
            actual_time += exchange_time;
        }
    }

}