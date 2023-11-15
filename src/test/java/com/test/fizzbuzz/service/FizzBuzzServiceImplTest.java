package com.test.fizzbuzz.service;

import com.test.fizzbuzz.exception.FizzBuzzException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceImplTest {

    @InjectMocks
    private FizzBuzzServiceImpl fizzBuzzServiceImpl;

    @Test
    public void testGetFizzBuzzList_WhenInputIsLessThanOne() {
        // Arrange, Act, and Assert
        Assertions.assertThrows(FizzBuzzException.class, () -> fizzBuzzServiceImpl.getFizzBuzzList(0));
    }

    @Test
    public void testGetFizzBuzzList_WhenInputIsOne() {
        // Arrange, Act, and Assert
        List<String> fizzBuzzList = fizzBuzzServiceImpl.getFizzBuzzList(1);
        Assertions.assertEquals(Arrays.asList("1"), fizzBuzzList);
    }

    @Test
    public void testGetFizzBuzzList_WhenInputIsThree() {
        // Arrange, Act, and Assert
        List<String> fizzBuzzList = fizzBuzzServiceImpl.getFizzBuzzList(3);
        Assertions.assertEquals(Arrays.asList("1", "2", "Fizz"), fizzBuzzList);
    }

    @Test
    public void testGetFizzBuzzList_WhenInputIsFive() {
        // Arrange, Act, and Assert
        List<String> fizzBuzzList = fizzBuzzServiceImpl.getFizzBuzzList(5);
        Assertions.assertEquals(Arrays.asList("1", "2", "Fizz", "4", "Buzz"), fizzBuzzList);
    }

    @Test
    public void testGetFizzBuzzList_WhenInputIsFifteen() {
        // Arrange, Act, and Assert
        List<String> fizzBuzzList = fizzBuzzServiceImpl.getFizzBuzzList(15);
        Assertions.assertEquals(Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"), fizzBuzzList);
    }
}
