package br.edu.insper.agile.vision;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.insper.agile.controller.MainListener;

public class Screen extends JPanel implements ChangeListener {
	private static final long serialVersionUID = 1L;
	
	String[] gate_names;
	private JComboBox<String> gateSelector;
	
	private JCheckBox inputPinA;
	private JCheckBox inputPinB;
	private JCheckBox inputPinC;
	private JCheckBox outputPin;
	private JCheckBox outputPinCa;
	
	private List<MainListener> listeners;
	
	public Screen () {
		
		this.gate_names = new String[]{"And","Full-Adder","Half-Adder","Not","Or","Xnor", "Xor"};
		this.gateSelector = new JComboBox<>(gate_names);
		//gateSelector.addActionListener(gateSelector);
		
		
		this.inputPinA = new JCheckBox("Pin A");
		inputPinA.addChangeListener(this); //toda vez que eu mudar o estado desse checkbox, ele vai ''ouvir''.
		
		this.inputPinB = new JCheckBox("Pin B");
		inputPinA.addChangeListener(this);

		this.inputPinC = new JCheckBox("Pin C (Adders Only)");
		inputPinA.addChangeListener(this);
		
		this.outputPin = new JCheckBox("Out");
		outputPin.setEnabled(false);
		
		this.outputPinCa = new JCheckBox("Carry (Adders only)");
		outputPinCa.setEnabled(false);
		
		this.setPreferredSize(new Dimension(300, 150));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		this.add(this.inputPinA);
		this.add(this.inputPinB);
		this.add(this.inputPinC);
		this.add(this.outputPin);
		this.add(this.outputPinCa);
		this.add(this.gateSelector);
		
		this.listeners = new ArrayList<>(); //cria lista dos ouvidores...

		
	}
	
	public void clearFields() {
		inputPinA.setSelected(false);
		inputPinB.setSelected(false);
		inputPinC.setSelected(false);
		outputPin.setSelected(false);
		outputPinCa.setSelected(false);
	}
	
	public void setOutputPin(boolean b) {
		outputPin.setSelected(b);
	}
	public void setOutputPinCa(boolean b) {
		outputPinCa.setSelected(b);
	}
	
	public void addMainListener(MainListener listener) {
		listeners.add(listener); //adiciona um ouvidor na lista
	}
	
	@Override
	public void stateChanged(ChangeEvent event) {
		String gate = (String) this.gateSelector.getSelectedItem();
		boolean stateA = (boolean) this.inputPinA.isSelected(); //vai me devolver o estado do pinA
		boolean stateB = (boolean) this.inputPinB.isSelected(); // " pinB
		boolean stateC = (boolean) this.inputPinC.isSelected(); // " pinC

		for(MainListener listener: listeners) { //para todos os ouvidores da lista...
			listener.stateChanged(stateA, stateB, stateC, gate); //...conta para cada um os estados desses elementos
		}
		
		
	}

}
