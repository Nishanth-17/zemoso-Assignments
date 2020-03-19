/*
Create the TestCaesarCipher class with the following parts:

Include the methods countLetters and maxIndex that you wrote in the previous lesson.


Write the void method simpleTests that has no parameters.
This method should read in a file as a String, create a CaesarCipher object with key 18,
encrypt the String read in using the CaesarCipher object, print the encrypted String, and
decrypt the encrypted String using the decrypt method.


Write the method breakCaesarCipher that has one String parameter named input.
This method should figure out which key was used to encrypt this message (in a similar manner as the previous lesson),
 then create a CaesarCipher object with that key and decrypt the message.

In the simpleTests method, add a call to breakCaesarCipher on the encrypted String to decrypt
it automatically by determining the key, and print the decrypted String.
 */
import edu.duke.FileResource;


public class TestCaesarCipher {
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
    public static void simpleTests(){
        FileResource fr=new FileResource();
        String contents=fr.asString();
        CaesarCipher object1=new CaesarCipher(18);
        String encrypted=object1.encrypt(contents);
        System.out.println(encrypted);
        System.out.println("Decrypted message by passing key: "+object1.decrypt(encrypted));
        System.out.println("Decrypted message without any key(Automatic key determination) :-");
        breakCaesarCipher(encrypted);
    }
    public static void breakCaesarCipher(String input){
        int key=CaesarBreaker.getKey(input);
        CaesarCipher object2=new CaesarCipher(key);
        System.out.println(object2.decrypt(input));
    }
    public static void main(String args[]){
        simpleTests();
    }
}
