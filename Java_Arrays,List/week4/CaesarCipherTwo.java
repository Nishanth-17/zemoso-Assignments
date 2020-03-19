/*
Assignment 2: Two Keys
In this assignment, you will put together the CaesarCipherTwo class that encrypts a message with
two keys (the same way as the previous lesson: key1 is used to encrypt every other letter,
starting with the first, and key2 is used to encrypt every other letter, starting with the second),
and also decrypts the same message. In addition you will create a second class,
TestCaesarCipherTwo to test examples that use the CaesarCipherTwo class,
including writing a method that will automatically decrypt an encrypted file by determining the two keys
that were used to encrypt it.

Specifically, you should do the following.

Create the CaesarCipherTwo class with the following parts:

Include private fields for the alphabet, shiftedAlphabet1, and shiftedAlphabet2.


Write a constructor CaesarCipherTwo that has two int parameters key1 and key2.
This method should initialize all the private fields.


Write an encrypt method that has one String parameter named input.
This method returns a String that is the input encrypted using the two shifted alphabets.


Write a decrypt method that has one String parameter named input.
This method returns a String that is the encrypted String decrypted using the key1 and key2
associated with this CaesarCipherTwo object. You might want to add more private fields to the class.
 */
import static java.lang.Character.toLowerCase;

public class CaesarCipherTwo {
    private String alphabet,shiftedAlphabet1,shiftedAlphabet2;
    private int MainKey1,MainKey2;
    CaesarCipherTwo(int key1,int key2){
        alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
        MainKey1=key1;
        MainKey2=key2;
    }
    public String encrypt(String input) {
        StringBuilder Encrypted = new StringBuilder(input);
        String enc = "";
        char ch = ' ';
        for (int i = 0; i < input.length(); i++) {
            ch = input.charAt(i);
            if (i % 2 == 0) {
                enc = enc + encryptChar(shiftedAlphabet1, ch);
            } else
                enc = enc + encryptChar(shiftedAlphabet2, ch);
        }
        return enc;
    }
    public char encryptChar(String CCAlphabets,char ch){
        char EncryptedCharacter=' ';
        if((int)ch>=65 && (int)ch<=90) {
            int Index = alphabet.indexOf(ch);
            EncryptedCharacter=CCAlphabets.charAt(Index);
        }
        else if((int)ch>=97 && (int)ch<=122){
            int CapAscii=(int)ch-32;
            int Index=alphabet.indexOf((char)CapAscii);
            EncryptedCharacter=toLowerCase(CCAlphabets.charAt(Index));
        }
        else
            return ch;
        return EncryptedCharacter;
    }
    public String decrypt(String encrypted){
        CaesarCipherTwo cctwo=new CaesarCipherTwo(12,23);
        return cctwo.encrypt(encrypted);
    }
}
