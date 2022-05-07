package com.jobhunt.service;

import com.jobhunt.domain.Job;
import com.jobhunt.service.error.JobNotFoundException;

import java.util.List;

public interface IJobservice {
    List<Job>listAll();
    Job save(Job job);
    Job getById(String id) throws JobNotFoundException;
    void deleteJob(String id);
}
