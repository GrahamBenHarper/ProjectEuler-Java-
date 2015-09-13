// Problem 4:
// A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 * 99.
// Find the largest palindrome made from the product of two 3-digit numbers.

public class Problem4
{
    public static void main(String[] args)
    {
        int N = 3;
        int[] solution = largestNDigitProductPalindrome(N);
        
        System.out.println("The largest palindrome that is the product of 2 3-digit numbers is "+solution[1]+"*"+solution[2]+"="+solution[0]);
    }
    
    public static boolean checkPalindrome(int x)
    {
        int digits = ((int) Math.log10(x)) + 1;
        int[] forward = new int [digits];
        boolean palin = true;
        
        for(int i=0; i<digits; i++)
        {
            forward[i] = x/((int) Math.pow(10,digits-1-i)); // take the first (i+1) digits
            forward[i] = forward[i]-(forward[i]/10)*10; // take the last digit of the first (i+1) digits (which is the i+1th digit)
        }
        
        for(int i=digits-1; i>=(digits-1)/2; i--)
        {
            if(forward[i]!=forward[digits-1-i]) // If the digits going forward and backward don't match, break out immediately since it can't be a palindrome
            {
                palin = false;
                break;
            }
        }
        return palin;
    }
    
    public static int[] largestNDigitProductPalindrome(int n)
    {
        int[] solution = {0,0,0}; // set up the solution as the triple (i*j, i, j)
        
        for(int i=((int) Math.pow(10,n)); i<Math.pow(10,n+1); i++)
        {
            for(int j=((int) Math.pow(10,n)); j<=i; j++) // refrain from the redundant situation checking if i*j and j*i are palindromes
            {
                if(checkPalindrome(i*j)&&(i*j)>solution[0]) // if this is a new largest solution, put it on the list
                {
                    solution[0]=i*j;
                    solution[1]=i;
                    solution[2]=j;
                }
            }
        }
        return solution;
    }
}