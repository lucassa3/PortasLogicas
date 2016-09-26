package br.edu.insper.agile.model;

import org.junit.Assert;
import org.junit.Test;

import br.edu.insper.agile.model.InputPin;
import br.edu.insper.agile.model.NotGate;
import br.edu.insper.agile.model.Switch;

public class NotGateTest {
	Switch botaoA;
	InputPin pinA;

	@Test
	public void falseTest() {
		botaoA = new Switch(false);

		pinA = new InputPin(botaoA,0);
		
		NotGate not = new NotGate(pinA);
		
		Assert.assertEquals(true, not.getOutputValue(0));
	}
	
	@Test
	public void trueTest() {
		botaoA = new Switch(true);
		
		pinA = new InputPin(botaoA,0);
		
		NotGate not = new NotGate(pinA);
		
		Assert.assertEquals(false, not.getOutputValue(0));
	}
	

}
