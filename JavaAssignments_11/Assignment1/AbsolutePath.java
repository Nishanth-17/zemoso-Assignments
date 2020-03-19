//Create a java program to search through the home directory and look for files that match a regular expression.
// The program should be able to take inputs repeatedly and should print out the full absolute path of the matching
// files found.
//
//Provide appropriate documentation and comments on your code.
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AbsolutePath {
    public static File f;
    public static ArrayList<String> tokens;
    public static void getMatchingFiles(String pattern,File[] names,ArrayList<String> tokens){
        for(int i=0;i<names.length;i++) {
            Pattern tokSplitter = Pattern.compile(pattern);
            Matcher m = tokSplitter.matcher(names[i].getName());
            f = new File(names[i].getPath());
            while (m.find()) {
                tokens.add(f.getAbsolutePath());
            }
            if (f.isDirectory()) {
                File[] subNames = f.listFiles();
                getMatchingFiles(pattern,subNames,tokens);
            }
        }
    }
    public static void main(String args[]) {
        File file = new File("/home");
        File[] names = file.listFiles();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter regex: ");
        while(sc.hasNext()) {
            ArrayList<String> tokens = new ArrayList<String>();
            String pattern = sc.next();
            getMatchingFiles(pattern,names,tokens);
            for (int i = 0; i < tokens.size(); i++){
                System.out.println(tokens.get(i));
        }
        }
    }
}
