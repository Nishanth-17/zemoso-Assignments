// Using the documentation for java.util.regex.Pattern as a resource, write and
// test a regular expression that checks a sentence to see that it begins with a capital letter and ends with a period.
import java.util.Scanner;
import java.util.regex.*;
public class PatternMatcher {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the input string");
        String input=sc.next();
        Pattern patternObject = Pattern.compile("^[A-Z].*[.]$");
        Matcher m = patternObject.matcher(input);
        if(m.matches())
            System.out.println("Sentence starts with Capital Letter and ends with a period ");
        else
            System.out.println("Sentence does not comply with the given condition");
    }
}