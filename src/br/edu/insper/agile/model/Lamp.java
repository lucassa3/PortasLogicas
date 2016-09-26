package br.edu.insper.agile.model;

public class Lamp implements Drain{
	InputPin lamp;
	
	
	public Lamp (InputPin lamp) {
		this.lamp = lamp;
	}
	
	public InputPin getInputPin(int index) {
		return lamp;
	}
	
	

}
