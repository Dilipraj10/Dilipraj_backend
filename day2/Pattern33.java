package assignment;

public class Pattern33 {
	
	/*
	1 
  2 1 2 
3 2 1 2 3 
  2 1 2 
    1 
	 */

	public static void main(String[] args) {

		int n=5;
		int sp=n/2,st=1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sp;j++) 
			{	
				System.out.print("  ");
			}
			int x=st/2+1;
			for(int j=1;j<=st;j++)
			{
				System.out.print(x+" ");
				if(j<=st/2)
					x--;
				else
					x++;
			}
			if(i<=n/2)
			{
				sp--;
				st=st+2;
			}
			else {
				sp++;
				st=st-2;
			}

			System.out.println();
		}
	}

}
