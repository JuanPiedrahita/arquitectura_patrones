package edu.logica;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.jar.Attributes;
import java.util.jar.JarFile;

public class Cargador {
	public static String COMPONENTE = "COMPONENTE";
    URLClassLoader cargador;
    HashMap mapa=new HashMap<String,String>();
	public Cargador(String dir,ClassLoader cl) {
		//
		File archivos[]=new File(dir).listFiles();
		URL[] urls = new URL[archivos.length];
		for(int i=0;i<archivos.length;i++){
			try {
				urls[i] = archivos[i].toURI().toURL();
				/////////////////////////////////////
				Attributes  atr=new JarFile(archivos[i]).getManifest().getAttributes(COMPONENTE);
				if(atr!=null){
				   String nombre=atr.getValue("nombre");
				   String calse=atr.getValue("clase");
				   mapa.put(nombre, calse);
				}
				/////////////////////////////////////				
			} catch (Exception e) {				
				e.printStackTrace();
			}
		}
		cargador = new URLClassLoader(urls);		
	}
	public Class<?> cargarConLaclase(String nombreDeClase){
		try {
			return cargador.loadClass(nombreDeClase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Class<?> cargarConElComponente(String nombreDelComponente){
		try {
			return cargador.loadClass((String)mapa.get(nombreDelComponente));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
      
}
