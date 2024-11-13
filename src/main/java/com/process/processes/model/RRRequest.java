package com.process.processes.model;

import java.util.List;

public class RRRequest {
    private List<Process> processes;
    private int quantum;
    
    public List<Process> getProcesses() {
        return processes;
    }
    
    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }
    
    public int getQuantum() {
        return quantum;
    }
    
    public void setQuantum(int quantum) {
        this.quantum = quantum;
    }
 
}
