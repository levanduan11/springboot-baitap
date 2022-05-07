package com.jobhunt.repository.Impl;

import com.jobhunt.domain.Job;
import com.jobhunt.repository.BaseRepositoty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class JobRepository implements BaseRepositoty<Job,String> {
    Map<String, Job>jobs;

    public JobRepository() {
        jobs=new ConcurrentHashMap<>();
        String id1= UUID.randomUUID().toString();
        String id2=UUID.randomUUID().toString();
        String id3=UUID.randomUUID().toString();
        String id4=UUID.randomUUID().toString();
        String id5=UUID.randomUUID().toString();
        jobs.put(id1,new Job(id1,"js","ha noi",150000));
        jobs.put(id2,new Job(id2,"java","tphcm",250000));
        jobs.put(id3,new Job(id3,"js","da nang",350000));
        jobs.put(id4,new Job(id4,"js","hai phong",450000));
        jobs.put(id5,new Job(id5,"js","quang binh",950000));

    }

    @Override
    public List<Job> findAll() {
        return jobs.values().stream().collect(Collectors.toList());
    }

    @Override
    public Job save(Job job) {
        return jobs.put(job.getId(),job);
    }

    @Override
    public Optional<Job> findById(String s) {
        return Optional.ofNullable(jobs.get(s));
    }

    @Override
    public void delete(String s) {
        jobs.remove(s);
    }
}
