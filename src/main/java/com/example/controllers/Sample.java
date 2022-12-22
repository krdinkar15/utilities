package com.example.controllers;

import com.example.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Sample {


    @Autowired
    private SampleService sampleService;

    private static final Logger LOG= LoggerFactory.getLogger(Sample.class);
    @GetMapping("/generateNumber")
    public double generateRandomNumber()
    {
        LOG.info("Generate Number called");
        return Math.random();
    }

    @GetMapping("/getjokes")
    public String getJokes()
    {
        LOG.info("Get jokes called : ");
        return sampleService.getRndomJoke();

    }

}
