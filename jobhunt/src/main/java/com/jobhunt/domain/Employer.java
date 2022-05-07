package com.jobhunt.domain;

import java.util.List;

public class Employer extends AbstractBase {

    private List<Applicant> applicants;

    public Employer() {

    }

    public Employer(String id,String name, String address, String email) {
        super(id,name, address, email);
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
}
