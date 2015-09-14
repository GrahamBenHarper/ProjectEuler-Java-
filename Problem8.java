// Problem 8:
// The four adjacent digits in the 1000-digit number that have the greatest product are 9 * 9 * 8 * 9 = 5832.
// 73167176531330624919225119674426574742355349194934
// 96983520312774506326239578318016984801869478851843
// 85861560789112949495459501737958331952853208805511
// 12540698747158523863050715693290963295227443043557
// 66896648950445244523161731856403098711121722383113
// 62229893423380308135336276614282806444486645238749
// 30358907296290491560440772390713810515859307960866
// 70172427121883998797908792274921901699720888093776
// 65727333001053367881220235421809751254540594752243
// 52584907711670556013604839586446706324415722155397
// 53697817977846174064955149290862569321978468622482
// 83972241375657056057490261407972968652414535100474
// 82166370484403199890008895243450658541227588666881
// 16427171479924442928230863465674813919123162824586
// 17866458359124566529476545682848912883142607690042
// 24219022671055626321111109370544217506941658960408
// 07198403850962455444362981230987879927244284909188
// 84580156166097919133875499200524063689912560717606
// 05886116467109405077541002256983155200055935729725
// 71636269561882670428252483600823257530420752963450
// Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of this product?

import java.util.*;
import java.io.*;

public class Problem8
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int[] num = importBigNumber();
        int n = 13;
        int[] solution = findLargestNProductInNum(n,num);
        
        System.out.println("The largest product of "+n+" consecutive digits of the given 1000 digit number is "+solution[1]+" starting at row "+(solution[0]/50+1)+", column "+solution[0]%50+".");
    }
    
    public static int[] importBigNumber() throws FileNotFoundException // Loads the large number that was given from the Problem8.txt file into the array x of length 1000.
    {
        Scanner input = new Scanner(new File("Problem8.txt"));
        int[] x = new int[1000];
        int j = 0;
        String tmp = new String(); // Use a tmp string to draw out the file line-by-line
        
        while(input.hasNext())
        {
            tmp = input.next();
            for(int i=0; i<50; i++)
            {
                x[i+50*j]=Integer.valueOf(tmp.substring(i,i+1));
            }
            j++;
        }
        
        return x;
    }
    
    public static int[] findLargestNProductInNum(int n, int[] num)
    {
        int maxStart = 0;
        int maxProduct = 0;
        int product = 0;
        int j = 0;
        boolean findZero = false;
        
        for(int i=0; i<1000-n; i++) // Check up to the last possible string of 13 digits
        {
            findZero = false;
            
            for(j=0; j<n; j++)
            {
                if(num[i+j]==0) // If there is a 0 in one of the next n positions, just skip over this calculation (assuming 0 will not be the largest product)
                {
                    findZero = true;
                    break;
                }
            }
            
            if(findZero)
                i+=j; // Skip over the next 0
            else
            {
                product = 1;
                for(j=0; j<n; j++) // If no 0 was found, check the available product of the following n digits
                {
                    product*=num[i+j];
                }
                
                if(product>maxProduct) // If the product is a new maximum, record its starting index and its value
                {
                    maxStart = i;
                    maxProduct = product;
                }
            }
        }
        return new int[] {maxStart,maxProduct};
    }
}