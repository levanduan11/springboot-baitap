package com.bai3.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {
    private String id;
    private String title;
    private String description;
    private Set<String> locations=new HashSet<>();
    private int minSalary;
    private int maxSalary;
    private String emailTo;


}
