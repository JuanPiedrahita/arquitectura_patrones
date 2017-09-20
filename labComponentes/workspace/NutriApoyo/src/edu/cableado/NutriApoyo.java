package edu.cableado;

import edu.logica.Cargador;
import edu.logica.IActualizacion;

public class NutriApoyo {

	public static void main(String[] args) {
		Cargador cBack = new Cargador("backOffice",ClassLoader.getSystemClassLoader());		
		System.out.print("hola mundo");
		IActualizacion actual;
		try {
			actual = (IActualizacion)cBack.cargarConLaclase("edu.logica.Estados").newInstance();
			actual.cabiarEstado();
			
			actual = (IActualizacion)cBack.cargarConElComponente("Estados").newInstance();
			actual.cabiarEstado();
		} catch (Exception e) {e.printStackTrace();} 
		
	}

}
