package com.jobhunt.domain;

import java.util.List;

public class Applicant extends AbstractBase {

    private int age;
    private Employer employer;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
}
