//A vampire number v is a number with an even number of digits n, that can be factored into two numbers x and y
// each with n/2 digits and not both with trailing zeroes, where v contains precisely
// all the digits from x and from y, in any order.
// Write a java program to print first 100 vampire numbers.
import java.io.*;
import java.util.*;
public class Vampire {
    static int cnt=0;
    public static void findFactors(Integer number) {
        for (int i = 1; i * i <= number; i++) {
            if (number % i == 0) {
                Integer factor1 = i;
                Integer factor2 = number / i;
                if (factor1.toString().length() == factor2.toString().length()) {
                    checkPresence(number, factor1, factor2);
                }
            }
        }
    }
    public static String processStr(String str)
    {
        char[] chArray=str.toCharArray();
        Arrays.sort(chArray);
        String str1=String.valueOf(chArray);
        return str1;
    }
    public static void checkPresence(Integer num,Integer factor1,Integer factor2){
        String fact1=factor1.toString();
        String fact2=factor2.toString();
        String fact=fact1+fact2;
        String str1=processStr(fact);
        String str2=processStr(num.toString());
        if(str1.equals(str2)) {
            if (fact1.endsWith("0") && !fact2.endsWith("0") || !fact1.endsWith("0") && fact2.endsWith("0")) {
                cnt++;
                System.out.println(num + " is a Vampire Number with Fangs " + fact1 + " and " + fact2+" -> "+cnt);
            }
        }
    }
    public static void main(String args[]){
        for(Integer i=1260;cnt<100;i++) {
            if (i.toString().length() % 2 == 0)
                findFactors(i);
        }
    }
}
