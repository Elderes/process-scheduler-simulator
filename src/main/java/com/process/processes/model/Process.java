package com.process.processes.model;

public class Process {
    private int id;
    private int arrival_time;
    private int execution_time;
    private int end_time;
    private int return_time;
    private int priority;

    public Process(int id, int arrival_time, int execution_time, int priority)
    {
        this.id = id;
        this.arrival_time = arrival_time;
        this.execution_time = execution_time;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(int arrival_time) {
        this.arrival_time = arrival_time;
    }

    public int getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(int execution_time) {
        this.execution_time = execution_time;
    }

    public int getEnd_time() {
        return end_time;
    }

    public void setEnd_time(int end_time) {
        this.end_time = end_time;
    }

    public int getReturn_time() {
        return return_time;
    }

    public void setReturn_time(int return_time) {
        this.return_time = return_time;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void calculate_return_time()
    {
        this.return_time = this.end_time - this.arrival_time;
    }
}
