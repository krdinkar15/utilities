package com.example.controllers;

import com.example.service.DownloadCSVService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class DownloadCSV {
    private static final Logger LOG= LoggerFactory.getLogger(DownloadCSV.class);

    @Autowired
    private DownloadCSVService csvService;

    @RequestMapping(value = "/download")
    public void downloadFile(HttpServletResponse response)
    {
        LOG.info("csv downlaod controller hit");
        csvService.downloadFile(response);
    }
}
