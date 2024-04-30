package inheritence;

public class Pattern7 {
	
	/*
	 1
	 2 2
	 3 3 3
	 4 4 4 4
	 5 5 5 5 5
	 */

	public static void main(String[] args) {
		 
		int n=6;
		for(int i=1; i<n; i++) {
			for(int j=i-1; j>=0; j--) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
