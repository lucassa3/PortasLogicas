package br.edu.insper.agile.model;

import org.junit.Assert;
import org.junit.Test;

import br.edu.insper.agile.model.InputPin;
import br.edu.insper.agile.model.Switch;
import br.edu.insper.agile.model.XorGate;

public class XorGateTest {
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
		
		XorGate xor = new XorGate(pinA,pinB);
		
		Assert.assertEquals(false, xor.getOutputValue(0));
	}
	
	@Test
	public void trueFalse() {
		botaoA = new Switch(true);
		botaoB = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		XorGate xor = new XorGate(pinA,pinB);
		
		Assert.assertEquals(true, xor.getOutputValue(0));
	}
	
	@Test
	public void falseTrue() {
		botaoA = new Switch(false);
		botaoB = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		XorGate xor = new XorGate(pinA,pinB);
		
		Assert.assertEquals(true, xor.getOutputValue(0));
	}

	@Test
	public void trueTrue() {
		botaoA = new Switch(true);
		botaoB = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		XorGate xor = new XorGate(pinA,pinB);
		
		Assert.assertEquals(false, xor.getOutputValue(0));
	}
}


