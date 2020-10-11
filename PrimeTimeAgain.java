public class PrimeTimeAgain
{
private static boolean isPrime(int number)
    {
        var sqrt = (int)Math.sqrt(number);
        int counter=0;
        for(var x=1; x<=sqrt ; x++)
        {
            if(number % x == 0)
            counter++;
            if(counter>1)
            return false;
        }
       return true;
    }
    private static int primeInstances(int hour,int parts)
    {
        if(hour % parts != 0)
        return 0;
        int row = hour/parts;
        int col = parts;
        int timeArray[][] = new int[row][col];
        int toAdd;
        for(var x = 0; x<row; x++)
        {
            toAdd=x+1;
            for(var y = 0; y<col; y++)
            {
                timeArray[x][y] =  toAdd;
                toAdd+=row;
            }
        }
        int instance=0,times=0;
        for(var i=1;i<row;i++)
        {
            instance=0;
            for(var j=0;j<col;j++)
            {
                if(isPrime(timeArray[i][j]))
                {
                    instance++;
                    if(instance==col)
                    {
                        times++;
                        break;
                    }
                } 
            }
        }
        return times;
    }
    public static void main(String args[])
    {
        long start = System.currentTimeMillis();
        System.out.println(primeInstances(36,3));
        long end = System.currentTimeMillis();
        System.out.print((double)(end - start)/1000);
    }
}