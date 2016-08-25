package first;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LastWord {
	public static void main(String args[]) throws Exception
	{
		Scanner in = new Scanner(new File("C:\\Users\\Jayavignesh\\Documents\\1A\\A-large.in"));
		Integer n = Integer.parseInt(in.nextLine());
		FileWriter fw = new FileWriter(new File("C:\\Users\\Jayavignesh\\Documents\\1A\\a-large-output.txt"));
		BufferedWriter bw = new BufferedWriter(fw);
		for(int i=0;i<n;i++)
		{
			char [] array = in.nextLine().toCharArray();
			StringBuilder output = new StringBuilder();
			output.append(array[0]);
			for(int j=1;j<array.length;j++)
			{
				if((int)output.charAt(0) <= (int) array[j])
				{
					output.insert(0, array[j]);
				}
				else
				{
					output.append(array[j]);
				}
			}
			bw.write("Case #"+(i+1)+": "+output);
			bw.newLine();
			bw.flush();
			System.out.println("Case #"+(i+1)+": "+output);
		}
		bw.close();
		in.close();
	}
}
