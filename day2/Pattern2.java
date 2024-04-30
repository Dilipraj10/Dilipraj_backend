package inheritence;

public class Pattern2 {
	/*
	 
	 *****
	 ****
	 ***
	 **
	 *
	 
	 */
		
	public static void printPattern(int n)
    {
        int i, j;
        for (i = n; i >= 1; i--) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

	public static void main(String[] args) {
		
		int n=5;
		printPattern(n);

	}

}
