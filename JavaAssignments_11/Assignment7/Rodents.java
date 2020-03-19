//Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster,etc.
// In the base class, provide methods that are common to all Rodents, and override these in the derived classes
// to perform different behaviors depending on the specific type of Rodent.
// Create an array of Rodent, fill it with different specific types of Rodents, and call your base-class methods
// to see what happens. Make the methods of Rodent abstract
// whenever possible and all classes should have default
// constructors that print a message about that class.

import java.util.HashMap;

abstract class Rodent {
        abstract public void feedOn();
        abstract public void speciesGroup();
}
class Mouse extends Rodent{
    Mouse(){
        System.out.println("Mouse");
    }
    @Override
    public void speciesGroup(){
        System.out.println("They are mouse-like rodents");
    }
    @Override
    public void feedOn(){
        System.out.println("They feed on seeds and grains");
    }
}
class Porcupine extends Rodent{
    Porcupine(){
        System.out.println("Porcupines");
    }
    @Override
    public void speciesGroup(){
        System.out.println("They are Hystricognath rodents");
    }
    @Override
    public void feedOn(){
        System.out.println("They feed on stems, grass, nuts and seeds");
    }
}
class Chipmunks extends Rodent{
    Chipmunks(){
        System.out.println("Chipmunks");
    }
    @Override
    public void speciesGroup(){
        System.out.println("They are squirrel-like rodents");
    }
    @Override
    public void feedOn(){
        System.out.println("They feed on meat and seeds");
    }
}
class Hamster extends Rodent{
    Hamster(){
        System.out.println("Hamster");
    }
    @Override
    public void speciesGroup(){
        System.out.println("They are mouse-like rodents");
    }
    @Override
    public void feedOn(){
        System.out.println("They feed on seeds and grains");
    }
}
public class Rodents{
    public static void main(String args[]){
        Hamster hamster=new Hamster();
        Porcupine porcupine=new Porcupine();
        Chipmunks chipmunks=new Chipmunks();
        Rodent[] rodentsArr=new Rodent[]{hamster,porcupine,chipmunks};
        rodentsArr[0].speciesGroup();
        rodentsArr[0].feedOn();
        rodentsArr[1].speciesGroup();
        rodentsArr[1].feedOn();
        rodentsArr[2].speciesGroup();
        rodentsArr[2].feedOn();
    }
}
