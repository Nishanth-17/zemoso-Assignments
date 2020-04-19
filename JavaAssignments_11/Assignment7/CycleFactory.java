// Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle.
// Create factories for each type of Cycle, and code that uses these factories.

interface CycleInterface{
    void getType();
}
class UniCycle implements CycleInterface{
    @Override
    public void getType(){
        System.out.println("This is a Unicycle");
    }
}
class UniCycleFactory{
    public CycleInterface getInstance(){
        return new UniCycle();
    }
}
class BiCycle implements CycleInterface{
    @Override
    public void getType(){
        System.out.println("This is a Bicycle");
    }
}
class BiCycleFactory{
    public CycleInterface getInstance(){
        return new BiCycle();
    }
}
class TriCycle implements CycleInterface{
    @Override
    public void getType(){
        System.out.println("This is a Tricycle");
    }
}
class TriCycleFactory{
    public CycleInterface getInstance(){
        return new TriCycle();
    }
}
public class CycleFactory {
    public static void main(String args[]){
        UniCycleFactory ucf=new UniCycleFactory();
        CycleInterface cycleInterface1=ucf.getInstance();
        cycleInterface1.getType();
        BiCycleFactory bcf=new BiCycleFactory();
        CycleInterface cycleInterface2=bcf.getInstance();
        cycleInterface2.getType();
        TriCycleFactory tcf=new TriCycleFactory();
        CycleInterface cycleInterface3=tcf.getInstance();
        cycleInterface3.getType();
    }
}
