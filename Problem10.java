import java.util.*;

public class Problem10
{
    public static void main(String[] args)
    {
        int n = 2000000;
        int[] primes = listPrimesUpTo(n);
        
        System.out.println("The sum of all primes up to "+n+" is "+sumArray(primes));
    }
    
    public static int[] listPrimesUpTo(int n) // copied from my problem 5 solution with minor modifications
    {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean prime = true;
        
        primes.add(2); 
        
        for(int i=3; i<n; i+=2) // Iterate over odd numbers to find primes
        {
            prime = true;
            
            for(int j=2; j<=Math.sqrt(i); j++)
            {
                if(i%j==0) // i is divisible by something as large as sqrt(i) iff it is not prime
                    prime = false;
            }
            
            if(prime) // Throw the primes on the stack
                primes.add(i);
        }
        
        int[] x = new int[primes.size()];
        
        for(int i=0; i<primes.size(); i++) // Convert ArrayList to an array
            x[i] = primes.get(i);
        
        return x;
    }
    
    public static long sumArray(int[] x)
    {
        long sum=0;
        for(int i=0; i<x.length; i++)
            sum+=x[i];
        return sum;
    }
}