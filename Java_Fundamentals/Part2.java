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
