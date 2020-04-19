//Gruber Healthcare has different types of forms for their customer, one of which is a know your customer form (KYC)
// which has to be filled annually. Each form has a date which signifies the date the form was filled called the
// form date.
//
//Due to government regulations the KYC form can only be filled within + or - 30 days of the signup anniversary
// of a customer. When filling it up, you have to provide the form date.
// If you are past the +-30 day anniversary then you can back-date it so that it falls in the +-30-day window.
// When filling it up you cannot use a future date for the form date.
//
//For Example, assuming today is 4 Apr 2017 and I had signed up on 1st Mar 2014, my window for KYC submission
// this year would be 30 Jan 2017 to 31 Mar 2017. Since it is already 4th Apr - I would have to back-date the KYC
// to a date in this range.
//
//Note: The KYC form can be filled only for the closest anniversary in the past or within 30 days range in future.
//Anniversary refers to same day and month every year. If your birthday is 01-02-1992 -then your first anniversary
// will be 01-02-1993, the 2nd will be 01-02-1994 and so on. 01-02-1992 is not an anniversary.
//
//Given the signup date and the current date, provide the allowable date range for the form date.
//
//Input - First line is an integer n as the number of inputs to be passed.
// Next, n lines are n input for the program in the format dd-mm-yyyy dd-mm-yyyy
// Each line has two dates separated by space where the first date in signup date and the
// second date is the current date.
//
//Output - Range of dates for KYC form in format dd-mm-yyyy dd-mm-yyyy
//
//Test Input:
//5
//16-07-1998 27-06-2017
//04-02-2016 04-04-2017
//04-05-2017 04-04-2017
//04-04-2015 04-04-2016
//04-04-2015 15-03-2016
//
//Test output:
//16-06-2017 27-06-2017
//05-01-2017 06-03-2017
//No range
//05-03-2016 04-04-2016
//05-03-2016 15-03-2016

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.io.*;
import java.util.*;

import static javafx.application.Platform.exit;

public class KYCDates {
    public static int[] formatDate(String Date){
        String[] DateList=Date.split("-");
        int[] DateArray=new int[3];
        for(int i=0;i<3;i++){
            DateArray[i]= Integer.parseInt(DateList[i]);
        }
        return DateArray;
    }
    public static Calendar calendarInstance(Calendar calendar,int[] date){
        calendar.set(Calendar.DATE,date[0]);
        calendar.set(Calendar.MONTH,date[1]-1);
        calendar.set(Calendar.YEAR,date[2]);
        return calendar;
    }
    public static String[] calculateKYCRange(Calendar calAnniversary,Calendar calPresent){
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        String[] dateStore=new String[2];
        calAnniversary.add(Calendar.DATE, -30);
        Date beforeDate=calAnniversary.getTime();
        calAnniversary.add(Calendar.DATE,60);
        Date afterDate=calAnniversary.getTime();
        Date presentDate=calPresent.getTime();

        if(beforeDate.before(presentDate) && presentDate.before(afterDate)) {
            dateStore[0] = dateFormat.format(beforeDate);
            dateStore[1] = dateFormat.format(presentDate);
        }
        else if(afterDate.before(presentDate)){
            dateStore[0]=dateFormat.format(beforeDate);
            dateStore[1]=dateFormat.format(afterDate);
        }
        return dateStore;
    }
    public static int verifyRange(String signUpDate,String currentDate){
        int[] SignUpDate=formatDate(signUpDate);
        int[] CurrentDate=formatDate(currentDate);

        //Getting the Current Year's SignUp Date(Anniversary)
        Calendar calendarAnniversary=Calendar.getInstance();
        calendarAnniversary.set(Calendar.DATE,SignUpDate[0]);
        calendarAnniversary.set(Calendar.MONTH,SignUpDate[1]-1);
        calendarAnniversary.set(Calendar.YEAR,CurrentDate[2]);

        //Getting the present date
        Calendar calendarPresent=Calendar.getInstance();
        calendarPresent=calendarInstance(calendarPresent,CurrentDate);

        //Getting the current signup date
        Calendar givenSignUpDate=Calendar.getInstance();
        givenSignUpDate=calendarInstance(givenSignUpDate,SignUpDate);
        if(givenSignUpDate.getTime().after(calendarPresent.getTime())) {
            System.out.println("No range");
            return 0;
        }
        String[] s1=calculateKYCRange(calendarAnniversary,calendarPresent);
        System.out.println(s1[0] + " " + s1[1]);
        return 1;
    }
    public static void main(String args[]) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        ArrayList<String> signUpList=new ArrayList<>();
        ArrayList<String> currentList=new ArrayList<>();
        while (q-- > 0) {
            String signUpDate =sc.next();
            signUpList.add(signUpDate);
            String currentDate = sc.next();
            currentList.add(currentDate);
        }
        for(int i=0;i<currentList.size();i++){
            verifyRange(signUpList.get(i),currentList.get(i));
        }
    }
}