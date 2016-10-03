package br.edu.insper.agile.vision;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class NotGateDrawer extends JPanel {
	
	public void paint(Graphics g){
	    super.paintComponents(g);
		g.setColor(Color.BLACK);
	    g.drawLine(70, 120,255,120);
	    g.drawLine(382, 155,470,155);
	    g.drawLine(255, 90, 255, 220);
	    g.drawLine(255, 90,375,155);
	    g.drawLine(255, 220,375,155);
	    g.drawOval(375, 152, 7, 7);

	}

}
