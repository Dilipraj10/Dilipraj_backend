package inheritence;

public class Pattern10 {
	
	/*
	 1 1 1 1 1
	 2 2 2 2
	 3 3 3
	 4 4 
	 5
	 */

	public static void main(String[] args) {
		
		int n=5; 
		for(int i=1; i<=n; i++) { 
			for(int j=i; j<=n; j++) {
				System.out.print(i);
			}
			System.out.println();
		}
	}

}
