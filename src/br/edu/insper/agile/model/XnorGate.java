package br.edu.insper.agile.model;

public class XnorGate extends LogicGate {
	InputPin pinA;
	InputPin pinB;
	
	AndGate and1;
	AndGate and2;
	AndGate and3;
	AndGate and4;
	
	public XnorGate(InputPin pinA,InputPin pinB) {
		this.pinA = pinA;
		this.pinB = pinB;
		
		and1 = new AndGate(pinA, pinB);
		and2 = new AndGate(pinA, new InputPin(new Switch(!and1.getOutputValue(0)),0)); //fazer um novo botao com a saida and1 negada eh mais facil que criar uma porta not para este fim
		and3 = new AndGate(pinB, new InputPin(new Switch(!and1.getOutputValue(0)),0));
		and4 = new AndGate(new InputPin(new Switch(!and2.getOutputValue(0)),0),new InputPin(new Switch(!and3.getOutputValue(0)),0));
	}
	
	public void setPin(InputPin pinA, InputPin pinB, InputPin pinC){
		this.pinA = pinA;
		this.pinB = pinB;
		
		//tenho que reconstruir todas as subportas
		and1 = new AndGate(pinA, pinB);
		and2 = new AndGate(pinA, new InputPin(new Switch(!and1.getOutputValue(0)),0));
		and3 = new AndGate(pinB, new InputPin(new Switch(!and1.getOutputValue(0)),0));
		and4 = new AndGate(new InputPin(new Switch(!and2.getOutputValue(0)),0),new InputPin(new Switch(!and3.getOutputValue(0)),0));
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

		
		return and4.getOutputValue(index);
		
	}

}
