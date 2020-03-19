/*
Create the TestCaesarCipherTwo class with the following parts:

Include the methods halfOfString, countLetters, and maxIndex that you wrote in the previous lesson.


Write the void method simpleTests that has no parameters.
This method should read in a file as a String, create a CaesarCipherTwo object with keys 17 and 3,
encrypt the String using the CaesarCipherTwo object, print the encrypted String, and
decrypt the encrypted String using the decrypt method.


Write the method breakCaesarCipher that has one String parameter named input.
This method should figure out which keys were used to encrypt this message (in a similar manner as before),
then create a CaesarCipherTwo object with that key and decrypt the message.


In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt it automatically
by determining the keys, and then print the decrypted String.

 */
import edu.duke.FileResource;
import java.lang.*;

public class TestCaesarCipherTwo {
    public static int[] countLetters(String input,int[] counts){
        for(int i=0;i<input.length();i++){
            if(Character.isLetter(input.charAt(i)))
                counts[(int)Character.toLowerCase(input.charAt(i))-97]++;
        }
        return counts;
    }
    public static int maxIndex(int[] values){
        int MaxIndex=0;
        for(int i=0;i<values.length;i++){
            if(values[i]>values[MaxIndex]){
                MaxIndex=i;
            }
        }
        return MaxIndex;
    }
    public static String halfOfString(String message, int start){
        String  enc="";
        for(int i=start;i<message.length();i+=2){
            enc+=message.charAt(i);
        }
        return enc;
    }
    public static int getKey(String s){
        int counts[]=new int[26];
        int[] let=countLetters(s,counts);
        int MaxIndex=maxIndex(let);
        int key=MaxIndex-4;
        if(MaxIndex<4){
            key=26-(4-MaxIndex);
        }
        return key;
    }
    public static void simpleTests(){
        FileResource fr=new FileResource();
        String contents=fr.asString();
        CaesarCipherTwo object1=new CaesarCipherTwo(17,3);
        String encrypted=object1.encrypt(contents);
        System.out.println(encrypted);
        System.out.println("Decrypted message by passing key: " + object1.decrypt(encrypted));
        System.out.println("Decrypted message without any key(Automatic key determination) :-");
        breakCaesarCipher(encrypted);
    }
    public static void breakCaesarCipher(String input){
        String FirstHalf=halfOfString(input,0);
        String SecondHalf=halfOfString(input,1);
        int Key1=getKey(FirstHalf);
        int Key2=getKey(SecondHalf);
        System.out.println("Keys are "+Key1+" and "+Key2);
        CaesarCipherTwo object2=new CaesarCipherTwo(Key1,Key2);
        System.out.println(object2.decrypt(input));
    }
    public static void main(String args[]){
        simpleTests();
    }
}
