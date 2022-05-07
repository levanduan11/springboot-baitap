package com.jobhunt.repository.Impl;

import com.jobhunt.domain.Employer;
import com.jobhunt.repository.BaseRepositoty;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
public class EmployerRepository implements BaseRepositoty<Employer,String> {
   Map<String, Employer>employers;

    public EmployerRepository() {
        employers=new ConcurrentHashMap<>();
        String id1=UUID.randomUUID().toString();
        String id2=UUID.randomUUID().toString();
        String id3=UUID.randomUUID().toString();
        String id4=UUID.randomUUID().toString();
        String id5=UUID.randomUUID().toString();
        employers.put(id1,new Employer(id1,"Employer1","ha noi","Employer1@gmail.com"));
        employers.put(id2,new Employer(id2,"Employer2","tphcm","Employer2@gmail.com"));
        employers.put(id3,new Employer(id3,"Employer3","da nang","Employer3@gmail.com"));
        employers.put(id4,new Employer(id4,"Employer4","hai phong","Employer4@gmail.com"));
        employers.put(id5,new Employer(id5,"Employer5","quang binh","Employer5@gmail.com"));

    }


    @Override
    public List<Employer> findAll() {
         return employers.values().stream().collect(Collectors.toList());
    }

    @Override
    public Employer save(Employer employer) {
        return employers.put(employer.getId(),employer);
    }

    @Override
    public Optional<Employer> findById(String s) {
        return Optional.ofNullable(employers.get(s));
    }

    @Override
    public void delete(String s) {
        employers.remove(s);
    }


}
