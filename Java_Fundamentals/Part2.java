/*
Part 2: Finding a Gene - Using the Simplified Algorithm Reorganized
This assignment will determine if a DNA strand has a gene in it by using the simplified algorithm from the lesson, but organizing the code in a slightly different way. You will modify the method findSimpleGene to have three parameters, one for the DNA string, one for the start codon and one for the stop codon.

Specifically, you should do the following:

1. Create a new Java Class named Part2 in the StringsFirstAssignments project.

2. Copy and paste the two methods findSimpleGene and testSimpleGene from the Part1 class into the Part2 class.

3. The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.
*/
public class Part2 {
    public static String simpleGene(String dna,int startCodon,int stopCodon){
        if(startCodon==-1)
            return "";
        if(stopCodon ==-1)
            return "";
        String ext=dna.substring(startCodon,stopCodon+3);
        if(ext.length()%3==0)
            return dna.substring(startCodon,stopCodon+3);
        return "";
    }
    public static void testSimpleGene(){
        String dna="ATGCTGTAACTAA";
        dna=dna.toUpperCase();
        int startCodon=dna.indexOf("ATG");
        int stopCodon=dna.indexOf("TAA",startCodon+3);
        System.out.println(simpleGene(dna,startCodon,stopCodon));
    }
}
