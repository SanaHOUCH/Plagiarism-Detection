package dp;


import java.lang.reflect.Array;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Ma {
	static LCS lcs= new LCS();

	public static String enc(Hashtable<String, String>dict,String st2){
		
		int size=st2.length();		   
	    char[] word=new char[size+1]; 
	    char bc=' ';	
	    int i=0;
	  
	    while (i<size ){                              //putting ther word into an array of char
	     word[i]=st2.charAt(i);
	     i++;
	    } 
	   
	    //System.out.println("affichage du mot dans le tableau");
	    
	    for (int j=0;j<size+1;j++){
	     	
	     //System.out.print(word[j]);
		}
	/*******************************************************************************************/
	    
	    System.out.println();
	    //int j2=0;
	   // char [] tempword=new char[size];
	    int i2=0;
	    int j2=0;
	    int i3=0;
	    while (j2<size){
	    	//System.out.println("la valeur de j2 est "+j2);
	    	if (word[j2]!=bc){
	    		//if (word[j2-1]==bc){
	    		char [] tempword=new char[size];
	    		i2=j2;
	    		i3=0;
	    		while(word[i2]!=bc){
	    			
	    		//System.out.println("la valeur de i2 est "+i2);	
	    	    tempword[i3]=word[i2];  //store the word in temps
	    	    i3++;
	    	    //System.out.println("le char est "+ word[i2]); 
	    		i2++;	
	    		}
	    		//j2=i2;
	    	    String sword=new String(tempword);
	    	    //System.out.println("la valeur est "+sword);
/********************************* using hash table*************************************/		    	    
/**/	    	    int l=i3;   //getiing the current word length
	    	    
	    	    j2=i2+1;
	    	                          //not complete sure
/**/	    		char k=tempword[0];
    			String l2=Integer.toString(l);
    			String k2=String.valueOf(k);
/**/	    		String kl=k2.concat(l2); 
    			tempword=null;
    			System.out.println();
    			if  (dict.containsKey(kl)){//we need to compare the 2 words by singke char
    			  	
    			  if (sword.equalsIgnoreCase((String) dict.get(kl))){//change the methode
    				  //the word is already there don't care
    				  System.out.println("the same word exist already");
    			  }
    			  else {
    				  //not the same word find another key
    				  //compare the 2 words and add the
    				  System.out.println("not the same word we need to compare");
    				  
    				  int y2=0;
    				  String[] alt={"2","3","4","5","6","7","8","9","11","12","13","14"};//we need a better one
    				  boolean res=false;
    				  boolean res2=false;
    				  String kalt;
    				  String ktemp;
    				  do{
    					kalt="";
    					ktemp="";
    					ktemp=kl;
    					//System.out.println("la valeur de Y2 est "+y2);  
    					kalt=alt[y2];
    					ktemp=ktemp.concat(kalt);
    					//System.out.println("la valeur de ktemp est "+ktemp);
    					y2++;  
    					res=dict.containsKey(ktemp);
    					res2=!(dict.containsKey(ktemp));
    					//System.out.println("la valeure du test est "+res);
    					//System.out.println("la valeure du test est "+res2);}
    				  } while(res);
    				  kl=ktemp;
    				  dict.put(kl,sword);
    			  }
    			  
    			}	   
    			else dict.put(kl,sword); //no key safe put it in
  		    			
	    	}
	    	else j2++;//white space    
	}
	    //printing the hash table
	    System.out.println();
	    //System.out.println(" String form of hash table is: "+dict.toString());
	    System.out.println("la table est "+dict);
	    Set<String> keys = dict.keySet();
	    String keysconc = "";
	    for(String key: keys){
            //System.out.println(key);
	        keysconc=keysconc.concat(key);
	    }
	    System.out.println("");
	    System.out.println("le string est "+keysconc);
	    return(keysconc);
	    }	    

	
		
	public static void main(String[] args) {
		/*public static void main(String[] args) {*/
		Scanner sc=new Scanner(System.in);
	
		System.out.println("** Enter your 1st String/txt: ");
		String str1=sc.nextLine();
		System.out.println("** Enter your 2nd String/txt: ");
		String str2=sc.nextLine();
		
/*		String str1="my name is oussama ";
		String str2="my name is austin ";*/
		Hashtable<String, String> dict = new Hashtable();
		Hashtable<String, String> dict2 = new Hashtable();
		
		String keys1=enc(dict,str1);
		//enc(dict,str1)=
		String keys2=enc(dict2,str2);  //we need only to get back the sequence of keys so type should be string
		System.out.println("affichage de set1 "+keys1);
		System.out.println("affichage de set2 "+keys2);
     	String s= lcs.lcs(keys1,keys2);  //needs to be modified
		System.out.println("*************************");
		System.out.println("*  The LCS IS : " +s+"\t*");
		System.out.println("*************************");
			
}
	
}
