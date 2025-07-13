package org.example;

import org.example.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// CourseBusiness = STU - System Under Test || Method Under Test
public class CourseBusiness {

    // CourseService is a Dependency
    private CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student){

        var filteredCourses = new ArrayList<String>();

        var allCourses = courseService.retrieveCourses(student);

        for (String course : allCourses) {
            if (course.contains("Spring")) filteredCourses.add(course);
        }


        return filteredCourses;
    }
}
