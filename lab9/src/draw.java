//Intr-orn Lertsupakitsin
//id: 6288089
//Section1

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

public class draw extends JPanel{
	public void paint(Graphics m){
		m.setColor(Color.YELLOW);
		m.fillOval(33, 152, 50, 100);
		m.drawOval(33, 152, 50, 100);
		m.fillOval(388, 152, 50, 100);
		m.drawOval(388, 152, 50, 100);
		
		m.setColor(Color.BLACK);
		m.drawOval(33, 152, 50, 100);
		m.drawOval(388, 152, 50, 100);
		
		m.setColor(Color.YELLOW);
		m.fillOval(60, 60, 350, 250);
		m.drawOval(60, 60, 350, 250);
	
		m.setColor(Color.BLACK);
		m.drawOval(60, 60, 350, 250);
		m.fillOval(140, 120, 50, 50);
		m.drawOval(140, 120, 50, 50);
		m.fillOval(280, 120, 50, 50);
		m.drawOval(280, 120, 50, 50);
		
		m.setColor(Color.ORANGE);
		m.fillOval(195, 187, 80, 50);
		m.drawOval(195, 187, 80, 50);
		
		m.setColor(Color.BLACK);
		m.drawOval(195, 187, 80, 50);
		
		m.setColor(Color.ORANGE);
		m.fillOval(185, 170, 100, 50);
		m.drawOval(185, 170, 100, 50);
		
		m.setColor(Color.BLACK);
		m.drawOval(185, 170, 100, 50);
		
	}
	
	public static void main (String[] args){
		JFrame frame = new JFrame("mint");
		
		frame.getContentPane().add(new draw());
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);		

	}
}
