package inheritence;

public class Pattern18 {
	
	
	/*
	      1 
        1 2 1 
      1 2 3 2 1 
    1 2 3 4 3 2 1 
  1 2 3 4 5 4 3 2 1 
	 */

	public static void main(String[] args) {
		int n=5;
		for(int i=1; i<=n; i++) {
			for(int j=n-i; j>=0; j--) {
				System.out.print("  ");
			}
			int x=1;
			for(int k=1; k<=i*2-1; k++) {
				if(k<i) {
					System.out.print(x +" ");
					x++;
				}
				else {
					System.out.print(x+" ");
					x--;
				}
				
			}
			System.out.println();
	    }
	}	
}
