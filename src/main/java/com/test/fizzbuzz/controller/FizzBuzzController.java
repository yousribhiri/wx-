package com.test.fizzbuzz.controller;

import com.test.fizzbuzz.service.FizzBuzzService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Tag(name = "FizzBuzz Operations", description = "APIs for FizzBuzz generation")
public class FizzBuzzController {

    private final FizzBuzzService fizzBuzzService;


    @Operation(
            summary = "Generate FizzBuzz List",
            description = "This API returns a list of strings based on the FizzBuzz logic for the provided input."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "OK",
                    content = {@Content(mediaType = "application/json")}
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = {@Content(mediaType = "application/json")}
            )
    })
    @GetMapping("/fizzbuzz/{number}")
    public ResponseEntity<List<String>> getFizzBuzzList(@PathVariable("number") int number) {
        return ResponseEntity.ok(fizzBuzzService.getFizzBuzzList(number));
    }

}
