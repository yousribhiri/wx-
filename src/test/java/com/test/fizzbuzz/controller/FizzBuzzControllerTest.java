package com.test.fizzbuzz.controller;

import com.test.fizzbuzz.exception.FizzBuzzException;
import com.test.fizzbuzz.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzControllerTest {

    @Mock
    private FizzBuzzService fizzBuzzService;

    @InjectMocks
    private FizzBuzzController fizzBuzzController;


    @Test
    public void testGetFizzBuzzList_validInput() {
        // Arrange
        List<String> expectedResult = List.of("1", "2", "Fizz", "4", "Buzz");

        when(fizzBuzzService.getFizzBuzzList(5)).thenReturn(expectedResult);

        // Act
        ResponseEntity<List<String>> actualResult = fizzBuzzController.getFizzBuzzList(5);

        // Assert
        assertEquals(HttpStatus.OK, actualResult.getStatusCode());
        assertEquals(expectedResult, actualResult.getBody());
    }

    @Test
    public void testGetFizzBuzzList_InvalidInput() {
        // Arrange
        int invalidInput = 0;

        // When
        when(fizzBuzzService.getFizzBuzzList(invalidInput))
                .thenThrow(new FizzBuzzException("The input value must be greater than or equal to 1"));

        // Act
        FizzBuzzException exception = assertThrows(FizzBuzzException.class, () -> {
            ResponseEntity<List<String>> responseEntity = fizzBuzzController.getFizzBuzzList(invalidInput);
        });

        // Assert
        assertEquals("The input value must be greater than or equal to 1", exception.getMessage());
    }
}
