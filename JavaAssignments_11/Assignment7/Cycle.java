//Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle.
// Add a balance( ) method to Unicycle and Bicycle, but not to Tricycle.
// Create instances of all three types and upcast them to an array of Cycle.
// Try to call balance( ) on each element of the array and observe the results.
// Downcast and call balance( ) and observe what happens.

class cycle {
    public cycle(){
        System.out.println("Cycle Constructor");
    }
}
    class Unicycle extends cycle{
        public void balance(){
            System.out.println("Unicycle balance");
        }
    }
    class Bicycle extends cycle{
        public void balance(){
            System.out.println("Bicycle balance");
        }
    }
    class Tricycle extends cycle{
    }
public class Cycle {
        public static void main(String args[]) {
            Unicycle unicycle = new Unicycle();
            Bicycle bicycle = new Bicycle();
            Tricycle tricycle = new Tricycle();
            //UpCasting done implicitly, i.e.,
            //cycle[] cycles = new cycle[3];
            //cycles[0]=(cycle)unicycle;
            //cycles[1]=(cycle)bicycle;
            //cycles[2]=(cycle)tricycle;
            cycle[] cycles = new cycle[]{unicycle,bicycle,tricycle};


            //It says cannot resolve method balance() in Cycle class. So upcasting child object to parent type does not
            //invoke the method.

            //cycles[0].balance();
            //cycles[1].balance();
            //cycles[2].balance();


            //DownCasting cycles[] and accessing the methods
            ((Unicycle)cycles[0]).balance();
            ((Bicycle)cycles[1]).balance();


            // Tricycle class does not have the balance() method in it.
            // ((Tricycle)cycles[2]).balance();

        }
    }