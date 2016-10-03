package br.edu.insper.agile.vision;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class AndGateDrawer extends JPanel {

	public void paint(Graphics g){
	    super.paintComponents(g);
		g.setColor(Color.BLACK);
	    g.drawLine(70, 120,265,120);
	    g.drawLine(70, 190,265,190);
	    g.drawLine(341, 155,470,155);
	    g.drawLine(265, 90, 265, 220);
	    g.drawArc(210, 90, 130, 130, -100,200 );
	}
	

}
