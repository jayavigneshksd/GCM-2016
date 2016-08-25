package second;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Rank {
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner in = new Scanner(new File("C:\\Users\\Jayavignesh\\Documents\\1A\\B-small-attempt0.in"));
		Integer t = in.nextInt();
		Integer n = in.nextInt();
		Integer [][] array = new Integer[n*2-1][n];
		Integer [][] subArray1 = new Integer[n][n];
		for(int a=0;a<t;a++)
		{
			for(int i=0;i<n*2-1;i++)
			{
				for(int j=0;j<n;j++)
				{
					array[i][j] = in.nextInt();
				}
			}
			for(int i=n*2-2,k=0;i>n-2;i--,k++)
			{
				
				for(int j=0;j<n;j++)
				{
					subArray1[k][j] = array[i][j];
				}
			}
			System.out.print("Case #"+(a+1)+": ");
			for(int i=0;i<n;i++)
			{
				System.out.print(subArray1[i][n-1]+" ");
			}
			System.out.println();
		}
		in.close();
	}
}
