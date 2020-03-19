//Using TextFile and a Map<Character,Integer>, create a program that takes the file name as a command line argument
// and counts the occurrence of all the different characters.
// Save the results in a text file.
import java.io.*;
import java.util.*;

public class Map_FileNames {
    public static void main(String[] args) throws IOException {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        FileReader fr = new FileReader(new File(args[0]));
        int ascii;
        while ((ascii = fr.read()) != -1) {
            Character ch=(char)ascii;
            if (!hashMap.containsKey(ch))
                hashMap.put(ch, 1);
            else
                hashMap.put(ch, hashMap.get(ch) + 1);
        }
        System.out.println(hashMap);
        FileWriter fileop=new FileWriter("occurences.txt");
        for(Map.Entry<Character, Integer> entry:hashMap.entrySet())
            fileop.write(String.valueOf(entry.getKey())+" "+String.valueOf(entry.getValue())+"\n");
        fileop.close();
    }
}