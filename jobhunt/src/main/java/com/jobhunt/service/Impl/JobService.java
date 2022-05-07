package com.jobhunt.service.Impl;

import com.jobhunt.domain.Job;
import com.jobhunt.repository.BaseRepositoty;
import com.jobhunt.service.IJobservice;
import com.jobhunt.service.error.JobNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobservice {

    private final BaseRepositoty<Job,String> jobRepo;

    public JobService(@Qualifier("jobRepository") BaseRepositoty<Job, String> jobRepo) {
        this.jobRepo = jobRepo;
    }

    @Override
    public List<Job> listAll() {
        return jobRepo.findAll();
    }

    @Override
    public Job save(Job job) {
        return jobRepo.save(job);
    }

    @Override
    public Job getById(String id) throws JobNotFoundException {
        return jobRepo.findById(id).orElseThrow(()->new JobNotFoundException("not found id: "+id));
    }

    @Override
    public void deleteJob(String id) {
        jobRepo.delete(id);

    }
}
