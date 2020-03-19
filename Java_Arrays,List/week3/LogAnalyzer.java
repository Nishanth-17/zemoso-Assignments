/*
Assignment: Reading Web Logs
In this assignment you will complete the program to read and print web logs that was described in the lesson.

You will start with the files provided, which include:

The class LogEntry from the lesson that has five private variables, a constructor, five get methods to access
the private fields, and a toString method for printing out a LogEntry.
The Class LogAnalyzer, which has been started for you.
The Class WebLogParser, which we are providing. You should not edit this file—just use its parseEntry method.
The Tester class from the lesson, which has been started for you.
Specifically, you should do the following:

In the LogAnalyzer class you will need to complete the constructor to initialize records to an empty ArrayList and
complete the readFile method to create a FileResource and to iterate over all the lines in the file. For each line,
create a LogEntry and store it in the records ArrayList. (Refer to the lecture on parsing log files for help.)
In the Tester class you will need to complete the testLogAnalyzer method, which creates a LogAnalyzer object,
calls readFile on the data file short-test_log, and then calls printAll to print all the web logs.





Assignment: Unique IPs
In this assignment you will continue to build on the LogEntry and LogAnalyzer classes,
which you learned about in the last lesson. You will continue to use the method parseEntry from the
WebLogParser class, and you should not modify this class. You will write several methods to solve problems about web logs.

Specifically, you should do the following:

In the LogAnalyzer class, write the method countUniqueIPs that has no parameters.
This method should return an integer representing the number of unique IP addresses.
It should also assume that the instance variable records already has its ArrayList of Strings read in from a file,
 and should access records in computing this value. For help, refer to the lectures in this lesson on the
  unique IP algorithm and code.


In the Tester class (or you can write a new class for testing) write the void method testUniqueIP
 that has no parameters. This method should create a LogAnalyzer, read from the file short-test_log,
  and then test the method countUniqueIPs.


In the LogAnalyzer class, write the void method printAllHigherThanNum that has one integer parameter num.
This method should examine all the web log entries in records and print those LogEntrys that have a status code
 greater than num. Be sure to add code in the Tester class to test out this method with the file short-test_log.


In the LogAnalyzer class, write the method uniqueIPVisitsOnDay that has one String parameter named someday in the format
“MMM DD” where MMM is the first three characters of the month name with the first letter capitalized and the others
in lowercase, and DD is the day in two digits (examples are “Dec 05” and “Apr 22”).
This method accesses the web logs in records and returns an ArrayList of Strings of unique IP addresses that
had access on the given day. (Note that the dates in LogEntrys are stored as a Date object,
but using toString will allow you to access the characters in the Date.
For example, consider that d is a Date. String str = d.toString(); allows you to now use a String representation of the date.)
 Be sure to test your program with code in the Tester class. Using the file weblog-short_log you should see that the
 call to uniqueIPVisitsOnDay(“Sep 14”) returns an ArrayList of 2 items and uniqueIPVisitsOnDay(“Sep 30”)
 returns an ArrayList of 3 items.


In the LogAnalyzer class, write the method countUniqueIPsInRange that has two integer parameters named low and high.
This method returns the number of unique IP addresses in records that have a status code in the range from low to high,
inclusive. Be sure to test your program on several ranges. For example, using the file short-test_log,
the call countUniqueIPsInRange(200,299) returns 4, as there are four unique IP addresses that have a status code
from 200 to 299. The call countUniqueIPsInRange(300,399) returns 2.
 In this case, note that there are three entries in the file that have a status code in the 300 range,
 but two of them have the same IP address.





Assignment: Website Visits
In this assignment you will continue to build on the LogEntry and LogAnalyzer classes that you worked on in the last lesson.
You will continue to use the method parseEntry from the WebLogParser class, and you should not modify this class.
You will write several methods to solve problems about web logs. There are four small files you can use to test the methods:
short-test_log, weblog-short_log, weblog2-short_log, and weblog3-short_log. You should write code to test
the methods in a Tester class that creates a LogAnalyzer object.

Specifically, you should do the following:

In the LogAnalyzer class, write the method countVisitsPerIP, which has no parameters.
This method returns a HashMap<String, Integer> that maps an IP address to the number of times that IP address
appears in records, meaning the number of times this IP address visited the website.
Recall that records stores LogEntrys from a file of web logs.




In the LogAnalyzer class, write the method mostNumberVisitsByIP, which has one parameter, a HashMap<String, Integer>
that maps an IP address to the number of times that IP address appears in the web log file.
This method returns the maximum number of visits to this website by a single IP address.
 For example, the call mostNumberVisitsByIP on a HashMap formed using the file weblog3-short_log returns 3.




In the LogAnalyzer class, write the method iPsMostVisits, which has one parameter, a HashMap<String, Integer>
that maps an IP address to the number of times that IP address appears in the web log file.
This method returns an ArrayList of Strings of IP addresses that all have the maximum number of visits to this website.
 For example, the call iPsMostVisits on a HashMap formed using the file weblog3-short_log returns the ArrayList with
 these two IP addresses, 61.15.121.171 and 84.133.195.161. Both of them visited the site three times,
 which is the maximum number of times any IP address visited the site.



In the LogAnalyzer class, write the method iPsForDays, which has no parameters.
This method returns a HashMap<String, ArrayList<String>> that uses records and maps days from web logs to an ArrayList
 of IP addresses that occurred on that day (including repeated IP addresses).
 A day is in the format “MMM DD” where MMM is the first three characters of the month name with the first letter capital
 and the others in lowercase, and DD is the day in two digits (examples are “Dec 05” and “Apr 22”).
 For example, for the file weblog3-short_log, after building this HashMap, if you print it out,
 you will see that Sep 14 maps to one IP address, Sep 21 maps to four IP addresses, and Sep 30 maps to five IP addresses.
*/

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        // complete constructor
        records=new ArrayList<>();
    }

    public void readFile(String filename) {
        // complete method
        FileResource fr=new FileResource(filename);
        for(String line:fr.lines()){
            LogEntry logEntry=WebLogParser.parseEntry(line);
            records.add(logEntry);
        }
    }
    public int countUniqueIPs(){
        ArrayList<String> uniqueList=new ArrayList<>();
        for(LogEntry le:records){
            if(!uniqueList.contains(le.getIpAddress())){
                uniqueList.add(le.getIpAddress());
            }
        }
            return uniqueList.size();
    }
    public void printAllHigherThanNum(int num) {
        for (LogEntry le :records){
            if(le.getStatusCode()>num)
                System.out.println(le.getStatusCode());
        }
    }
    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        String[] someDate=someday.split(" ");
        ArrayList<String> uniqueList=new ArrayList<>();
        for(LogEntry le:records){
            String[] date=le.getAccessTime().toString().split(" ");
            if(date[1].equals(someDate[0]) && date[2].equals(someDate[1])){
                if(!uniqueList.contains(le.getIpAddress())){
                    uniqueList.add(le.getIpAddress());
                }
            }
        }
        return uniqueList;
    }
    public int countUniqueIPsInRange(int low, int high){
        ArrayList<String> uniqueList=new ArrayList<>();
        for(LogEntry le:records){
            if(!uniqueList.contains(le.getIpAddress())){
                if(le.getStatusCode()>=low && le.getStatusCode()<=high)
                    uniqueList.add(le.getIpAddress());
            }
        }
        return uniqueList.size();
    }
    public HashMap<String,Integer> countVisitsPerIP(){
        HashMap<String, Integer> visitMap=new HashMap<>();
        for(LogEntry le:records){
            String IP=le.getIpAddress();
            if(!visitMap.containsKey(IP)){
                visitMap.put(IP,1);
            }
            else{
                visitMap.put(IP,visitMap.get(IP)+1);
            }
        }
        return visitMap;
    }
    public int mostNumberVisitsByIP(HashMap<String,Integer> hm){
        int max=0;
        for(Map.Entry mapElement:hm.entrySet()){
            if((int)mapElement.getValue()>max)
                max=(int)mapElement.getValue();
        }
        return max;
    }
    public ArrayList<String> iPsMostVisits(HashMap<String,Integer> visitMap){
        ArrayList<String> IP=new ArrayList<>();
        int MaxNumber=mostNumberVisitsByIP(visitMap);
        for(Map.Entry mapElement: visitMap.entrySet()){
            if(MaxNumber==(int)mapElement.getValue()){
                IP.add((String)mapElement.getKey());
            }
        }
        return IP;
    }
    public HashMap<String,ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> ipMap=new HashMap<String, ArrayList<String>>();
        for(LogEntry logEntry:records){
            String date=logEntry.getAccessTime().toString();
            String[] dateFormat=date.split(" ");
            String day=dateFormat[1]+dateFormat[2];
                    if(!ipMap.containsKey(day)) {
                        ArrayList<String> ipList=new ArrayList<>();
                        ipList.add(logEntry.getIpAddress().toString());
                        ipMap.put(day, ipList);
                    }
                    else{
                        ArrayList<String> al=ipMap.get(day);
                        al.add(logEntry.getIpAddress().toString());
                        ipMap.put(day,al);
                    }
                }
        return ipMap;
    }
    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
}