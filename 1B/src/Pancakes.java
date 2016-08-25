import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pancakes {
	static Integer count = 0;
	public static void main(String args[]) throws FileNotFoundException
	{
		File file  = new File("C:\\Users\\Jayavignesh\\Documents\\B-large.in");
		Scanner in = new Scanner(file);
		Integer t = Integer.parseInt(in.nextLine());
		for(int i=0;i<t;i++)
		{
			String pancakes = in.nextLine();
			count = 0;
			char[] stack = pancakes.toCharArray();
			for(int j=pancakes.length()-1;j>=0;j--)
			{
				if(stack[j] == '-')
				{
					stack = flip(stack, j);
				}
			}
			System.out.println("Case #"+(i+1)+": "+count);
		}
		in.close();
	}

	public static char[] flip(char[] stack, int j) {
		Character prevOp = stack[0];
		for(int i=1;i<=j;i++)
		{
			if(stack[i] == prevOp)
			{
				continue;
			}
			else
			{
				prevOp = stack[i];
				stack = switchVal(stack, i-1);
			}
		}
			stack = switchVal(stack,j);
		return stack;
	}
	public static char[] switchVal(char[] stack, Integer j)
	{
		count++;
		for(int i=0;i<=j;i++)
		{
			if(stack[i] == '+')
			{
				stack[i] = '-';
			}
			else
			{
				stack[i] = '+';
			}
		}
		return stack;
	}
}
