package assignment;

public class Pattern30 {
	
	/*
1 2 3 2 1 
  1 2 1 
    1 
  1 2 1 
1 2 3 2 1 
	 */

	public static void main(String[] args) {
		
		int n=5;
		int sp=0,st=n;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=sp;j++) {
				System.out.print("  ");
			}
			int x=1;
			for(int k=1;k<=st;k++) {
				System.out.print(x+" ");
				if(k<=st/2)
					x++;
				else
					x--;
			}
			if(i<=n/2) {
				sp++;
				st=st-2;
			}
			else {
				sp--;
				st=st+2;
			}
			System.out.println();
		}

	}

}
