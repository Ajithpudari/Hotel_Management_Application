package com.hotel.management;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController
{
    @GetMapping("/hi")
    public String hello()
    {
        return "Happy";
    }
}
