import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int cnt=0;
        for (Point currPt : s.getPoints()) {
            cnt+=1;
        }
        return cnt;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length=0,sum=0;
        double perim=getPerimeter(s);
        int cnt=getNumPoints(s);
        return (double)perim/cnt;

    }

    public double getLargestSide(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double Maxdistance=0;
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            if(currDist>Maxdistance){
                Maxdistance=currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return Maxdistance;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double MaxX=0;
        for(Point currPt : s.getPoints()){
            if(currPt.getX() > MaxX)
                MaxX=currPt.getX();
        }
        return MaxX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double Maxper = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double per = getPerimeter(s);
            if (per > Maxper)
                Maxper = per;
        }
        return Maxper;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;
        DirectoryResource dr = new DirectoryResource();
        double Maxper = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double per = getPerimeter(s);
            if (per > Maxper) {
                Maxper = per;
                temp = f;
            }
        }
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int count = getNumPoints(s);
        double avg= getAverageLength(s);
        double Maxlength=getLargestSide(s);
        double MaxXcoordinate=getLargestX(s);
        System.out.println("Perimeter = " + length);
        System.out.println("Number of Points = " + count);
        System.out.println("Average length of all sides = " + avg);
        System.out.println("Largest Side is = " + Maxlength);
        System.out.println("Largest X Co-ordinate = " + MaxXcoordinate);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        System.out.println("Largest Permieter over selected multiple files = " + getLargestPerimeterMultipleFiles());
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        System.out.println("File having shape with largest perimeter = " + getFileWithLargestPerimeter());
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
