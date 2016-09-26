package br.edu.insper.agile.model;

public class FullAdderGate extends LogicGate {
	InputPin pinA;
	InputPin pinB;
	InputPin pinCarry;
	
	AndGate and1;
	AndGate and2;
	AndGate and3;
	XorGate xor1;
	XorGate xor2;
	OrGate or1;
	OrGate or2;
	
	
	public FullAdderGate(InputPin pinA,InputPin pinB,InputPin pinCarry) {
		this.pinA = pinA;
		this.pinB = pinB;
		
		xor1 = new XorGate(pinA,pinB);
		xor2 = new XorGate(new InputPin(xor1,0),pinCarry);
		and1 = new AndGate(pinA, pinB);
		and2 = new AndGate(pinB,pinCarry);
		and3 = new AndGate(pinA,pinCarry);
		or1 = new OrGate(new InputPin(and1,0),new InputPin(and2,0));
		or2 = new OrGate(new InputPin(or1,0),new InputPin(and3,0));
	}

	public void setPin(InputPin pinA, InputPin pinB,InputPin pinC){
		this.pinA = pinA;
		this.pinB = pinB;
		this.pinCarry = pinC;
	}

	
	
	@Override
	public InputPin getInputPin(int index) {
		if (index == 0) {
			return pinA;
		}
		else if (index == 1) {
			return pinB;
		}
		else {
			return pinCarry;
		}
	}
	
	@Override
	public boolean getOutputValue(int index) {
		if (index == 0) {
			return xor2.getOutputValue(index); //retorna a saida da soma
		}
		else if (index == 1) {
			return or2.getOutputValue(index); //retorna o carry
		}
		else {
			return false;
		}
	}
}

