package br.edu.insper.agile.model;

public class NotGate extends LogicGate{
	private InputPin pinA;
	
	public NotGate(InputPin pinA) {
		this.pinA = pinA;
	}
	
	
	public void setPin(InputPin pinA,InputPin pinB, InputPin pinC){
		this.pinA = pinA;
	}
	
	@Override
	public InputPin getInputPin(int index) {
		return pinA;
	}
	
	@Override
	public boolean getOutputValue(int index) {
		boolean SinalA = pinA.getSource().getOutputValue(pinA.getIndex());
		
		return !SinalA;	
	}
	
	
	

}
