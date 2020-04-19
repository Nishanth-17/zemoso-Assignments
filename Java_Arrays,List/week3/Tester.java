import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.println("All the log records present in log :");
        logAnalyzer.printAll();
    }
    public void testUniqueIP(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        int uniqueIPsCount=logAnalyzer.countUniqueIPs();
        System.out.println("Number of visitors : "+ uniqueIPsCount);
    }
    public void testPrintAllHigherThanNum(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.println("Status Codes greater than 200:");
        logAnalyzer.printAllHigherThanNum(200);
    }
    public void testuniqueIPVisitsOnDay(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("weblog-short_log");
        ArrayList<String> uniqueIpList=logAnalyzer.uniqueIPVisitsOnDay("Sep 30");
        System.out.println("Vistor IP on given day: ");
        for(String ip:uniqueIpList)
            System.out.print(ip+"\n");
    }
    public void testCountUniqueIPsInRange(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("short-test_log");
        System.out.print("Number of Unique IPs in a given range: ");
        int countUniqueIpsInRange=logAnalyzer.countUniqueIPsInRange(300,399);
        System.out.print(countUniqueIpsInRange);
    }
    public void testMostNumberVisitsByIP(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("weblog3-short_log");
        HashMap<String,Integer> visitsMap=logAnalyzer.countVisitsPerIP();
        System.out.print("\nMost number of visits by an IP: ");
        System.out.print(logAnalyzer.mostNumberVisitsByIP(visitsMap)+"\n");
    }
    public void testIPsMostVisits(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("weblog3-short_log");
        HashMap<String,Integer> visitMap=logAnalyzer.countVisitsPerIP();
        ArrayList<String> IP=logAnalyzer.iPsMostVisits(visitMap);
        System.out.println("IPs with most number of visits: ");
        for(String ip: IP)
            System.out.println(ip);
    }
    public void testIpsForDays(){
        LogAnalyzer logAnalyzer=new LogAnalyzer();
        logAnalyzer.readFile("weblog3-short_log");
        HashMap<String,ArrayList<String>> dayMap=logAnalyzer.iPsForDays();
        for(Map.Entry mapElement:dayMap.entrySet()){
            System.out.println(mapElement.getKey()+" : "+ mapElement.getValue());
        }
    }
    public static void main(String args[]){
        Tester test=new Tester();
        test.testLogAnalyzer();
        test.testUniqueIP();
        test.testPrintAllHigherThanNum();
        test.testuniqueIPVisitsOnDay();
        test.testCountUniqueIPsInRange();
        test.testMostNumberVisitsByIP();
        test.testIPsMostVisits();
        test.testIpsForDays();
    }
}