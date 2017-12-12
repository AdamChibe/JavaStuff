import java.util.ArrayList;
import java.lang.Math;
import java.util.Scanner;
/**
 * Write a description of class Generator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Generator
{
    //public static ArrayList<Triangle> primeTriples;
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int inputA = scan.nextInt();
        int inputB = scan.nextInt();
        generatePrimeTriples(inputA, inputB);
    }
    public Generator()
    {
        //primeTriples = new ArrayList<Triangle>();
    }
    public static ArrayList generateAllTriples(int maxA, int maxB)
    {
        ArrayList<Triangle> Triples = new ArrayList<Triangle>();
        for(int a = 3; a< maxA; a++)
        {
            for(int b = a+1; b<maxB; b++)
            {
                if(Math.sqrt(a*a+b*b)%1==0)
                {
                    Triples.add(new Triangle(a,b,(int)Math.sqrt((double)a*a+b*b)));
                }
            }
        }
        printTriangleList(Triples);
        return Triples;
    }
    public static ArrayList generatePrimeTriples(int maxA,int maxB)
    {
        ArrayList<Triangle> primeTriples = new ArrayList<Triangle>();
        for(int a = 3; a < maxA; a++)
        {
            for(int b = a+1; b<maxB; b++)
            {
                if(Math.sqrt(a*a+b*b)%1==0)
                {
                    Triangle t = new Triangle(a,b,(int)Math.sqrt((double)a*a+b*b));
                    if(t.getSimpA() == t.getA())
                    {
                        primeTriples.add(t);
                    }
                }
            }
        }
        printTriangleList(primeTriples);
        return primeTriples;
    }
    
    private static void printTriangleList(ArrayList<Triangle> a)
    {
        for(int i = 0; i < a.size(); i++)
        {
            a.get(i).print();
        }
    }
    
}
