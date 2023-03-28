package filesManipulation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRead {
    private static final Logger LOG= LoggerFactory.getLogger(CSVRead.class);
    public static void main(String[] args) {
        String projectDirectory=System.getProperty("user.dir");
        String filename=projectDirectory+"/src/main/java/filesManipulation/students.csv";
        try {
            BufferedReader br=new BufferedReader(new FileReader(filename));
            String[] header=br.readLine().split(",");
            int numberOfColumns=header.length;
            LOG.info("No of columns {}",numberOfColumns);
            for(String arr:header)
               LOG.info(arr);
            int numberOfRecords=0;
            while (br.readLine() != null) {
                numberOfRecords++;
            }
            LOG.info("No of records {}",numberOfRecords);
            br.close();
            br = new BufferedReader(new FileReader(filename));
            String[][] data=new String[numberOfRecords][numberOfColumns];
            br.readLine();
            int i=0;
            String line;
            while((line=br.readLine())!=null)
            {
                data[i]=line.split(",");
                i++;
            }

            for (String[] row : data) {
                for (String field : row) {
                    LOG.info("{}",field);
                }
                LOG.info("");
            }





        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
