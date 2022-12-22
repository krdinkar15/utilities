package com.example.service;

import com.example.entity.Joke;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SampleService {
    private static Logger LOG= LoggerFactory.getLogger(SampleService.class);
    public String  getRndomJoke() {

        String uri="https://official-joke-api.appspot.com/random_joke";
        RestTemplate restTemplate=new RestTemplate();
        String json=restTemplate.getForObject(uri,String.class);
        Joke joke=convertToObject(json);
        LOG.info(joke.toString());
        return joke.getSetup() +"\n"+joke.getPunchLine();


    }

    private Joke convertToObject(String json){

        ObjectMapper objectMapper=new ObjectMapper();
        Joke joke=null;
        try {
            joke = objectMapper.readValue(json, Joke.class);
        }catch (Exception ex)
        {
            LOG.error("Exception in object Mapper "+ex);
        }
       return joke;
    }
}
