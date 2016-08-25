import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class CoinJam {
	public static void main(String args[]) throws FileNotFoundException
	{
		File file  = new File("C:\\Users\\Jayavignesh\\Documents\\C-large.in");
		Scanner in = new Scanner(file);
		Integer t = in.nextInt();
		Integer n = in.nextInt();
		Integer j = in.nextInt();
		Integer count = 0;
		System.out.println("Case #1:");
		for(int i=0;;i++)
		{
			if(count == j)
			{
				break;
			}
			if(Integer.toBinaryString(i).length() > n-2)
			{
				break;
			}
	        String number = "1"+String.format("%0"+(n-2)+"d", Integer.parseInt(Integer.toBinaryString(i)), 10)+"1";
	        Boolean flag = true;
	        Long [] array = new Long[9];
	        Arrays.fill(array, 0l);
			for(int k=2,l=0;k<=10;k++,l++)
			{
				BigInteger value = new BigInteger(number, k);
				if(isPrime(value))
				{
					System.out.println("Dropped");
					flag = false;
					break;
				}
				else
				{
					array[l] = findFirstFactor(value,array);
				}
			}
			if(flag == true)
			{
				count++;
				System.out.print(number+" ");
				for (Long s : array) {
				    System.out.print(s+" ");
				}
				System.out.println();    
			}
		}
		in.close();
	}
	public static Long findFirstFactor(BigInteger value, Long [] array) {
		Long factor = null;
		for(Long i=2l;value.compareTo(BigInteger.valueOf(i))>0;i++)
		{
			if(value.mod(BigInteger.valueOf(i)).compareTo(BigInteger.valueOf(0))==0)
			{
				factor = i;
				break;
			}
		}
		return factor;
	}
	public static Boolean isPrime(BigInteger value) {
		BigInteger zero = BigInteger.valueOf(0);
	    if(value.compareTo(BigInteger.valueOf(2)) < 0) return false;
	    if(value.compareTo(BigInteger.valueOf(2)) == 0 || value.compareTo(BigInteger.valueOf(3)) == 0) return true;
	    if(value.mod(BigInteger.valueOf(2)).compareTo(zero) == 0 || value.mod(BigInteger.valueOf(3)).compareTo(zero) == 0) return false;
	    long sqrt = (long)Math.sqrt(value.doubleValue()) + 1;
	    for(long i = 6L; i <= sqrt; i += 6) {
	        if(value.mod(BigInteger.valueOf(i-1)).compareTo(zero) == 0 || value.mod(BigInteger.valueOf(i+1)).compareTo(zero) == 0) return false;
	    }
	    return true;
	}
}
