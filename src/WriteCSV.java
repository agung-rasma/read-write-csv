
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class WriteCSV {

    public static void main(String[] args) {
        final String file = "test write.csv";
        writeCSVWithCommons(file);

    }

    static void writeCSVWithCommons(String file) {
        
        try (
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(file));

            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("ID", "Name", "Designation", "Company", "Khusus"));
        ) {
            csvPrinter.printRecord("1", "Sundar Pichai ♥", "CEO", "Google", "`1234567890-=~!@#$%^&*()_+[]\\;',./{}|:\"<>?");
            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft", "`1234567890-=~!@#$%^&*()_+[]\\;',./{}|:\"<>?");
            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple", "`1234567890-=~!@#$%^&*()_+[]\\;',./{}|:\"<>?");
            csvPrinter.printRecord("4", "Agung Wijaya Rasma", "CTO", "Wasundara", "`1234567890-=~!@#$%^&*()_+[]\\;',./{}|:\"<>?");
            csvPrinter.printRecord("5", "New \\\",.;/Agung Wijaya Rasma", "CTO", "Wasundara", "`1234567890-=~!@#$%^&*()_+[]\\;',./{}|:\"<>?");

//            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));

            csvPrinter.flush();            
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
