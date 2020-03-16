// Create three interfaces, each with two methods. Inherit a new interface that combines the three,
// adding a new method. Create a class by implementing the new interface and also inheriting from a concrete class.
// Now write four methods, each of which takes one of the four interfaces as an argument.
// In main( ), create an object of your class and pass it to each of the methods.


interface id1{
    public void push();
    public void pop();
}
interface  id2{
    public void enqueue();
    public void dequeue();
}
interface id3{
    public void insert();
    public void delete();
}
interface id4 extends id1,id2,id3{
    public void size();
}
class id6{
    public void display(){
        System.out.println("Data Structures");
    }
}
//We use keyword extends before implements keyword because,
// before we are implementing any interface we should acquire all the features of the Parent Class.
public class Assignment7 extends id6 implements id4 {
    public void size() {
        System.out.println(".size()");
    }

    public void push() {
        System.out.println("Push");
    }

    public void pop() {
        System.out.println("Pop");
    }

    public void enqueue() {
        System.out.println("Enqueue");
    }

    public void dequeue() {
        System.out.println("Dequeue");
    }

    public void insert() {
        System.out.println("Insert");
    }

    public void delete() {
        System.out.println("Delete");
    }

    public static void useid1(id1 obj) {
        obj.push();
        obj.pop();
        System.out.println("ID1");
    }

    public static void useid2(id2 obj) {
        obj.enqueue();
        obj.dequeue();
        System.out.println("ID2");
    }

    public static void useid3(id3 obj) {
        obj.insert();
        obj.delete();
        System.out.println("ID3");
    }

    public static void useid4(id4 obj) {
        obj.size();
        System.out.println("ID4");
    }

    public static void main(String args[]) {
        Assignment7 obj = new Assignment7();
        useid1(obj);
        useid2(obj);
        useid3(obj);
        useid4(obj);
    }
}
