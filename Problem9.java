public class Problem9
{
    public static void main(String[] args)
    {
        double c = 0;
        int sum = 1000;
        int product = 0;
        
        for(int i=1; i<sum; i++)
        {
            for(int j=1; j<i; j++)
            {
                c = Math.sqrt(Math.pow(i,2)+Math.pow(j,2));
                if(i+j+c==sum)
                {
                    product = (int) c;
                    System.out.println("The Pythagorean triple is "+i+", "+j+", "+product);
                    product *= i*j;
                    System.out.println("Their product is "+product);
                }
            }
        }
    }
}