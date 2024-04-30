package inheritence;

public class Pattern3 {

	
	/*
	 A B C D E
	 A B C D E
	 A B C D E
	 A B C D E
	 A B C D E
	 */
	public static void main(String[] args) {
		
		int n=5;
	    int a=65;
	    for (int i=0; i<n; i++) {
	      for (int j=0; j<n; j++) {
	        System.out.print((char)(a+j));
	      }
	      System.out.println();
	}
}
}
