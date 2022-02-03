import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
//import java.awt.*; 

public class Sketch extends JPanel{
 

  public static void main(String[] args){
		JFrame frame = new JFrame("My Sketch");
		
		frame.getContentPane().add(new Sketch());
		frame.setSize(500, 500);
		frame.setBackground(Color.YELLOW);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);				
  }
  
  public void paint(Graphics g){
	  g.setColor(Color.BLACK);
	  g.drawLine(30,60,200,200);
	  g.fillOval(30, 30, 100, 100);
	  g.drawOval(30, 30, 100, 100); 
	  }
  
  


}