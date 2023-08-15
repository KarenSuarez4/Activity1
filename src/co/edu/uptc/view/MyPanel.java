package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyPanel extends JPanel {
	private JLabel textInformation;
	private JTextField rowsField;
	private JTextField columnsField;
	private JButton aceptButton;
	private JButton resultButton;
	private JTable tableMatrix;
	private JTable transversalMatrix;
	
	public MyPanel(ActionListener listener) {
		this.setBackground(new Color(19, 183, 209));
		initComponents(listener);		
	}
	
	private void initComponents(ActionListener listener ) {
		textInformation = new JLabel("Inserte la cantidad de filas y de columnas:");
		textInformation.setForeground(Color.white);
		add(textInformation);
		
		rowsField = new JTextField();
		rowsField.setPreferredSize(new Dimension(50,25));
		add(rowsField);

		columnsField = new JTextField();
		columnsField.setPreferredSize(new Dimension(50,25));
		add(columnsField);
		
		aceptButton = new MyButton("Acept", new Color(12, 58, 158), new Color(14, 84, 235), Color.WHITE, Color.WHITE);
		aceptButton.addActionListener(listener);
		aceptButton.setActionCommand("acept");
		add(aceptButton);
		
		resultButton = new MyButton("Result", new Color(12, 58, 158), new Color(14, 84, 235), Color.WHITE, Color.WHITE);
		resultButton.addActionListener(listener);
		resultButton.setActionCommand("result");
		add(resultButton);

		tableMatrix = new JTable();
		transversalMatrix = new JTable();
	}
	
	
	public int getRowsTable() {
		return Integer.parseInt(rowsField.getText());
	}
	
	public int getColumnsTable() {
		return Integer.parseInt(columnsField.getText());
	}
	
	public void generateTable(int rows, int columns) {
		this.remove(transversalMatrix);
		DefaultTableModel modelo = new DefaultTableModel(rows, columns);
		tableMatrix.setModel(modelo);
		add(tableMatrix);
	}
	
	public void generateResult(int rows, int columns, Vector<Vector<Integer>> vec){
	    Vector<String> columnas = new Vector<String>();
	    for (int i = 0; i < rows; i++) {
	        columnas.add("Col" + (i + 1));
	    }
	    DefaultTableModel modelo2 = new DefaultTableModel(vec, columnas);
	    transversalMatrix.setModel(modelo2);
	    add(transversalMatrix);
	}	
	
	public Vector vectorTable(){
		DefaultTableModel modelo = (DefaultTableModel) tableMatrix.getModel();
		return modelo.getDataVector();
	}
	
	
	 @Override
	 protected void paintComponent(Graphics g) {
	      super.paintComponent(g);
	      GradientPaint gp = new GradientPaint(0, 150, new Color(19, 183, 209),0, 600, new Color(201, 240, 246));
	      Graphics2D g2d = (Graphics2D) g;
	      g2d.setPaint(gp);
	      g2d.fillRect(0, 0, getWidth(), getHeight());
	 }
	

}
