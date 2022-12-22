package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sample {

    private static final Logger LOG= LoggerFactory.getLogger(Sample.class);
    @GetMapping("/generateNumber")
    @ResponseBody
    public double generateRandomNumber()
    {
        LOG.info("Generate Number called");
        return Math.random();
    }

}
