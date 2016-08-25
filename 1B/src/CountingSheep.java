import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class CountingSheep {
	public static void main(String args[]) throws FileNotFoundException
	{
		File file  = new File("C:\\Users\\Jayavignesh\\Documents\\A-large.in");
		Scanner in = new Scanner(file);
		Long t = in.nextLong();
		for(int i=0;i<t;i++)
		{
			Integer [] array = {0,0,0,0,0,0,0,0,0,0};
			 Long n = in.nextLong();
			
			int j = 1;
			while(true)
			{
				BigInteger value = BigInteger.valueOf(n).multiply(BigInteger.valueOf(j));
				if(value.longValue() == n && j!=1)
				{
					System.out.println("Case #"+(i+1)+": INSOMNIA");
					break;
				}
				
				while(value.compareTo(BigInteger.valueOf(0))== 1)
				{
					Integer index = value.mod(BigInteger.valueOf(10)).intValue();
					array[index] = 1;
					value = value.divide(BigInteger.valueOf(10));
				}
				int check = 1;
				for(int k=0;k<array.length;k++)
				{
					if(array[k] == 0)
					{
						check = 0;
						break;
					}
				}
				if(check == 1)
				{
					System.out.println("Case #"+(i+1)+": "+n*j);
					break;
				}
				j++;
			}
		}
		in.close();
	}
}
