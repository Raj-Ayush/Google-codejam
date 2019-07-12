//package coding_challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int queries = input.nextInt();
		int arr[],arr2[],orignalarray[];
		String final1 [] =new String[queries];
		for (int i =0 ;i<queries;i++)
		{
			int capacity = input.nextInt();
			byte flags = 0;

			if (capacity%2==0)
				arr = new int[(capacity/2)];
			else
				arr = new int[(capacity/2)+1];

			arr2 = new int[capacity/2];
			orignalarray = new int[capacity];
			int temp [] = new int[capacity];
			int k = 0 ,l = 0;
			for (int j = 0;j <capacity;j++)
			{
				orignalarray[j] = input.nextInt();

				if (j%2==0)
					arr[l++]=orignalarray[j];
				else
					arr2[k++] = orignalarray[j];
			}

			Arrays.sort(arr);
			Arrays.sort(arr2);

			k = 0 ; l=1;
			for (int j :arr)
			{
				temp[k] = j;
				k+=2;
			}
			for (int j :arr2)
			{
				temp[l] = j;
				l+=2;
			}
			int v ;
			Arrays.sort(orignalarray);
			
			for (v = 0;v < capacity;v++)
			{
				if (orignalarray[v]!=temp[v])
				{
					flags = 1;
					break;
				}
			}
			if (flags == 1)
				final1[i] =  Integer.toString(v);
			else
				final1[i] = "OK";
		}
		for (int i =0;i<queries;i++)
			System.out.println("Case #"+(i+1)+": "+final1[i]);
		input.close();
	}

}
