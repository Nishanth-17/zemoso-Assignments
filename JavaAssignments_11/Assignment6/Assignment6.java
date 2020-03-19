//Create a class with two (overloaded) constructors. Using this, call the second constructor inside the first one.

//Create a class with a constructor that takes a String argument. During construction, print the argument.
// Create an array of object references to this class, but don’t actually create objects to assign into the array.
// When you run the program, notice whether the initialization messages from the constructor calls are printed.
public class Assignment6 {
    public Assignment6() {
        System.out.println("Init call");
    }
    public Assignment6(String str){
        this();
        System.out.println(str);
    }
    public static void main(String args[]){
        Assignment6 object=new Assignment6("Nishanth");

        Assignment6[] ObjArr=new Assignment6[5];
        for(int i=0;i<5;i++) {
            ObjArr[i] = new Assignment6("Nishanth");
        }
    }
}
