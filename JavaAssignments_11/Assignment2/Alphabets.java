//Write a java function that checks if the input string contains all the letters of the alphabet a-z (case-insensitive).
// Write time and space complexity of your solution as comments in the source file.


import java.util.Scanner;

//Time Complexity:  O(N+26)-> O(N)  Linear Time Complexity  //N is the length of the input string
//Space Complexity: O(26) -> O(1)   Constant Space Complexity //Visited boolean array of size 26

public class Alphabets {
    public static boolean checkAlphabets(String input){
        boolean visited[]=new boolean[26];
        input=input.toUpperCase();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)>=65 && input.charAt(i)<=90){
                visited[input.charAt(i)-65]=true;
            }
        }
        for(int i=0;i<26;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter an input String");
        String input=sc.next();
        if(checkAlphabets(input))
            System.out.println("VALID");
        else
            System.out.println("INVALID");
    }
}
