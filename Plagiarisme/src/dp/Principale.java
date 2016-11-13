package dp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import static dp.PrintNeatly.fich;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Principale extends JFrame{
	LCS a=new LCS();
    test t=new test();// to import the tourn methode
    
	private final Color coul=new Color(233,224,56);
	private final Font deco = new Font(Font.MONOSPACED, Font.ITALIC, 15);

	public Principale() throws IOException{
    	Dimension dd = new Dimension(900,530);
        setPreferredSize(dd); 
        this.setLayout(new BorderLayout());
        
        Image comp = ImageIO.read(getClass().getResource("../pic/comp.png"));
        Image graph = ImageIO.read(getClass().getResource("../pic/praph.png"));
        Image res = ImageIO.read(getClass().getResource("../pic/res.png"));
        
        String[] sources = { "Choose the source file","source.txt", "wiki.txt", "googleWriting.txt"};
        String[] ours = { "Choose the file to test","mine.txt", "wikiInfo.txt", "ownWriting.txt"};
        String[] algoos = { "Desired Algorithm","LCS DP", "LCS B&B", "LCS D&C"};
      /**
       * Create the combo boxes
       */
      JComboBox l1 = new JComboBox(sources);      
      JComboBox l2 = new JComboBox(ours);     
      JComboBox algos = new JComboBox(algoos);
      
      JButton b=new JButton("Execute");
      
      /**
       * Scrollpan contains the label where the 1st type of result will be displayed
       */

      JPanel pan=new JPanel(new FlowLayout());
      pan.add(l1);pan.add(l2);pan.add(algos);pan.add(b);
      pan.setBackground(Color.BLACK);
      
      JPanel scrollpan = new JPanel();
      JLabel lab = new JLabel("");
      lab.setFont(deco);
      lab.setForeground(coul);
      scrollpan.setBackground(Color.BLACK);
      scrollpan.add(lab);
      JScrollPane scroll=new JScrollPane(scrollpan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
   	       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scroll.setVisible(true);	
      
      /**
       * Configuration the the 1st Graphe
       */
      
      JPanel gp=new JPanel();
      final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   
      /**
       * Text comparision
       */
      
      JPanel cp=new JPanel();
      cp.setLayout(new GridLayout(1,2));
      
      JLabel lab1=new JLabel("Input text");
      JLabel lab2=new JLabel("Output text");
      lab1.setFont(deco);      lab1.setForeground(coul);    lab1.setBackground(Color.BLACK);  lab1.setOpaque(true);
      lab2.setFont(deco);      lab2.setForeground(coul);    lab2.setBackground(Color.BLACK);  lab2.setOpaque(true);
      
      
      JScrollPane scroll1=new JScrollPane(lab1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      	       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scroll.setVisible(true);
      JScrollPane scroll2=new JScrollPane(lab2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
      	       JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
      scroll.setVisible(true);
      
      cp.add(scroll1);cp.add(scroll2);
      
      /**
       * Create JTabbedPane for the different type of results
       */
      
      JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
      tabbedPane.addTab("Sentences", scroll);
      tabbedPane.addTab("comparison",cp);
      tabbedPane.addTab("Graphes",gp);
      
      tabbedPane.setIconAt(0,new ImageIcon(res));
      tabbedPane.setIconAt(1,new ImageIcon(comp));
      tabbedPane.setIconAt(2,new ImageIcon(graph));
      
      /**
       * The main event 'Execute button'
       */
      b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
        	  
        	  if((l1.getSelectedIndex()!=0) && (l2.getSelectedIndex()!=0)){
        		// if you selected two valid files (input and source) then
        	 
        		lab.setText("<html><body>");
        		lab1.setText("");
        		lab2.setText("");
      	
        		String input1,input2;
                String [] tabinput = null;
                String [] tabinput2 = null;
                
//                input1 = fich("C:/Users/Sanaa/git/plag/Plagiarisme/src/dp/"+l1.getSelectedItem()); 
//                input2 = fich("C:/Users/Sanaa/git/plag/Plagiarisme/src/dp/"+l2.getSelectedItem());  
                input1= fileLoading(new File("C:/Users/Sanaa/git/plag/Plagiarisme/src/dp/"+l1.getSelectedItem()));
                input2= fileLoading(new File("C:/Users/Sanaa/git/plag/Plagiarisme/src/dp/"+l2.getSelectedItem()));
                tabinput=input1.split("\\.|,");
                tabinput2=input2.split("\\.|,"); 
                		
                float h=0;
                for(int i=0;i<tabinput.length;i++){
                    for(int j=0;j<tabinput2.length;j++){
                    	System.out.println("Coucou!!1");
                    	if(test.tourn(tabinput[i], tabinput2[j])>=0.7){
                    		System.out.println("Coucou!!2");
                    		 h+=test.tourn(tabinput[i], tabinput2[j]);
                    		 System.out.println("** "+h);
                             lab.setText(lab.getText()+" <br>Input Sentence:\t"+(i+1)+" "+tabinput[i]);
                             lab.setText(lab.getText()+" <br>Source Sentence:\t"+(j+1)+" "+tabinput2[j]);
                             lab.setText(lab.getText()+" <br> Plagiat of this sentence : "+100*t.tourn(tabinput[i], tabinput2[j])+"%");
                             lab.setText(lab.getText()+" <br>===========================================================================");
                             lab.setText(lab.getText()+" <br>The general % of plagiat so far :"+100*h/tabinput.length+"%");
                             lab.setText(lab.getText()+" <br>===========================================================================");
                             
                             //** filling the graphe
                              dataset.addValue(100*t.tourn(tabinput[i], tabinput2[j]), "Sentences", new Integer(i));
                                                           
                             break;
                    	}
                }                 
                   }
                lab.setText(lab.getText()+" <br>*******************************************************");
                lab.setText(lab.getText()+" <br>* The final % of plagiat :"+100*h/tabinput.length+"%\t*");
                lab.setText(lab.getText()+" <br>*******************************************************");
                
                // to display the graphe
              final JFreeChart barChart = ChartFactory.createBarChart("plagiat of each sentence of the input file", "", "%", 
        				dataset, PlotOrientation.VERTICAL, true, true, false);
              final ChartPanel newpan = new ChartPanel(barChart);
              gp.add(newpan);
                    	  }else{
        		  JOptionPane.showMessageDialog(null, "You have to select a valid Source and Input file!! Try Again.");
        	  }
                }});
      this.add(pan,BorderLayout.NORTH);
      this.add(tabbedPane,BorderLayout.CENTER);

      //*** Configuration du frame
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); 
	    this.setLocation(100,100);
        this.pack();
        this.setVisible(true);
	}
	/**
	* Loads the specified file into a String representation
	* @author Stephane Nicoll - Infonet FUNDP
	* @version 0.1
	*/
	public static String fileLoading(File f) {
	    try {
	       BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
	       StringWriter out = new StringWriter();
	       int b;
	       while ((b=in.read()) != -1)
	           out.write(b);
	       out.flush();
	       out.close();
	       in.close();
	       return out.toString();
	    }
	    catch (IOException ie)
	    {
	         ie.printStackTrace(); 
	    }
	    return null;
	}
}
