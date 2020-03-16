//Write a java function that will ping any host ( given as input ) and computes the median of the time taken to ping.
//
//Use the system ping utility, do not use any deprecated methods.


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ping {
    public static ArrayList<Float> time;
    public static float findMedian(String command, int pingCount){
        Collections.sort(time);
        System.out.println(time);
        int size=time.size();
        if(time.size()%2!=0)
            return time.get(((size+1)/2)-1);
        else
            return (time.get(size/2)+(time.get((size/2)-1)))/2;
    }
    public static void getTimeList(String command,int pingCount){
        ArrayList<String> output=new ArrayList<>();
        ArrayList<String> timeArray=new ArrayList<>();
        time=new ArrayList<>();
        try {
            Runtime rt = Runtime.getRuntime();
            Process process=rt.exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line=null;
            while((line=input.readLine())!=null) {
                output.add(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        for(int i=1;i<=pingCount;i++) {
            timeArray.add(output.get(i));
        }
        for(int i=0;i<timeArray.size();i++){
            String[] timeSplit=timeArray.get(i).split(" ");
            int size=timeSplit.length;
            String timeStr=timeSplit[size-2];
            float timeVal=Float.parseFloat(timeStr.substring(5,timeStr.length()));
            time.add(timeVal);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the hostname and ping count");
        String host=sc.next();
        int pingCount=sc.nextInt();
        String command="ping -c"+pingCount+" "+host;
        getTimeList(command,pingCount);
        System.out.println(findMedian(command,pingCount));
    }
}

