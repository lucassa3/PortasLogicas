package br.edu.insper.agile.vision;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HalfAdderGateDrawer extends JPanel {
	
	public void paint(Graphics g){
	    super.paintComponents(g);
	    g.setColor(Color.BLACK);
		g.drawLine(70, 120,280,120);
	    g.drawLine(70, 190,280,190);
	    g.drawLine(380, 155,470,155);
	    g.drawLine(380, 155,470,155);
	    g.drawRect(280,100,100,180);
	    g.drawLine(380, 225,470,225);
	}

}
