package br.edu.insper.agile.model;

public class XorGate extends LogicGate{
	InputPin pinA;
	InputPin pinB;
	
	AndGate and1;
	AndGate and2;
	AndGate and3;
	AndGate and4;
	
	public XorGate(InputPin pinA,InputPin pinB) {
		this.pinA = pinA;
		this.pinB = pinB;
		
		and1 = new AndGate(pinA, pinB);
		and2 = new AndGate(pinA, new InputPin(new Switch(!and1.getOutputValue(0)),0)); //crio um switch pois fica mais facil inverter a saida da and1 deste modo!
		and3 = new AndGate(pinB, new InputPin(new Switch(!and1.getOutputValue(0)),0)); 
		and4 = new AndGate(new InputPin(new Switch(!and2.getOutputValue(0)),0),new InputPin(new Switch(!and3.getOutputValue(0)),0));
	}
	
	public void setPin(InputPin pinA, InputPin pinB){
		this.pinA = pinA;
		this.pinB = pinB;
	}

	
	
	@Override
	public InputPin getInputPin(int index) {
		if (index == 0) {
			return pinA;
		}
		else {
			return pinB;
		}
		
	}
	
	@Override
	public boolean getOutputValue(int index) {
		//podemos construir usando portas and ja existentes
		
		return !and4.getOutputValue(index);
		
	}
}
