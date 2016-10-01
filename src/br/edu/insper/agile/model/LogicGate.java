package br.edu.insper.agile.model;

public abstract class LogicGate implements Source, Drain {
	
	public abstract InputPin getInputPin(int index);

	public abstract boolean getOutputValue(int index);
	
	public abstract void setPin (InputPin pinA,InputPin pinB,InputPin pinC);

}
