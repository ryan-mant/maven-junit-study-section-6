package org.example.mockito.staticwithparams;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

public class MyUtilsTest {

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    @DisplayName("Should Mock Static Method With Params")
    @Test
    void testShouldMockStaticMethodWithParams() {
    	try(MockedStatic<MyUtils> mockedMyUtils = mockStatic(MyUtils.class)) {
            mockedMyUtils.when(() -> MyUtils.getWelcomeMessage(eq("Erudio"), anyBoolean()))
                    .thenReturn("Howdy Erudio!");

            String result = MyUtils.getWelcomeMessage("Erudio", true);

            assertEquals("Howdy Erudio!", result);
        }
    }
}
