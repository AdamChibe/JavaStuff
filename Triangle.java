import java.util.ArrayList;

public class Triangle {
    private int a;
    private int b;
    private int c;
    private int simpA;
    private int simpB;
    private int simpC; 

    public Triangle(int x, int y, int z)
    {
        a = x;
        b = y; 
        c = z;
        simpA = x;
        simpB = y;
        simpC = z;
        factorSides();
    }

    public void factorSides()
    {
        ArrayList<Integer> aFactored = factor(a);
        ArrayList<Integer> bFactored = factor(b);
        ArrayList<Integer> cFactored = factor(c);
        boolean breaker = false;
        for(int ai = 0; ai < aFactored.size();ai++)
        {
            breaker = false;
            for(int bi = 0; bi < bFactored.size();bi++)
            {
                if(aFactored.get(ai) == bFactored.get(bi))
                {
                    for(int ci = 0; ci < cFactored.size();ci++)
                    {
                        if(aFactored.get(ai) == cFactored.get(ci) && bFactored.get(bi) == cFactored.get(ci))
                        {
                            simpA/=aFactored.get(ai);
                            simpB/=aFactored.get(ai);
                            simpC/=aFactored.get(ai);
                            aFactored.remove(ai);   ai--;
                            bFactored.remove(bi);   bi--;
                            cFactored.remove(ci);   ci--;
                            breaker = true;
                            break;//breaks ci loop
                        }
                    }
                }
                if(breaker)
                {
                    break;//breaks bi loop
                }
            }
        }
    }

    public ArrayList factor(int input)
    {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(input);
        int index = 0;
        for(int i = 0; i < Primes.primes.length;i++)
        {
            if(Primes.primes[i] == array.get(index))
            {
                break;
            }
            if((double)array.get(index)/Primes.primes[i]%1 == 0)
            {
                array.add(array.get(index)/Primes.primes[i]);
                array.set(index, Primes.primes[i]);
                index++;
                i--;
            }
        }
        return array;
    }

    public int getA()
    {
        return a;
    }
    public int getB()
    {
        return b;
    }
    public int getC()
    {
        return c;
    }
    public int getSimpA()
    {
        return simpA;
    }
    public int getsimpB()
    {
        return simpB;
    }
    public int getSimpC()
    {
        return simpC;
    }
    
    public void print()
    {
        System.out.print(a + ",\t" + b + ",\t" + c);
        if(simpA!=a)
        {
            System.out.print("\t{" + simpA + ",\t" + simpB + ",\t" + simpC + "}");
        }
        System.out.print("\tC-B=" + (c-b));
        if(Math.sqrt(c-b)%1 == 0)
        {
            System.out.print(" =  (" + Math.sqrt(c-b)+")^2");
        }
        else
        {
            System.out.print(" = 2(" + Math.sqrt((c-b)/2)+")^2");
        }
        System.out.print("\t\tC+B=" + (c+b));
        if(Math.sqrt(c+b)%1 == 0)
        {
            System.out.print(" =  (" + Math.sqrt(c+b) +")^2\n");
        }
        else
        {
            System.out.print(" = 2(" + Math.sqrt((c+b)/2)+")^2\n");
        }
    }

    public static void debugging1(int a, int b)
    {
        if(a==b)
        {
            System.out.print("true");
        }
        else
        {
            System.out.print("false");
        }
    }
    
    public static void debugging2()
    {
        System.out.println(Primes.primes.length);
    }
}