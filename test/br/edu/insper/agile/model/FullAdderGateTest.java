package br.edu.insper.agile.model;

import org.junit.Assert;
import org.junit.Test;

import br.edu.insper.agile.model.FullAdderGate;
import br.edu.insper.agile.model.InputPin;
import br.edu.insper.agile.model.Switch;

public class FullAdderGateTest {
	Switch botaoA;
	Switch botaoB;
	Switch botaoC;
	InputPin pinA;
	InputPin pinB;
	InputPin pinC;

	@Test
	public void falseFalseCarryFalse() {
		botaoA = new Switch(false);
		botaoB = new Switch(false);
		botaoC = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(false, fa.getOutputValue(0));
		Assert.assertEquals(false, fa.getOutputValue(1));
	}
	
	@Test
	public void trueFalseCarryFalse() {
		botaoA = new Switch(true);
		botaoB = new Switch(false);
		botaoC = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(true, fa.getOutputValue(0));
		Assert.assertEquals(false, fa.getOutputValue(1));
	}
	
	@Test
	public void falseTrueCarryFalse() {
		botaoA = new Switch(false);
		botaoB = new Switch(true);
		botaoC = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(true, fa.getOutputValue(0));
		Assert.assertEquals(false, fa.getOutputValue(1));
	}

	@Test
	public void trueTrueCarryFalse() {
		botaoA = new Switch(true);
		botaoB = new Switch(true);
		botaoC = new Switch(false);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(false, fa.getOutputValue(0));
		Assert.assertEquals(true, fa.getOutputValue(1));
	}
	
	@Test
	public void falseFalseCarryTrue() {
		botaoA = new Switch(false);
		botaoB = new Switch(false);
		botaoC = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(true, fa.getOutputValue(0));
		Assert.assertEquals(false, fa.getOutputValue(1));
	}
	
	@Test
	public void trueFalseCarryTrue() {
		botaoA = new Switch(true);
		botaoB = new Switch(false);
		botaoC = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(false, fa.getOutputValue(0));
		Assert.assertEquals(true, fa.getOutputValue(1));
	}
	
	@Test
	public void falseTrueCarryTrue() {
		botaoA = new Switch(false);
		botaoB = new Switch(true);
		botaoC = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(false, fa.getOutputValue(0));
		Assert.assertEquals(true, fa.getOutputValue(1));
	}

	@Test
	public void trueTrueCarryTrue() {
		botaoA = new Switch(true);
		botaoB = new Switch(true);
		botaoC = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		pinB = new InputPin(botaoB,1);
		pinC = new InputPin(botaoC,2);
		
		FullAdderGate fa = new FullAdderGate(pinA,pinB,pinC);
		
		Assert.assertEquals(true, fa.getOutputValue(0));
		Assert.assertEquals(true, fa.getOutputValue(1));
	}

}
