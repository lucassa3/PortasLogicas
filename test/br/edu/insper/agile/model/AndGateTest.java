package br.edu.insper.agile.model;

import org.junit.*;

import br.edu.insper.agile.model.AndGate;
import br.edu.insper.agile.model.InputPin;
import br.edu.insper.agile.model.Switch;

public class AndGateTest {
	Switch botaoA;
	Switch botaoB;
	InputPin pinA;
	InputPin pinB;

	@Test
	public void falseFalse() {
		botaoA = new Switch(false);
		botaoB = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		AndGate and = new AndGate(pinA,pinB);
		
		Assert.assertEquals(false, and.getOutputValue(0));
	}
	
	@Test
	public void trueFalse() {
		botaoA = new Switch(true);
		botaoB = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		AndGate and = new AndGate(pinA,pinB);
		
		Assert.assertEquals(false, and.getOutputValue(0));
	}
	
	@Test
	public void falseTrue() {
		botaoA = new Switch(false);
		botaoB = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		AndGate and = new AndGate(pinA,pinB);
		
		Assert.assertEquals(false, and.getOutputValue(0));
	}

	@Test
	public void trueTrue() {
		botaoA = new Switch(true);
		botaoB = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		AndGate and = new AndGate(pinA,pinB);
		
		Assert.assertEquals(true, and.getOutputValue(0));
	}
}

