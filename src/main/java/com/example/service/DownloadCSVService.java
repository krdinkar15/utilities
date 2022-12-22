package com.example.service;

import com.opencsv.CSVWriter;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Service
public class DownloadCSVService  {

    private static final Logger LOG= LoggerFactory.getLogger(DownloadCSVService.class);
    public void downloadFile(HttpServletResponse response) {

        File file=null;
        Writer writer=null;
        CSVWriter csvWriter = null;
        String fileName="sample.csv";
        try {
            LOG.info("Going to create CSV file");


            file=new File(fileName);
            writer= new FileWriter(file);
            csvWriter = new CSVWriter(writer, CSVWriter.DEFAULT_SEPARATOR, CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.NO_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            String[] header = new String[]{"Name, Address"};
            csvWriter.writeNext(header);

            String[] person1=new String[2];
            person1[0]="Kamal";
            person1[1]="sec - 55";

            String[] person2=new String[2];
            person2[0]="Raj";
            person2[1]="sec - 56";

            csvWriter.writeNext(person1);
            csvWriter.writeNext(person2);

            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

            csvWriter.flush();
        }
        catch (Exception ex)
        {
            LOG.error("Exception while writing csv file",ex);
        }

        try {
            InputStream is = new FileInputStream(file);
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException ex) {
            LOG.error("Error writing file to output stream.", ex);
        } finally {
            deleteFile(file);
        }
    }
    public static void deleteFile(File file) {
        if (file != null && file.exists()) {
            file.delete();
        }
    }
}
