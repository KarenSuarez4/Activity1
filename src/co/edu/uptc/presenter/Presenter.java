package co.edu.uptc.presenter;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.model.Logic;
import co.edu.uptc.view.MyFrame;

public class Presenter implements ActionListener{
	private MyFrame frame;
	private Logic logic;
	
	public Presenter() {
		frame = new MyFrame(this);
		logic =  new Logic();
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String source = event.getActionCommand();
		if (source.equals("acept")) {
			frame.generateTable(frame.getRowsTable(), frame.getColumnsTable());
			
		} if (source.equals("result")) {	
			frame.generateResult(frame.getRowsTable(), frame.getColumnsTable(), logic.transversalMatriz(frame.vectorTable()));
		}
	} 
	
	public static void main(String[] args) {
		new Presenter();
	}

}
