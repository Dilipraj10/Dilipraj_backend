package assignment;

public class Pattern22 {
	
	/*
	      A 
      A B A 
    A B C B A 
  A B C D C B A 
A B C D E D C B A 
	 */

	public static void main(String[] args) {
		
		int n=5;
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=n-i;j++)
			{
				System.out.print("  ");
			}
			int x=65;
			for(int k=1;k<=i*2-1;k++) {

				if(k<i) {
					System.out.print((char)x+" ");
					x++;
				}
				else{

					System.out.print((char)x+" ");
					x--;
				}
			}
			System.out.println();
		}
	}

}
