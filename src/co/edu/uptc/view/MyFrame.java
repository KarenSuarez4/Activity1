package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;


public class MyFrame extends JFrame{
	private MyPanel panel;

	public MyFrame(ActionListener listener) {
		super("MatrizEnVector");		
		this.setSize(new Dimension(400, 400));
		this.setBackground(Color.GRAY);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(listener);
		this.setVisible(true);		
	}
	
	private void initComponents(ActionListener listener) {
		panel = new MyPanel(listener);
		add(panel);
	}
	
	public void generateTable(int rows, int columns) {
		panel.generateTable(rows, columns);
		this.revalidate();
		this.repaint();
	}
	
	public void generateResult(int rows, int columns, Vector<Vector<Integer>> vec){
		panel.generateResult(rows, columns, vec);
		this.revalidate();
		this.repaint();
	}
	
	public int getRowsTable() {
		return panel.getRowsTable();
	}
	
	public int getColumnsTable() {
		return panel.getColumnsTable();
	}
	
	public Vector vectorTable(){
		return panel.vectorTable();
	}
}
