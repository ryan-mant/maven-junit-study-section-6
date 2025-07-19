package org.example.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ListMockWithBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {
    	// Given / Arrange

        List<?> list = mock(List.class);

//        when(list.size()).thenReturn(10);
        given(list.size()).willReturn(10);



    	// When / Act & Then / Assert

        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {
        // Given / Arrange

        List<?> list = mock(List.class);

//        when(list.size()).thenReturn(10).thenReturn(20).thenReturn(30).thenReturn(40);
        given(list.size()).willReturn(10).willReturn(20).willReturn(30).willReturn(40);



        // When / Act & Then / Assert

        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(30));
        assertThat(list.size(), is(40));
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnErudio() {
        // Given / Arrange

        var list = mock(List.class);

//        when(list.get(0)).thenReturn("Erudio");
        given(list.get(0)).willReturn("Erudio");



        // When / Act & Then / Assert

        assertThat(list.get(0), is("Erudio"));
        assertThat(list.get(1), is(nullValue()));
    }

    @Test
    void testMockingList_When_GetIsCalledWithArgumentMatcher_ShouldReturnErudio() {
        // Given / Arrange

        var list = mock(List.class);

//        when(list.get(anyInt())).thenReturn("Erudio");
        given(list.get(anyInt())).willReturn("Erudio");



        // When / Act & Then / Assert

        assertThat(list.get(anyInt()), is("Erudio"));
//        assertThat(list.get(anyInt()), is(nullValue()));
    }

    @Test
    void testMockingList_When_ThrowsAnException() {
        // Given / Arrange

        var list = mock(List.class);

//        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo bar"));
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo bar"));



        // When / Act & Then / Assert

        assertThrows(RuntimeException.class, () -> list.get(anyInt()), "Expected RuntimeException");
    }
}
