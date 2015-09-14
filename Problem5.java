// Problem 5:
// 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
// What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

import java.util.*;

public class Problem5
{
    public static void main(String[] args)
    {
        int n = 20;
        int[] primes = listPrimesUpTo(n);
        int lcm = findLCMUpTo(n, primes);
        
        System.out.println("The least common multiple of the natural numbers 1 through "+n+" is "+lcm);
    }
    
    
    public static int[] listPrimesUpTo(int n)
    {
        ArrayList<Integer> primes = new ArrayList<>();
        boolean prime = true;
        
        if(n<2) // In case n<2 is ever considered, don't let the whole function break.
        {
            System.out.println("Warning, the lcm of naturals up to a number less than 2 is trivial. Setting n=2.");
            return new int[] {2};
        }
        else
            primes.add(2); 
        
        for(int i=3; i<n; i+=2) // Iterate over odd numbers to find primes
        {
            prime = true;
            
            for(int j=2; j<i/2.; j++)
            {
                if(i%j==0) // i is divisible by something smaller than half of itself iff it is not prime
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
    
    public static int findLCMUpTo(int n, int[] primes)
    {
        int L = primes.length; // Check how many primes we will factor our numbers over
        int[][] factored = new int[n][L]; // Make a list of each n factored over the primes
        int[] LCMArray = new int[L]; // Make a list of the lcm using the max exponent on each factor over each n
        int LCM = 1; // Initialize it to 1 since 1 may be an lcm
        int x = 0;
        
        for(int i=1; i<n; i++)
        {
            x = (i+1); // Set x to be the next natural number on the list
            
            for(int j=0; j<L; j++)
            {
                while(x%primes[j]==0)
                {
                    x/=primes[j]; // Shrink x down
                    factored[i][j]++; // Add to the factorization exponent
                }
                
                if(factored[i][j]>LCMArray[j]) // Check if we found a new max power for the LCM
                    LCMArray[j]=factored[i][j];
                if(x==1) // If x is 1, stop checking if it's factored
                    break;
            }
        }
        
        for(int i=0; i<L; i++)
        {
            LCM*=Math.pow(primes[i],LCMArray[i]); // Multiply the primes to each power to find the LCM
        }
        
        return LCM;
    }
}