/*
Assignment 2: Caesar Cipher

Specifically, you should do the following:

Create a new class called CaesarCipher.
Write the method encrypt that has two parameters, a String named input and an int named key.
This method returns a String that has been encrypted using the Caesar Cipher algorithm explained in the videos.
Assume that all the alphabetic characters are uppercase letters. For example, the call
encrypt(“FIRST LEGION ATTACK EAST FLANK!”, 23)

should return the string

“CFOPQ IBDFLK XQQXZH BXPQ CIXKH!”

Write the void method testCaesar that has no parameters.
This method should read a file and encrypt the complete file using the Caesar Cipher algorithm,
printing the encrypted message.


Modify the encrypt method to be able to handle both uppercase and lowercase letters.
For example, encrypt(“First Legion”, 23) should return “Cfopq Ibdflk”, and encrypt(“First Legion”, 17)
should return “Wzijk Cvxzfe”. Be sure to test the encrypt method.


Write the method encryptTwoKeys that has three parameters, a String named input, and two integers named key1 and key2.
 This method returns a String that has been encrypted using the following algorithm. Parameter key1 is used to encrypt
  every other character with the Caesar Cipher algorithm, starting with the first character, and key2 is used to
  encrypt every other character, starting with the second character.
  For example, the call encryptTwoKeys(“First Legion”, 23, 17) should return “Czojq Ivdzle”.
  Note the ‘F’ is encrypted with key 23, the first ‘i’ with 17, the ‘r’ with 23, and the ‘s’ with 17, etc.




Assignment 1: One Key
Create the CaesarCipher class with the following parts:

Private fields for the alphabet and shiftedAlphabet


Write a constructor CaesarCipher that has one int parameter key. This method should initialize all the
 private fields of the class.


Write an encrypt method that has one String parameter named input.
This method returns a String that is the input encrypted using shiftedAlphabet.


Write a decrypt method that has one String parameter named input.
This method returns a String that is the encrypted String decrypted using the key associated with
this CaesarCipher object. One way to do this is to create another private field mainKey,
which is initialized to be the value of key.
Then you can create a CaesarCipher object within decrypt: CaesarCipher cc = new CaesarCipher(26 - mainKey);
and call cc.encrypt(input).
  */
import edu.duke.*;
import sun.applet.Main;

import java.lang.*;

import static java.lang.Character.toLowerCase;

public class CaesarCipher {
    private String Alphabets;
    private String shiftedAlphabets;
    private int MainKey;
    CaesarCipher(int key){
        Alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabets=Alphabets.substring(key)+Alphabets.substring(0,key);
        MainKey=key;
    }
    public String encrypt(String input){
        StringBuilder Encrypted=new StringBuilder(input);
        for(int i=0;i<input.length();i++){
            if((int)input.charAt(i)>=65 && (int)input.charAt(i)<=90) {
                int Index = Alphabets.indexOf(input.charAt(i));
                Encrypted.setCharAt(i, shiftedAlphabets.charAt(Index));
            }
            else if((int)input.charAt(i)>=97 && (int)input.charAt(i)<=122){
                int CapAscii=(int)input.charAt(i)-32;
                int Index=Alphabets.indexOf((char)CapAscii);
                Encrypted.setCharAt(i,toLowerCase(shiftedAlphabets.charAt(Index)));
            }
        }
        return Encrypted.toString();
    }
    public String decrypt(String input){
        CaesarCipher cc=new CaesarCipher(26-MainKey);
        return cc.encrypt(input);
    }

    public char encryptChar(String CCAlphabets,char ch){
        String Alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char EncryptedCharacter=' ';
        if((int)ch>=65 && (int)ch<=90) {
            int Index = Alphabets.indexOf(ch);
             EncryptedCharacter=CCAlphabets.charAt(Index);
        }
        else if((int)ch>=97 && (int)ch<=122){
            int CapAscii=(int)ch-32;
            int Index=Alphabets.indexOf((char)CapAscii);
            EncryptedCharacter=toLowerCase(CCAlphabets.charAt(Index));
        }
        else
            return ch;
        return EncryptedCharacter;
    }
    public String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder Encrypted=new StringBuilder(input);
        String enc="";
        String Alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String CCAlphabets1=Alphabets.substring(key1);
        CCAlphabets1+=Alphabets.substring(0,key1);
        String CCAlphabets2=Alphabets.substring(key2);
        CCAlphabets2+=Alphabets.substring(0,key2);
        char ch=' ';
        for(int i=0;i<input.length();i++){
            ch=input.charAt(i);
            if(i%2==0){
                enc=enc+encryptChar(CCAlphabets1,ch);
            }
            else
                enc=enc+encryptChar(CCAlphabets2,ch);
        }
        return enc;
    }
    public void testCaesar(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //String encrypted = encrypt(message,23);
        //System.out.println("key is " + 23 + "\n" + encrypted);
    }
    public static void main(String args[]){
        //CaesarCipher c=new CaesarCipher();
        //c.testCaesar();
        //System.out.println(c.encryptTwoKeys("First Legion!", 23, 17));
        //System.out.println(c.encrypt("First LEGION ATTACK EAST FLANK!", 23));
        //System.out.println(c.encrypt("Lujyfwapvu huk zljbypaf hyl mbuk!", 19));
        //System.out.println(c.encryptTwoKeys("YELL LOUD!", 8, 21));


    }
}
