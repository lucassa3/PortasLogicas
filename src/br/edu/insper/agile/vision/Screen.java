package br.edu.insper.agile.vision;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.insper.agile.controller.MainActionListener;
import br.edu.insper.agile.controller.MainChangeListener;

public class Screen extends JPanel implements ChangeListener, ActionListener {
	private static final long serialVersionUID = 1L;
	
	String[] gate_names;
	private JComboBox<String> gateSelector;
	
	private JCheckBox SwitchA;
	private JCheckBox SwitchB;
	private JCheckBox SwitchC;
	private JCheckBox Lamp;
	private JCheckBox LampCa;
	
	private List<MainChangeListener> changeListeners;
	private List<MainActionListener> actionListeners;
	
	public Screen () {
		
		this.gate_names = new String[]{"And","Full-Adder","Half-Adder","Not","Or","Xnor", "Xor"};
		this.gateSelector = new JComboBox<>(gate_names);
		gateSelector.addActionListener(this);
		
		
		this.SwitchA = new JCheckBox("Pin A");
		
		SwitchA.addChangeListener(this); //toda vez que eu mudar o estado desse checkbox, ele vai ''ouvir''.
		
		this.SwitchB = new JCheckBox("Pin B");
		
		SwitchB.addChangeListener(this);

		this.SwitchC = new JCheckBox("Pin C");
		
		SwitchC.addChangeListener(this);
		
		this.Lamp = new JCheckBox("Out");
		Lamp.setEnabled(false);
		
		this.LampCa = new JCheckBox("Carry (Adders only)");
		LampCa.setEnabled(false);
		
		this.setPreferredSize(new Dimension(300, 150));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		
		this.add(this.SwitchA);
		this.add(this.SwitchB);
		this.add(this.SwitchC);
		this.add(this.Lamp);
		this.add(this.LampCa);
		this.add(this.gateSelector);
		
		this.changeListeners = new ArrayList<>(); //cria lista dos ouvidores...
		this.actionListeners = new ArrayList<>(); //cria lista dos ouvidores...
		
	}
	
	
	public void enableSwitchA() {
		SwitchA.setEnabled(true);
	}
	public void enableSwitchB() {
		SwitchB.setEnabled(true);
	}
	public void enableSwitchC() {
		SwitchC.setEnabled(true);
	}
	public void disableSwitchA() {
		SwitchA.setEnabled(false);
	}
	public void disableSwitchB() {
		SwitchB.setEnabled(false);
	}
	public void disableSwitchC() {
		SwitchC.setEnabled(false);
	}
	
	public void clearFields() {
		SwitchA.setSelected(false);
		SwitchB.setSelected(false);
		SwitchC.setSelected(false);
		Lamp.setSelected(false);
		LampCa.setSelected(false);
	}
	
	public void setLamp(boolean b) {
		Lamp.setSelected(b);
	}
	public void setLampCa(boolean b) {
		LampCa.setSelected(b);
	}
	
	public void addMainChangeListener(MainChangeListener listener) {
		changeListeners.add(listener); //adiciona um ouvidor na lista
	}
	public void addMainActionListener(MainActionListener listener) {
		actionListeners.add(listener);
		
	}
	@Override
	public void stateChanged(ChangeEvent event) { //funcao que vai contar para todos os que tiverem esta funcao os estados dos switches
		String gate = (String) this.gateSelector.getSelectedItem();
		boolean stateA = (boolean) this.SwitchA.isSelected(); //vai me devolver o estado do pinA
		boolean stateB = (boolean) this.SwitchB.isSelected(); // " pinB
		boolean stateC = (boolean) this.SwitchC.isSelected(); // " pinC

		for(MainChangeListener listener: changeListeners) { //para todos os ouvidores da lista...
			listener.stateChanged(stateA, stateB, stateC); //... ATUALIZA FUNCAO QUE conta para cada um os estados desses elementos
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {//funcao que vai contar para todos os que tiverem esta funcao o elemento selecionado na combobox
		String gate = (String) this.gateSelector.getSelectedItem();
		
		for(MainActionListener listener: actionListeners) { //para todos os ouvidores da lista...
			listener.actionPerformed(gate); //...ATUALIZA A FUNCAO QUE conta para cada um os estados desses elementos
		}
	}

}
