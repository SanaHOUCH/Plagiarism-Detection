import java.util.Scanner;

public class LCS {

	public static String lcs(String str1, String str2) {
		
//		LCS Strings
//			Ø   A	B	C	D
//		Ø	Ø	Ø	Ø	Ø	Ø	
//		B	Ø	
//		D	Ø					
//		F	Ø			

		//The first row and column in the matrix are initialized to 0 so we add 1 column and one row
	    int[][] tab = new int[str1.length()+1][str2.length()+1];
	    
	    //the StringBuffer is used to read in the matrix the subsequence
	    StringBuffer read = new StringBuffer();
	    
	  //System.out.println("......................"+ str1.length());
	  //System.out.println("......................"+ str2.length());

	    for (int i = 0; i < str1.length(); i++){
	        for (int j = 0; j < str2.length(); j++){
	            if (str1.charAt(i) == str2.charAt(j)){
	            	/**
	            	 * When they are equal we add 1 
	            	 * to the current value and we put 
	            	 * it in bottom right cell
	            	 */
	                tab[i+1][j+1] = tab[i][j] + 1;}
	            else{
	            	/**
	            	 * When they are different we choose the max
	            	 * between the value in the top cell
	            	 * and left cell
	            	 */
	            	tab[i+1][j+1] =Math.max(tab[i+1][j], tab[i][j+1]);}
	        }
	       }
	    
	    int tm = str1.length(), tn = str2.length();
	    while(tm != 0 && tn != 0){
	        if (tab[tm][tn] == tab[tm-1][tn])
	        	tm--;// go up
	        else if (tab[tm][tn] == tab[tm][tn-1])
	        	tn--;// go left
	        else {
	        	/**
	        	 * in this case we get this result 
	        	 * by adding 1 to tab[tm-1][tn-1]
	        	 */
	            // We fill the result backward (we start from the end of the strings)
	            read.append(str1.charAt(tm-1));
	            tm--;
	            tn--;
	        }
	    }
	    //reverse the result before printing it.
	    return read.reverse().toString();
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	
		System.out.println("** Enter your 1st String/txt: ");
		String str1=sc.nextLine();
		System.out.println("** Enter your 2nd String/txt: ");
		String str2=sc.nextLine();
		
		String s=lcs(str1,str2);
		System.out.println("*************************");
		System.out.println("*  The LCS IS : " +s+"\t*");
		System.out.println("*************************");
		
	}
}
