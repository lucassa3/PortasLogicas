package br.edu.insper.agile.model;

public class Switch implements Source {
	public boolean signal;
	
	public Switch(boolean signal) {
		this.signal = signal;
	}
	
	public boolean getOutputValue(int index) {
		return signal;
	}

}
