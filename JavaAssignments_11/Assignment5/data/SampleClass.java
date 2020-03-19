// DefaultInitializationAssignment:
//Create a class in a package yourname.assignment.data containing an int and a char member variables that are
// not initialized, add a method to print these variables.
// Add another method in the same class with two local variables and print their values without initializing them.


package Nishanth.Assignments.data;
//Local Variables have to be initialized before accessing them.
// The compiler never assigns a default value to an uninitialized local variable.
// If you cannot initialize local variable where it is declared, make sure to assign it a value before you try to use it.
// Accessing an uninitialized local variable will result in a compile-time error.
public class SampleClass {
    public int num;
    public char ch;
    public void printMemberVariables(){
        System.out.println(num+" "+ch);
    }
    public void printLocalVariables(){
        int number;
        char cha;
        //System.out.println(number+" "+cha);
    }
}
