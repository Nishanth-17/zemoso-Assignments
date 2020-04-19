//Create a class with an inner class that has a non-default constructor (one that takes arguments).
// Create a second class with an inner class that inherits from the first inner class.
class Outer1 {
    class Inner1 {
        Inner1(String a) {
            System.out.println("Print " + a);
        }
    }
}
class Outer2 {
     class Inner2 extends Outer1.Inner1 {
        Inner2(Outer1 obj,String a) {
            obj.super(a);
        }
    }
}
public class Assignment7InnerClass {
            public static void main(String args[]){
                Outer2 outer2=new Outer2();
                Outer2.Inner2 inner2=outer2.new Inner2(new Outer1(),"Happy Birthday");
            }
}

