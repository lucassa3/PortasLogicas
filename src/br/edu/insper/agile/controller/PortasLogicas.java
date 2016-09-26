package br.edu.insper.agile.controller;

import javax.swing.JFrame;

import br.edu.insper.agile.vision.Screen;

public class PortasLogicas {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				Screen screen = new Screen();

				MainController controller = new MainController(screen);

				screen.addMainListener(controller);

				JFrame frame = new JFrame("SwingDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);
                frame.setContentPane(screen);
                frame.pack();
                frame.setVisible(true);
            }
		});
	}
}
