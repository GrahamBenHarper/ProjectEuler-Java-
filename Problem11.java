import java.util.*;
import java.io.*;

public class Problem11
{
    public static void main(String[] args) throws FileNotFoundException
    {
        int[][] num = importBlockOfNumbers();
        
        int LargestHVProduct = findLargestHVProduct(num);
        int LargestDProduct = findLargestDProduct(num);
        
        System.out.println("The largest product in the 20x20 array is "+Math.max(LargestHVProduct,LargestDProduct));
    }
    
     public static int[][] importBlockOfNumbers() throws FileNotFoundException // Loads the number block that was given from the Problem11.txt file into the 2-dimensional array x of size 20x20
    {
        Scanner input = new Scanner(new File("Problem11.txt"));
        int[][] x = new int[20][20];
        
        while(input.hasNext())
        {
            for(int i=0; i<20; i++)
            {
                for(int j=0; j<20; j++)
                    x[i][j]=Integer.valueOf(input.next());
            }
        }
        
        return x;
    }
     
     public static int findLargestHVProduct(int[][] x)
     {
         int max = 0;
         int prod = 0;
         int[] loc = new int[2];
         
         for(int i=0; i<20; i++)
         {
             for(int j=0; j<17; j++)
             {
                 prod = x[i][j]*x[i][j+1]*x[i][j+2]*x[i][j+3];
                 if(prod>max)
                 {
                     max = prod;
                     loc[0]=i;
                     loc[1]=j;
                 }
                 prod = x[j][i]*x[j+1][i]*x[j+2][i]*x[j+3][i];
                 if(prod>max)
                 {
                     max = prod;
                     loc[0]=i;
                     loc[1]=j;
                 }
             }
         }
         System.out.println("Horz/Vert - i:"+loc[0]+", j:"+loc[1]);
         
         return max;
     }
     
     public static int findLargestDProduct(int[][] x)
     {
         int max = 0;
         int prod = 0;
         int[] loc = new int[2];
         
         for(int i=0; i<17; i++)
         {
             for(int j=0; j<17; j++)
             {
                 prod = x[i][j]*x[i+1][j+1]*x[i+2][j+2]*x[i+3][j+3];
                 if(prod>max)
                 {
                     max=prod;
                     loc[0]=i;
                     loc[1]=j;
                 }
                 prod = x[19-i][j]*x[18-i][j+1]*x[17-i][j+2]*x[16-i][j+3];
                 if(prod>max)
                 {
                     max=prod;
                     loc[0]=19-i;
                     loc[1]=j;
                 }
             }
         }
         System.out.println("Diagonal - i:"+(loc[0])+", j:"+loc[1]);
         
         return max;
     }
}