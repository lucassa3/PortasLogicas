package br.edu.insper.agile.model;

public class HalfAdderGate extends LogicGate{
	InputPin pinA;
	InputPin pinB;
	
	AndGate and1;
	XorGate xor1;
	
	public HalfAdderGate(InputPin pinA,InputPin pinB) {
		this.pinA = pinA;
		this.pinB = pinB;
		
		xor1 = new XorGate(pinA,pinB);
		and1 = new AndGate(pinA,pinB);
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
		if (index == 0) {
			return xor1.getOutputValue(index); //retorna a saida da soma
		}
		else if (index == 1) {
			return and1.getOutputValue(index); //retorna o carry
		}
		else {
			return false;
		}	
	}
}

