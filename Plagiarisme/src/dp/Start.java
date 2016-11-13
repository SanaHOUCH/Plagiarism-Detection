package dp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author Sanaa
 */
public class Start extends JFrame
{
    private JPanel p = new JPanel(new FlowLayout());
    private JLabel lab1;
    private JLabel b0,b1;
    private final Color coul=new Color(233,224,56);
    private final Font deco = new Font(Font.MONOSPACED, Font.ITALIC, 50);
    private final Font decos = new Font(Font.MONOSPACED, Font.BOLD, 50);
     
    public Start() throws IOException{
    	Dimension dd = new Dimension(800,500);
        setPreferredSize(dd); 
        this.setLayout(new BorderLayout());
        
        Image start = ImageIO.read(getClass().getResource("../pic/stt.png"));
        Image go = ImageIO.read(getClass().getResource("../pic/play.png"));
        Image out = ImageIO.read(getClass().getResource("../pic/out.png"));
        
b0 = new JLabel("OUT");b0.setForeground(coul);
b0.setPreferredSize(new Dimension(250,70));
b0.setBackground(Color.BLACK);b0.setIcon(new ImageIcon(out));
b0.setFont(deco);


b1 = new JLabel("START");b1.setForeground(coul);
b1.setPreferredSize(new Dimension(250,70));
b1.setBackground(Color.BLACK);b1.setIcon(new ImageIcon(go));
b1.setFont(deco);


    p.setBackground(Color.BLACK);
    p.add(b0); p.add(b1);

        lab1 = new JLabel("<html><body><center><strong>PLAGIARISM DETECTOR</strong></center></body></html>");
        lab1.setPreferredSize(new Dimension(650,500));
        lab1.setForeground(coul);   
        lab1.setIcon(new ImageIcon(start));
        lab1.setFont(deco);

        
        this.add(lab1,BorderLayout.CENTER);
        this.add(p,BorderLayout.SOUTH);
        
      
        b0.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            System.exit(0);
            }
        });
        b1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
            setVisible(false);
            try {
				Principale P = new Principale();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            }
        });
       
        //*** Configuration du frame
        this.getContentPane().setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); 
	    this.setLocation(100,100);
        this.pack();
        this.setVisible(true);
}
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
         Start s = new Start();
    }
    
}
