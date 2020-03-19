//Create three new types of exceptions. Write a class with a method that throws all three. In main( ),
// call the method but only use a single catch clause that will catch all three types of exceptions.
// Add a finally clause and verify that your finally clause is executed, even if a NullPointerException is thrown

class IntegerFormatException extends Exception {
    public IntegerFormatException()
    {
        System.out.println("Value expected to be Integer");
    }
}

class DoubleFormatException extends Exception{
    public DoubleFormatException(){
        System.out.println("Value expected to be Double");
    }
}
class StringFormatException extends Exception{
    public StringFormatException(){
        System.out.println("Value expected to be a String");
    }
}
class MyException {
    public void throwException(String name) throws Exception{
        try {
            if(name.equals("23.1"))
                throw new IntegerFormatException();
            else if(name.equals("22"))
                throw new DoubleFormatException();
            else
                throw new StringFormatException();
        }
        catch (IntegerFormatException | DoubleFormatException | StringFormatException exception){
            System.out.println(exception);
        }
        finally {
            System.out.println("This is executed even if a NUll pointer exception is thrown");
        }
    }
}
public class Exceptions{
    public static void main(String args[]) throws Exception {
        MyException ex=new MyException();
        //Here Finally block is executed, even if a NUllPointerException is thrown
        //ex.throwException(null);
        ex.throwException("Nishanth");
    }
}