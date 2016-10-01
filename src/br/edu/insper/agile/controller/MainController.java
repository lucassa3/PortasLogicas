package br.edu.insper.agile.controller;

import br.edu.insper.agile.vision.*;
import br.edu.insper.agile.model.*;

public class MainController implements MainChangeListener, MainActionListener{
	private String gate_name;
	private Screen screen;
	private LogicGate gate;

	public MainController(Screen screen) {
		this.screen = screen;
		this.gate = new AndGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));

		updateView();
	}

	private void updateView() {
		screen.setLamp(gate.getOutputValue(0));
		
		if (gate_name=="Full-Adder" || gate_name=="Half-Adder") {
			screen.setLampCa(gate.getOutputValue(1));
		}
	}

	@Override
	public void stateChanged(boolean a, boolean b,boolean c) {
		gate.setPin(new InputPin(new Switch(a),0),new InputPin(new Switch(b),1),new InputPin(new Switch(c),2));
		updateView();
	}

	@Override
	public void actionPerformed(String gates) {
		this.gate_name = gates;
		if (gate_name == "And") {
			screen.enableSwitchA();
			screen.enableSwitchB();
			screen.disableSwitchC();
			screen.clearFields();
			this.gate = new AndGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));
			updateView();
		}
		
		else if (gate_name == "Full-Adder") {
			screen.enableSwitchA();
			screen.enableSwitchB();
			screen.enableSwitchC();
			screen.clearFields();
			this.gate = new FullAdderGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1),new InputPin(new Switch(false),2));
			updateView();
		}
		else if (gate_name == "Half-Adder") {
			screen.enableSwitchA();
			screen.enableSwitchB();
			screen.disableSwitchC();
			screen.clearFields();
			this.gate = new HalfAdderGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));
			updateView();
		}
		else if (gate_name == "Not") {
			screen.enableSwitchA();
			screen.disableSwitchB();
			screen.disableSwitchC();
			screen.clearFields();
			this.gate = new NotGate(new InputPin(new Switch(false),0));
			updateView();
		}
		
		else if (gate_name == "Or") {
			screen.enableSwitchA();
			screen.enableSwitchB();
			screen.disableSwitchC();
			screen.clearFields();
			this.gate = new OrGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));
			updateView();
		}
		
		else if (gate_name == "Xnor") {
			screen.enableSwitchA();
			screen.enableSwitchB();
			screen.disableSwitchC();
			screen.clearFields();
			this.gate = new XnorGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));
			updateView();
		}
		
		else if (gate_name == "Xor") {
			screen.enableSwitchA();
			screen.enableSwitchB();
			screen.disableSwitchC();
			screen.clearFields();
			this.gate = new XorGate(new InputPin(new Switch(false),0),new InputPin(new Switch(false),1));
			updateView();
		}
		
	}
}