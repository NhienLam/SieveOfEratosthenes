import java.util.Set;
import java.util.TreeSet;

public class Sieve
{
	private int upperLimit;

	/**
	 * A constructor that takes as a parameter the upper limit for the primes
	 * @param upperLimit for the primes
	 */
	public Sieve(int upperLimit)
	{
		this.upperLimit = upperLimit;
	}

	/**
	 * Returns a set containing all the primes less than or equal to the upper limit. 
	 * The numbers are in increasing order.
	 */
	public Set<Integer> getPrimes()
	{
		int sqr = (int)Math.sqrt(upperLimit); 

		boolean isPrime = true;

		Set<Integer> prime = new TreeSet<>();

		for(int j = 2; j <= upperLimit; j++)
		{
			boolean notPrime = false;
			{
				for(int i = 2; i <= sqr; i++) 
				{
					if(j!=i)
					{
						if(!notPrime)
						{
							if ((j % i == 0)) 
							{
								isPrime = false;
								notPrime = true;
								//break;
							}
							else
							{
								isPrime =true;
							}
						}
					}
				}
			}

			if(isPrime == true)
			{
				prime.add(j);
			}
		}

		return prime;
	}

	/**
	 * Sets a new upper limit for this sieve
	 */
	public void setUpperLimit(int newLimit)
	{
		upperLimit = newLimit;
	}

	/**
	 * Returns the number of primes that are less than the upper limit
	 */
	public int primeCount() 
	{
		int count = getPrimes().size();
		return count;		
	}
}
