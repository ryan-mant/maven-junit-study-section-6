package org.example.business;

import org.example.service.CourseService;
import org.example.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class CourseBusinessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {


    	// Given / Arrange
        CourseService stubService = new CourseServiceStub();

        CourseBusiness courseBusiness = new CourseBusiness(stubService);

    	// When / Act

        var filteredCourses = courseBusiness.retrieveCoursesRelatedToSpring("Leandro");

    	// Then / Assert
        assertEquals(4, filteredCourses.size());

    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFoobarStudent() {


        // Given / Arrange
        CourseService stubService = new CourseServiceStub();

        CourseBusiness courseBusiness = new CourseBusiness(stubService);

        // When / Act

        var filteredCourses = courseBusiness.retrieveCoursesRelatedToSpring("Foo Bar");

        // Then / Assert
        assertEquals(0, filteredCourses.size());

    }
}
