package br.edu.insper.agile.model;

import org.junit.Assert;
import org.junit.Test;

import br.edu.insper.agile.model.HalfAdderGate;
import br.edu.insper.agile.model.InputPin;
import br.edu.insper.agile.model.Switch;

public class HalfAdderGateTest {
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
		
		HalfAdderGate ha = new HalfAdderGate(pinA,pinB);
		
		Assert.assertEquals(false, ha.getOutputValue(0));
		Assert.assertEquals(false, ha.getOutputValue(1));
	}
	
	@Test
	public void trueFalse() {
		botaoA = new Switch(true);
		botaoB = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		HalfAdderGate ha = new HalfAdderGate(pinA,pinB);
		
		Assert.assertEquals(true, ha.getOutputValue(0));
		Assert.assertEquals(false, ha.getOutputValue(1));
	}
	
	@Test
	public void falseTrue() {
		botaoA = new Switch(false);
		botaoB = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		HalfAdderGate ha = new HalfAdderGate(pinA,pinB);
		
		Assert.assertEquals(true, ha.getOutputValue(0));
		Assert.assertEquals(false, ha.getOutputValue(1));
	}

	@Test
	public void trueTrue() {
		botaoA = new Switch(true);
		botaoB = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		
		HalfAdderGate ha = new HalfAdderGate(pinA,pinB);
		
		Assert.assertEquals(false, ha.getOutputValue(0));
		Assert.assertEquals(true, ha.getOutputValue(1));
	}
}
