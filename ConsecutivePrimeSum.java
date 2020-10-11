/*Consecutive Prime Sum - TCS CodeVita Problem
Some prime numbers can be expressed as a sum of other consecutive prime numbers. 
For example 5 = 2 + 3, 17 = 2 + 3 + 5 + 7, 41 = 2 + 3 + 5 + 7 + 11 + 13. 
Your task is to find out how many prime numbers which satisfy this property 
are present in the range 3 to N subject to a constraint that summation 
should always start with number 2.
Write code to find out the number of prime numbers that satisfy 
the above-mentioned property in a given range.
Input Format: First line contains a number N
Output Format: Print the total number of all such prime numbers 
which are less than or equal to N.
Constraints: 2<N<=12,000,000,000
Sample output:
Input       Output
20          2           5 = 2+3
                        17 = 2+3+5+7
15          1           5 = 2+3
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class ConsecutivePrimeSum 
{
    private static int sendMax(List<Integer> primeList)
    {
        int max = Collections.max(primeList);
        int index = primeList.indexOf(max);
        primeList.remove(index);
        return max;
    }
	private static int primesWithinLimit(List<Integer> primeList)
    {
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        newlist.addAll(primeList);
        Collections.sort(newlist);
        int counter=0;
        int maxPrime=0;
        int sum=0;
        while(primeList.size()>2)
        {
            maxPrime = sendMax(primeList);
            sum=0;
            Iterator<Integer> it = newlist.iterator();
            while(it.hasNext())
            {
                sum+=it.next();
                if(sum==maxPrime)
                {
                    counter++;
                    break;
                }
            }
        }   
        return counter;
    }
    
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
    private static List<Integer> allPrimes(int limit)
    {
        var primeList = new ArrayList<Integer>();
        for(var value = limit; value>=2; value--)
        {
            if(isPrime(value))
            primeList.add(value);
        }
        return primeList;
    }
    public static void main(String args[])
    {
        long start = System.currentTimeMillis();
        var primes = allPrimes(50000);
        System.out.println(primesWithinLimit(primes));
        long end = System.currentTimeMillis();
        System.out.print("Run Time: "+(double)(end - start)/1000);
    }
}
