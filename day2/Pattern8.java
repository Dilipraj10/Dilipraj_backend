package inheritence;

public class Pattern8 {
	
	/*
	 1 2 3 4 5
	 2 3 4 5
	 3 4 5
	 4 5
	 5
	 */
	

	public static void main(String[] args) {
		
		int n=6;
		for(int i=1; i<n; i++) {
			for(int j=i; j<n; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

}
