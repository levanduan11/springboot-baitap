package com.bai3.resource;

import com.bai3.domain.Job;
import com.bai3.domain.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
public class JobRestController {
    ConcurrentHashMap<String, Job> jobs;

    public JobRestController() {
        jobs = new ConcurrentHashMap<>();
        String id1 = UUID.randomUUID().toString();
        jobs.put(id1,
                new Job(
                        id1,
                        "javascript",
                        "frontend",
                        new HashSet<>(Arrays.asList(Location.DA_NANG, Location.HA_NOI)),
                        120000,
                        170000,
                        "job1@gmail.com"
                ));
        String id2 = UUID.randomUUID().toString();
        jobs.put(id2,
                new Job(
                        id2,
                        "java",
                        "backend",
                        new HashSet<>(Arrays.asList(Location.HO_CHI_MINH, Location.DA_NANG)),
                        700000,
                        9000000,
                        "job2@gamil.com"
                ));
    }

    @GetMapping("/sortbylocation")
    public ResponseEntity<List<Job>>sortByLocation(){
        List<Job>jobList=jobs.values().stream()
                .sorted(new Comparator<Job>() {
                    @Override
                    public int compare(Job o1, Job o2) {
                        Set<String>s1=o1.getLocations();
                        Set<String>s2=o2.getLocations();
                        Iterator<String>iterator=s1.iterator();
                        Iterator<String>iterator1=s2.iterator();
                        while (iterator.hasNext()&&iterator1.hasNext()){
                            String a=iterator.next();
                            String b=iterator1.next();
                            if (a.compareTo(b)!=0){
                                return a.compareTo(b);
                            }
                        }
                        return s1.size()-s2.size();
                    }
                }).collect(Collectors.toList());
        return ResponseEntity.ok(jobList);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Job>>listAlL(){
        List<Job>jobList=jobs.values().stream().toList();
        return ResponseEntity.ok(jobList);
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<List<Job>>findBySalary(@PathVariable int salary){
        List<Job>resutl=jobs.values().stream()
                .filter(job->salary>=job.getMinSalary()&&salary<=job.getMaxSalary())
                .collect(Collectors.toList());
        return ResponseEntity.ok(resutl);

    }

    @GetMapping("/key/{key}")
    public ResponseEntity<List<Job>>search1(@PathVariable String key){
        List<Job>result=jobs.values().stream()
                .filter(job->job.getTitle().contains(key)||job.getDescription().contains(key))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
    @GetMapping("/query")
    public ResponseEntity<List<Job>>search2(@RequestParam String location,@RequestParam String key){
        List<Job>res=jobs.values().stream()
                .filter(job->{
                    return (
                            (job.getTitle().contains(key)||job.getDescription().contains(key))
                            &&
                             job.getLocations().stream().anyMatch(location::equals)
                            );
                }).collect(Collectors.toList());
        return ResponseEntity.ok(res);
    }
}
