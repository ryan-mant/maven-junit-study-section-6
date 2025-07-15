package org.example.mockito;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchers() {
    	// Given / Arrange
        List<Integer> scores = List.of(99,100,101,105);

    	// When & Then

        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        assertThat(scores, everyItem(greaterThan(88)));
        assertThat(scores, everyItem(lessThan(108)));

        //Check Strings

        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));

        //Arrays

        Integer[] myArray = {1,2,3};
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1,2,3));
        assertThat(myArray, arrayContainingInAnyOrder(2,1,3));

    }

}
