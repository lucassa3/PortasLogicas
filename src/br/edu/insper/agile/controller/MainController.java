package br.edu.insper.agile.controller;

import br.edu.insper.agile.vision.*;
import br.edu.insper.agile.model.*;

public class MainController implements MainListener {
	private String gate_name;
	private Screen screen;
	private LogicGate gate;

	public MainController(Screen screen) {
		this.screen = screen;
		this.gate = new AndGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));

		updateView();
	}

	private void updateView() {
		screen.setOutputPin(gate.getOutputValue(0));
		
		if (gate_name=="Full-Adder" || gate_name=="Half-Adder") {
			screen.setOutputPinCa(gate.getOutputValue(1));
		}
	}

	@Override
	public void stateChanged(boolean a, boolean b,boolean c, String gates) {
		this.gate_name = gates;
		if (gate_name == "And") {
			this.gate = new AndGate(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1));
		}
		
		else if (gate_name == "Full-Adder") {
			
			this.gate = new FullAdderGate(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1),new InputPin(new Switch(c),2));
		}
		else if (gate_name == "Half-Adder") {
			
			this.gate = new HalfAdderGate(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1));
		}
		else if (gate_name == "Not") {
			
			this.gate = new NotGate(new InputPin(new Switch(a),0));
		}
		
		else if (gate_name == "Or") {
			
			this.gate = new OrGate(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1));
		}
		
		else if (gate_name == "Xnor") {
			
			this.gate = new XnorGate(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1));
		}
		
		else if (gate_name == "Xor") {
			
			this.gate = new XorGate(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1));
		}
		
		updateView();
	}
}