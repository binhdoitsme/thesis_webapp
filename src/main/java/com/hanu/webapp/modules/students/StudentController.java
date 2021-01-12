package com.hanu.webapp.modules.students;

import java.util.ArrayList;
import java.util.List;

import com.hanu.webapp.models.Student;

public interface StudentController {
    List<Student> getAllStudents();
}

class StudentControllerImpl implements StudentController {

    private final List<Student> students = new ArrayList<>();

    @Override
    public List<Student> getAllStudents() {
        return students;
    }
    
}