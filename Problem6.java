// Problem 6:
// The sum of the squares of the first ten natural numbers is,
// 1^2 + 2^2 + ... + 10^2 = 385
// The square of the sum of the first ten natural numbers is,
// (1 + 2 + ... + 10)^2 = 55^2 = 3025
// Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 ? 385 = 2640.
// Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.

public class Problem6
{
    public static void main(String[] args)
    {
        int num = 100;
        
        int sumSquares = sumSquares(num);
        int squaredSum = squaredSum(num);
        
        System.out.println("The difference between the sum of squares and the square of the sum of the first "+num+" natural numbers is "+(squaredSum-sumSquares));
    }
    
    public static int sumSquares(int n)
    {
        return ((n*(n+1)*(2*n+1))/6); // Use the formula for the sum of natural squares
    }
    
    public static int squaredSum(int n)
    {
        return (int) Math.pow((n*(n+1))/2,2); // Use the formula for the sum of natural numbers and square it
    }
}