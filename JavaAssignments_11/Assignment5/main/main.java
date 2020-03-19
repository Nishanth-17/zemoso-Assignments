////Create main class in package yourname.assignment.main,
// create object of first class and call both the methods to print the values.
// Create object of second class using static method and then call the other method to print the String.
////
////One or more tasks mentioned above are not possible in JAVA,
// comment that part of the code with block comments and add the explanation for the same.

package Nishanth.Assignments.main;
//Code which isn't a declaration must be inside some method. We cannot instantiate a class outside a method.We can create a
//reference for the same, but we cannot initialize it.
import Nishanth.Assignments.data.SampleClass;
import Nishanth.Assignments.singleton.AnotherSampleClass;

public class main {
    SampleClass obj=new SampleClass();
    //obj.printMemberVariables();
    //obj.printLocalVariables();
    public static void method(){
        AnotherSampleClass obj1=new AnotherSampleClass();
        obj1.printStr();
    }
}
