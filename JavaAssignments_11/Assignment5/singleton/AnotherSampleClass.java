////Create another class in package yourname.assignment.singleton containing a non static String member variable.
// Add a static method that takes String as parameter
// and initialize the member variable and then return object of that class.
// Add a non static method to print the String.

package Nishanth.Assignments.singleton;
//Non Static members cannot be accessed inside static methods.
public class AnotherSampleClass {
    public String str;
    public static AnotherSampleClass initStr(String string){
        AnotherSampleClass obj=new AnotherSampleClass();
        //str=string;
        return obj;
    }
    public void printStr(){
        System.out.println("String initialized to "+str);
    }
}
