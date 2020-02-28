public class Part1 {
    public static String simpleGene(String dna){
        int StartIndex=dna.indexOf("ATG");
        if(StartIndex==-1)
            return "";
        int StopIndex=dna.indexOf("TAA",StartIndex+3);
        if(StopIndex==-1)
            return "";
        String ext=dna.substring(StartIndex,StopIndex+3);
        if(ext.length()%3==0)
            return dna.substring(StartIndex,StopIndex+3);
        return "";
    }
    public static void testSimpleGene(){
        String dna="ATGCTGTAACTAA";
        System.out.println(simpleGene(dna));
    }
    public static void main(String args[])
    {
        testSimpleGene();
    }
}
