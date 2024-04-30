package inheritence;

public class Pattern6 {
	
	/*
	 5 5 5 5 5
	 4 4 4 4
	 3 3 3
	 2 2
	 1
	 */

	public static void main(String[] args) {

		int n=5;
		for(int i=n; i>=1; i--) {
			for(int j=i-1; j>=0; j--) {
				System.out.print(i);
			}
			System.out.println();
		}
		
		
	}

}
