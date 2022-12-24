package com.example.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
@RestController
@RequestMapping("/api")
public class UploadCSV {

    private static final Logger LOG= LoggerFactory.getLogger(UploadCSV.class);

    @PostMapping(value = "/upload")
    public boolean uploadFile(@RequestBody MultipartFile csvFile) {
        BufferedReader br;
        try {

            String line;
            InputStream is = csvFile.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
               LOG.info("Hii {} {}",line,"welcome");
            }

        } catch (Exception e) {
            LOG.error("Error in Reading CSV file ",e);
        }
       return true;
    }

}
