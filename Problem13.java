import java.util.*;
import java.io.*;

public class Problem13
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Long[] num = importNumbersToAdd();
        
        System.out.println(addBigNumbers(num));
    }
    
    public static Long[] importNumbersToAdd() throws FileNotFoundException // Loads the 100 50-digit numbers that were given
    {
        Scanner input = new Scanner(new File("Problem13.txt"));
        Long[] x = new Long[100];
        int i=0;
        
        while(input.hasNext())
        {
            x[i]=Long.valueOf(input.next());
            i++;
        }
        
        return x;
    }
    
    public static Long addBigNumbers(Long[] x)
    {
        Long sum = 0L;
        
        for(int i=0; i<x.length; i++)
        {    
            sum+=x[i];
        }
        return sum;
    }
}