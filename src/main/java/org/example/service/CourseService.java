package org.example.service;

import java.util.List;

public interface CourseService {

    List<String> retrieveCourses(String student);

    void deleteCourse(String course);
}
