package dp;

import static dp.PrintNeatly.fich;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test {
     
        public static boolean contain(String g,String[] tab){
            
           boolean a=false ;
           for(int i=0;i<tab.length;i++)
                if(tab[i].equals(g))
                    a=true;
           return a;
        }
     
        public static float tourn(String mine,String source){

            int lcsLength=0;
            float moyen;
            LCS l=new LCS();
            String []  tab1=source.split(" ");
            String []  tab2=mine.split(" ");
            int taille1= tab1.length;
            int taille2= tab2.length;
            
            /*if of the sentences  is composed only of 1 or 2 words no need to test it*/
            if(taille1>2 && taille2>2){
            	System.out.println(source+"\n ****\n "+mine);
            	System.out.println(taille1 +" "+taille2);
            	/**
                 * to compare each word the source sentence to every other word of our sentence (LCS result)
                 * it give the same results even if the order of words is not the same
                 */
            for(int i=0;i<tab1.length;i++){
                for(int j=0;j<tab1.length;j++)
                       if( mine.contains(""+l.lcs(tab1[i], mine)+"") && tab1[j].equals(l.lcs(tab1[i], mine))){
                         //System.out.println((l.lcs(tab1[i],m)));
                    	   lcsLength+=l.lcs(tab1[i], mine).length();
                       }
            }
            }
            source=source.replaceAll("\\s+","");
                  //System.out.println(lcsLength+" "+source.length());
                  if(lcsLength>source.length())
                	  lcsLength=source.length();
                   moyen=(float)lcsLength/source.length();
            return moyen;
        }
        
        
        
        
        
        /**
         * 
         * @param fsource
         * @param finput
         * @return
         * @throws IOException
         */
        public static float cryp(File fsource,File finput) throws IOException{
//        	String []  tab1=input.split(" ");
//            String []  tab2=source.split(" ");
//            
//			File fsource = new File("source.txt");
//			File finput = new File( "mine.txt");
        	
			LCS lcs = new LCS();
			int tailleTotal=0,tailleInput,tailleSource;
			String sligne,iligne,longest,shortest;
			int inpLigneI;
			BufferedReader sr = new BufferedReader( new FileReader(fsource));
			while((sligne = sr.readLine())!=null){
				tailleTotal = tailleTotal+sligne.length();
			
				BufferedReader ir = new BufferedReader( new FileReader(finput));
				inpLigneI=1;
				
				while((iligne = ir.readLine())!=null){
					tailleInput = iligne.length();
					tailleSource = sligne.length();
					
					if(tailleInput>0 && tailleSource>0) 
						// the length of both input and source lines should not be equal to 0
					{ 	
						
						String resLcs=lcs.lcs(sligne, iligne);				
		}	
			}
				}
			return 0;
			        	        }
        
//        public static void main(String[] args) throws IOException {
//        	String fsource = fich("C:/Users/Sanaa/workspace/Plagiarisme/src/dp/source.txt");
//     		String finput = fich( "C:/Users/Sanaa/workspace/Plagiarisme/src/dp/mine.txt");
//     		System.out.println("...."+fsource+".......");
//     	
//            String [] tabinput = null;
//            String [] tabinput2 = null;
//             
//            
//            tabinput=fsource.split("\\.|,");
//            tabinput2=finput.split("\\.|,"); 
//            
//            float h=0;
//            for(int i=0;i<tabinput.length;i++){
//                for(int j=0;j<tabinput2.length;j++){
//                	System.out.println(" Blabla Coucou!!");
//                	//if(tourn(tabinput[i], tabinput2[j])>=0.7){
//                		 h+=tourn(tabinput[i], tabinput2[j]);
//                		 System.out.println("Input Sentence:\t"+(i+1)+" "+tabinput[i]);
//                		 System.out.println("Source Sentence:\t"+(j+1)+" "+tabinput2[j]);
//                		 System.out.println("Plagiat of this sentence : "+100*tourn(tabinput[i], tabinput2[j])+"%");
//                		 System.out.println("The general % of plagiat so far :"+100*h/tabinput.length+"%");
//                                                  
//                         break;
//                	//}
//            }                 
//               }
//        }

}
