package org.example.mockito.services;

import org.example.mockito.Order;
import org.example.mockito.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class OrderServiceTest {

    private final OrderService orderService = new OrderService();
    private final UUID defaultUUID = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");

    @DisplayName("Should Include Random OrderId When No Order Id Exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
    	// Given / Arrange

        try(MockedStatic<UUID> mockedUUID = mockStatic(UUID.class)){
            mockedUUID.when(UUID::randomUUID).thenReturn(defaultUUID);

    	    // When / Act
            Order result = orderService.createOrder("MacBook Pro", 2L, null);

            assertEquals(defaultUUID.toString(), result.getId());
        }
    	// Then / Assert
    }
}
