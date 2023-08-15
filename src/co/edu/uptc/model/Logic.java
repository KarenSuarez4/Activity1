package co.edu.uptc.model;

import java.util.Vector;

public class Logic {
	Vector<Integer> vector;
	
	public Logic() {
		vector = new Vector<>();
	}
	
	public Vector transversalMatriz(Vector<Vector> vectorMatriz){
		Vector vectorTrans= new Vector<>();
		
		for (int i = 0; i < vectorMatriz.get(0).size(); i++) {
			Vector columns = new Vector();
			for (int j = 0; j < vectorMatriz.size(); j++) {
				columns.addElement(vectorMatriz.get(j).get(i));
			}
			
			vectorTrans.addElement(columns);
		}
		
		return vectorTrans;
	}
	
}
