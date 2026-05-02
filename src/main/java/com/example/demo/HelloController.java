package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hello() {
		return "Hello World!";

	}

 public static boolean isLeapYear(int year) {
        // A year is a leap year if it is divisible by 4,
        // except years divisible by 100 are not leap years,
        // unless they are also divisible by 400.
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

}