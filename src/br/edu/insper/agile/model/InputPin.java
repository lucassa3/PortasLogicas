package br.edu.insper.agile.model;

public class InputPin {
	
	public InputPin(Source source, int index) {
		this.source = source;
		this.index = index;
	}
	
	public Source source;
	public int index;
	
	public Source getSource() {
		return source;
	}
		
	public int getIndex() {
		return index;
	}
	
}
