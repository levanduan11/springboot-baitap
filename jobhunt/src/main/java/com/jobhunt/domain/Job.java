package com.jobhunt.domain;

public class Job extends IDBase{

    private String name;
    private String location;
    private int salary;

    public Job() {
    }

    public Job(String id, String name, String location, int salary) {
        super(id);
        this.name = name;
        this.location = location;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
