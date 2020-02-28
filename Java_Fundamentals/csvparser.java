import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.IOException;

public class csvparser {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        //countryInfo(parser,"Country");
        //listExporterTwoProducts(parser,"gold","diamonds");
        bigExporters(parser, "$999,999,999,999");
    }
    public String countryInfo(CSVParser parser, String country) {
        for(CSVRecord record: parser) {
            String countryn=record.get(country);
            if(countryn.contains("Nauru"))
                System.out.println(countryn + ": "+ record.get("Exports")+": "+record.get("Value (dollars)"));
        }return "NOT FOUND";
    }
    public void listExporterTwoProducts(CSVParser parser, String export1,String export2){
        for(CSVRecord record:parser){
            String exp=record.get("Exports");
            if(exp.contains(export1) && exp.contains(export2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    public void bigExporters(CSVParser parser, String amount){
        for(CSVRecord record:parser){
            if(record.get("Value (dollars)").length() > amount.length())
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
        }
    }
    public static void main(String args[]){
        csvparser c=new csvparser();
        c.tester();
    }
}
