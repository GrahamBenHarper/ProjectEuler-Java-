// Problem 1:
// If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
// The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.

public class Problem1
{
    public static void main(String[] args)
    {
        int a = 3;
        int b = 5;
        int range = 1000;
        
        int sum = sumMultiplesInRange(a,range) + sumMultiplesInRange(b,range) + sumMultiplesInRange(a*b,range); // Subtract out double-counted numbers
        
        System.out.println("The sum of all natural number multiples of "+a+" or "+b+" is "+sum);
    }
    
    // Take an integer x, and sum all multiples of x strictly less than max
    public static int sumMultiplesInRange(int x, int max)
    {
        int n = (max-1)/x; // Use integer division to find a limit for the sum
        return (x*n*(n+1)/2); // Use the formula for the sum of i indexed over i, and multiply by x
    }
}