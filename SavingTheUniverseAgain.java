
import java.util.Scanner;

public class Solution {
	
	public static void main(String []args)
	{
		Scanner input = new Scanner (System.in);
		int querie = input.nextInt();
		String []results = new String [querie];
		for (int i = 0 ;i <querie;i++)
		{
			int protect = input.nextInt();
			int p = 0,temp1 =0,count = 0;
			StringBuilder st = new StringBuilder(input.next());

			if ((st.indexOf("C")==-1)&&(protect<st.length()))
				results[i] = "IMPOSSIBLE";

			else if (st.indexOf("S")==-1)
				results[i] = Integer.toString(0);

			else if (count(st)>protect)
				results[i]  = "IMPOSSIBLE";

			else
			{
				p= calculateDestruction(st);
				
				if (p<=protect)
					results[i] = Integer.toString(0);
				else
				{
					
					for (int k = 0;k<st.length()-1;k++)
					{
						char ch = st.charAt(k);
						if (ch=='C'&&st.charAt(k+1)=='S')
						{
							
							count++;
							
							st.replace(k, k+2, "SC");
							temp1 = calculateDestruction(st);
							if (temp1<=protect)
							{
								results[i] = Integer.toString(count);
								break;
							}
							else if (k == st.length()-2)
								k = 0;

						}

					}	
				}
			}
		}
			for (int i = 0; i< querie;i++)
				System.out.println("Case #"+(i+1)+": "+results[i]);
			input.close();
		}
	

	private static int count(StringBuilder st) {
		// TODO Auto-generated method stub
		int counter = 0;
		
		for( int i=0; i<st.length(); i++ ) {
			if( st.charAt(i) == 'S' ) {
				counter++;
			} 
		}
		return counter;
	}

	private static int calculateDestruction(StringBuilder st) {
		// TODO Auto-generated method stub
		int s = 0,c=1;
		
		for (int m = 0;m<st.length();m++)
		{
			if (st.charAt(m)=='C')
				c<<=1;
			else if (st.charAt(m)=='S')
				s+=c;
		}
		//System.out.println(st+" "+s);
		return s;
	}

}
