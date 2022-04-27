package com.bai1.service;

import com.bai1.modal.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@org.springframework.stereotype.Service
public class Service {
    private List<String> list = Arrays.asList(
            "Kiến tha lâu đầy tổ",
            "Có công mài sắt, có ngày nên kim",
            "Không thầy đố mày làm nên",
            "Học thầy không tày học bạn"
    );

    private List<Student> students = new ArrayList<>();
    private Random r = new Random();

    public String ranDomChar() {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < 26) {
            if (j < 10) {
                sb.append((char) (j + '0'));
                j++;
            }
            sb.append((char) (i + 'a'));
            i++;
        }
        StringBuilder random = new StringBuilder();
        for (int k = 0; k < 8; k++) {
            int index = r.nextInt(sb.length());
            random.append((char) (sb.charAt(index)));
        }
        return random.toString();
    }

    public String ranDomInList() {
        int index = r.nextInt(list.size());
        return list.get(index);

    }

    public List<Student>listAll(){
        return students;
    }
    public void addStudent(Student student){
        students.add(student);
    }
}
