package com.test.fizzbuzz.service;

import com.test.fizzbuzz.exception.FizzBuzzException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public List<String> getFizzBuzzList(int number) {

        if (number < 1) {
            throw new FizzBuzzException("The input value must be greater than or equal to 1");
        }

        List<String> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

}