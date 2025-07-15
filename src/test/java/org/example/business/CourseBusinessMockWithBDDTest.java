package org.example.business;

import org.example.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CourseBusinessMockWithBDDTest {


    CourseService mockService;

    CourseBusiness courseBusiness;

    List<String> courses;

    @BeforeEach
    void setup() {
        mockService = mock(CourseService.class);
        courseBusiness = new CourseBusiness(mockService);

        courses = List.of(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // Given / Arrange

//        when(mockService.retrieveCourses("Leandro")).thenReturn(courses);
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);

    	// When / Act

        var filteredCourses = courseBusiness.retrieveCoursesRelatedToSpring("Leandro");

    	// Then / Assert
        assertThat(filteredCourses.size(),is(4));

    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Delete Courses Not Related to Spring Using Mockito should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethodDeleteCourse() {
    	// Given / Arrange
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
    	// When / Act
        courseBusiness.deleteCoursesNotRelatedToSpring("Leandro");

    	// Then / Assert
//        verify(mockService).deleteCourse("Spotify Engineering Culture Desmistificado");
//        verify(mockService, times(1)).deleteCourse("Spotify Engineering Culture Desmistificado");
//        verify(mockService, atLeast(2)).deleteCourse("Spotify Engineering Culture Desmistificado");
        verify(mockService, atLeastOnce()).deleteCourse("Spotify Engineering Culture Desmistificado");
        verify(mockService, never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Spring Boot e Docker");
    }

    @DisplayName("Delete Courses Not Related to Spring Using Mockito should call Method V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethodDeleteCourseV2() {
        // Given / Arrange
        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
        String spotifyEngineerCourse = "Spotify Engineering Culture Desmistificado";
        String springCourse = "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker";

        // When / Act
        courseBusiness.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService)
                .should()
                .deleteCourse(spotifyEngineerCourse);
        then(mockService)
                .should(never())
                .deleteCourse(springCourse);
    }
    @DisplayName("Delete Courses Not Related to Spring Capturing Arguments should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_CapturingArguments_Should_CallMethodDeleteCourse() {
        // Given / Arrange

//        courses = List.of(
//                "Spotify Engineering Culture Desmistificado",
//                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker"
//        );

        given(mockService.retrieveCourses("Leandro")).willReturn(courses);
        String spotifyEngineerCourse = "Spotify Engineering Culture Desmistificado";

        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        // When / Act
        courseBusiness.deleteCoursesNotRelatedToSpring("Leandro");

        // Then / Assert
        then(mockService)
                .should(times(7))
                .deleteCourse(captor.capture());
        assertThat(captor.getAllValues().size(), is(7));
    }

}
