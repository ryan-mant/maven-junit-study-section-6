package org.example.mockito.services;

import org.example.mockito.Order;
import org.example.mockito.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

public class OrderServiceTest {

    private final OrderService orderService = new OrderService();
    private final UUID defaultUUID = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2025, 7, 19, 10, 30);

    @DisplayName("Should Include Random OrderId When No Order Id Exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists() {
    	// Given / Arrange

        try(MockedStatic<UUID> mockedUUID = mockStatic(UUID.class)){
            mockedUUID.when(UUID::randomUUID).thenReturn(defaultUUID);

    	    // When / Act
            Order result = orderService.createOrder("MacBook Pro", 2L, null);

    	    // Then / Assert
            assertEquals(defaultUUID.toString(), result.getId());
        }
    }

    @DisplayName("Should Include Current Time When Create A New Order")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder() {
        // Given / Arrange

        try(MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)){
            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            // When / Act
            Order result = orderService.createOrder("MacBook Pro", 2L, null);

            // Then / Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }
}
