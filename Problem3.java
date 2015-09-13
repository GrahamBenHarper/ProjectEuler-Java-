// Problem 3:
// The prime factors of 13195 are 5, 7, 13 and 29.
// What is the largest prime factor of the number 600851475143 ?

public class Problem3
{
    public static void main(String[] args)
    {
        long num = 600851475143L; // Long literal
        long factor = findLargestPrimeFactor(num);

        System.out.println("The largest prime factor of "+num+" is "+factor);
    }
    
    public static long findLargestPrimeFactor(long x)
    {
        long largest = 1;
        
        if(x%2==0) // Start with 2 as a special case since testing only odd numbers helps, but testing odds excluding every third of fifth would be better eventually
        {
            largest=2;
            while(x%2==0)
                x/=2; // Shrink x down so it's easier to work with
        }
        
        for(long i=3; i<x; i+=2)
        {
            if(x%i==0)
            {
                largest = i;
                while(x%i==0)
                    x/=i;
            } // Note: It is impossible for x to drop below i unless x is a prime number since x dropping below i means that x is now a product of primes that are each less than i
        }
        return largest;
    }
}