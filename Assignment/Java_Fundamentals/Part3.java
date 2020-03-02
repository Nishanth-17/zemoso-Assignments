/*
Part 3: Problem Solving with Strings
This assignment will give you additional practice using String methods. You will write two methods to solve some problems using strings and a third method to test these two methods.

Specifically, you should do the following:

1. Create a new Java Class named Part3 in the StringsFirstAssignments project. Put the following methods in this class.

2. Write the method named twoOccurrences that has two String parameters named stringa and stringb. This method returns true if stringa appears at least twice in stringb, otherwise it returns false. For example, the call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”, the call twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a” occurs at least twice, and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one occurence of “atg”.

3. Write the void method named testing that has no parameters. This method should call twoOccurrences on several pairs of strings and print the strings and the result of calling twoOccurrences (true or false) for each pair. Be sure to test examples that should result in true and examples that should result in false.

4. Write the method named lastPart that has two String parameters named stringa and stringb. This method finds the first occurrence of stringa in stringb, and returns the part of stringb that follows stringa. If stringa does not occur in stringb, then return stringb. For example, the call lastPart(“an”, “banana”) returns the string “ana”, the part of the string after the first “an”. The call lastPart(“zoo”, “forest”) returns the string “forest” since “zoo” does not appear in that word.

5. Add code to the method testing to call the method lastPart with several pairs of strings. For each call print the strings passed in and the result. For example, the output for the two calls above might be:

The part of the string after an in banana is ana.
The part of the string after zoo in forest is forest.
*/
public class Part3 {
    public boolean twoOcuurrences(String str1, String str2) {
        int count = 0;
        int startFrom = 0;
        int p = 0;
        while ((p = str2.indexOf(str1, startFrom)) != -1) {
            count++;
            startFrom = p + str1.length();
        }
        if (count > 1)
            return true;
        return false;
    }
    public String lastPart(String str1,String str2){
        int index=str2.indexOf(str1);
        if(index==-1)
            return str2;
        else
            return str2.substring(index+str1.length());
    }
    void testing(){
        String []a={"hi","hello","okay"};
        String []b={"hey hey hey","okay","hello hello hello "};
        for(int i=0;i<a.length;i++)
            System.out.println("Stringa is "+a[i]+"\n"+
                                "Stringb is "+b[i]+"\n"+
                                "Two occurences " + twoOcuurrences(a[i], b[i])+"\n"+
                                "The part of the string after "+a[i]+" in "+b[i]+" is "+lastPart(a[i],b[i]));
    }
    public static void main(String[] args) {
        Part3 findString = new Part3();
        findString.testing();

    }
}

