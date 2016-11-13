package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrintNeatly {

	private static final long INFINITY = -1;

	public static void printNeatly(String[] input, int width) {
		check(input, width);

		long[][] cost = new long[input.length][input.length];

		for (int j = 0; j < input.length; j++) {
			for (int i = 0; i <= j; i++) {
				cost[i][j] = cost(input, i, j, width);
			}
		}

		int[] print = new int[input.length];
		Arrays.fill(print, -1);

		long[] solution = new long[input.length];
		solution[0] = cost[0][0];
		if (cost[0][0] != INFINITY) {
			print[0] = 0;
		}

		for (int j = 1; j < input.length; j++) {
			int printIndex = 0;
			long minCost = cost[0][j];
			for (int i = 1; i <= j; i++) {
				if (solution[i - 1] != INFINITY
						&& cost[i][j] != INFINITY
						&& (minCost == INFINITY || solution[i - 1] + cost[i][j] < minCost)) {
					minCost = solution[i - 1] + cost[i][j];
					printIndex = i;
				}
			}

			solution[j] = minCost;
			print[j] = printIndex;
		}

		printSolution(input, print, print.length - 1, width);
	}

	private static void check(String[] input, int width) {
		if (width <= 0) {
			throw new IllegalArgumentException(String.format(
					"width: %d has to be positive.", width));
		}

		for (String s : input) {
			if (input == null) {
				System.out.println("Strings cannot be null in the input.");
			}

			if (s.length() > width - 1) {
				throw new IllegalArgumentException(
						String.format(
								"Length of the input word: %s is greater than max allowed width of %d characters for any word.",
								s, width - 1));
			}
		}

	}

	private static void printSolution(String[] words, int[] print, int n,
			int width) {
		if (n >= 0) {
			printSolution(words, print, print[n] - 1, width);
			int index = print[n];
			System.out.printf("%s", words[index]);
			width -= words[index].length();
			++index;
			for (; index <= n; index++) {
				System.out.printf(" %s", words[index]);
				width -= words[index].length() + 1;
			}

			while (width > 0) {
				System.out.print(" ");
				width--;
			}

			System.out.println("|");
		}
	}

	private static long cost(String[] input, int i, int j, int width) {
		int lineLength = j - i;
		for (int index = i; index <= j; index++) {
			lineLength += input[index].length();
		}

		if (lineLength > width) {
			return INFINITY;
		}

		long extraSpaces = width - lineLength;
		return extraSpaces * extraSpaces * extraSpaces;
	}
public static String fich(String fichier){
            String chaine="";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			while ((ligne=br.readLine())!=null){
				
				chaine+=ligne;
			}
                        
			br.close(); 
                         //printNeatly(chaine.split(" "), 3);
		}		
		catch (Exception e){
                         
                }
                return chaine;
}

}