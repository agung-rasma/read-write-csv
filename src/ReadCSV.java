
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS
 */
public class ReadCSV {
//    static final String file = "MOCK_DATA.csv";

    public static void main(String[] args) {
        final String file = "MOCK_DATA.csv";
        readCSVWithCommons(file);
//        readCSVManual(file);

    }

    static void readCSVManual(String file) {

        String line = "";

        try (BufferedReader reader = new BufferedReader(new FileReader(file));) {
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                for (String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void readCSVWithCommons(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file));) {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in); //withHeader("id", "first_name", "last_name", "email", "gender", "ip_address")
//            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().format("yyyy-MM-dd"); //withHeader("id", "first_name", "last_name", "email", "gender", "ip_address")
            
            for (CSVRecord record : records) {
                
                String firstName = record.get("first_name");
                String lastName = record.get("last_name");
                Date date=sdf.parse(record.get("date"));
                
                System.out.println(firstName+" "+lastName);
                System.out.println(sdf.format(date));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
