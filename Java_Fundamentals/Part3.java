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
        String []a={"hey","raju","cool"};
        String []b={"hey hey hey","okay raju ","cool cool cool "};
        for(int i=0;i<a.length;i++)
            System.out.println("Stringa is "+a[i]+"\n"+
                                "Stringb is "+b[i]+"\n"+
                                "Atlesat twoOccurances " + twoOcuurrences(a[i], b[i])+"\n"+
                                "The part of the string after "+a[i]+" in "+b[i]+" is "+lastPart(a[i],b[i]));
    }
    public static void main(String[] args) {
        Part3 findString = new Part3();
        findString.testing();

    }
}

