package inheritence;

public class Pattern4 {
	
	
	/*
	 a a a a a
	 b b b b b 
	 c c c c c 
	 d d d d d
	 e e e e e
	 */

	public static void main(String[] args) {
		
		int n=5;
		int a=97;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print((char)(a+i));
			}
			System.out.println();
		}
	}

}
