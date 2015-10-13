public class Problem12
{
    public static void main(String[] args)
    {
        int num = 500;
        
        
        System.out.println(findFirstTriNumWithNDivisors(num)+" is the first triangle number with over "+num+" divisors.");
    }
    
    public static int findFirstTriNumWithNDivisors(int n)
    {
        int count = 0;
        int N = 1; // This is the current N being used to calculate the triangle number N^2/2+N/2
        int currTri = 0;
        
        while(true)
        {
            currTri = N*(N+1)/2;
            count = countDivisorsOf(currTri);
            
            if(count>n)
                break;
            
            N++;
        }
        
        System.out.println("The answer is the "+N+"th triangle number.");
        return currTri;
    }
    
    public static int countDivisorsOf(int n)
    {
        int divCount = 0;
        for(int i=1; i<=Math.sqrt(n); i++)
        {
            if(n%i==0)
                divCount+=2;
            if(i==Math.sqrt(n))
                divCount--;
        }
        
        return divCount;
    }
}