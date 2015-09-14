// Problem 7:
// By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
// What is the 10,001st prime number?

public class Problem7
{
    public static void main(String[] args)
    {
        int num = 10001;
        int prime = findNthPrime(num);
        
        System.out.println("The "+num+"st prime is "+prime);
    }
    
    public static int findNthPrime(int n)
    {
        int primeCount = 0;
        int i = 0; // Initialize i here because we want to know how far i went by the end
        boolean prime = true; // Assume a number is prime then try to prove it wrong
        
        if(n<1)
        {
            System.out.println("Counting primes starts at 1. The "+n+"th prime is 2 by default.");
            return 2;
        }
        else
            primeCount++; // Count 2 initially since it makes things faster
        
        for(i=3; primeCount<n; i+=2)
        {
            prime = true;
            
            for(int j=2; j<=i/3.; j++) // Don't check past i/3 since the only possible divisor larger than i/3 is i/2, but if i/2 is a  divisor, then 2 is a divisor
            {                          // This may give false positives for i<=6, but since 3,5,7 are all primes, this is okay
                if(i%j==0) // If j divides i, stop checking it immediately; very crude primality test
                {
                    prime = false;
                    break;
                }
            }
            
            if(prime) // If we never found a j that divides i, it's prime
                primeCount++;
        }
        
        return (i-2); // Since the loop updates before it checks the condition, un-update i.
    }
}