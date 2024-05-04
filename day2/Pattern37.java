package assignment;

public class Pattern37 {
	
	/*/
	 				*
			      *  * 
			    *      * 
			  *           * 
			    *       * 
			      *   * 
			        * 
	 */

	public static void main(String[] args) {
			
		int n = 6;
        int mid=(n+1)/2;


        for (int i=1; i<=mid; i++) {
            for (int j=1; j<=mid-i; j++) {
                System.out.print("\t");
            }

            for (int j=1; j<=2*i-1; j++) {
                if (j==1 || j==2*i-1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            System.out.println();
        }
        for (int i= mid-1; i>= 1; i--) {
            // Print spaces
            for (int j=1; j<=mid-i; j++) {
                System.out.print("\t");
            }

            for (int j=1; j<=2*i-1; j++) {
                if (j==1 || j==2*i-1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            System.out.println();
        }
    }
	}

