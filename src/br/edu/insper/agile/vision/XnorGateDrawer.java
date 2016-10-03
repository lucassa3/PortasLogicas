package br.edu.insper.agile.vision;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class XnorGateDrawer extends JPanel{
	
	public void paint(Graphics g){
	    super.paintComponents(g);
	    g.setColor(Color.BLACK);
	    g.drawLine(70, 120,280,120);
	    g.drawLine(70, 190,280,190);
	    g.drawLine(382, 155,470,155);
	    g.drawArc(175, 90, 200, 130, -100,200);
	    g.drawArc(235, 90, 50, 130, -100,200);
	    g.drawArc(220, 90, 50, 130, -100,200);
	    g.drawOval(375, 152, 7, 7);
	}
}
