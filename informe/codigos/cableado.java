package com.cableado;

import com.logica.Cargador;
import com.logica.IAsesoriaCliente;
import com.logica.IDB;
import com.logica.IGestionCarrito;
import com.logica.IGestionInventario;
import com.logica.IGestionUsuarios;
import com.logica.IPagos;
import com.logica.ISesionCliente;


public class JSJSport {
	public static void main(String[] args) {
		Cargador cBack = new Cargador("backOffice",ClassLoader.getSystemClassLoader());		
		Cargador cFront = new Cargador("frontOffice",ClassLoader.getSystemClassLoader());		
		try {
			IPagos pagos;
			IGestionCarrito carrito;
			IGestionInventario inventario;
			IAsesoriaCliente asesor;
			IGestionUsuarios usuarios;
			ISesionCliente sesion;
			IDB db;
			db = (IDB) cBack.cargarConElComponente(IDB.class.getSimpleName()).newInstance();
			db.connect(" ", " ", " ");
			sesion = (ISesionCliente) cFront.cargarConElComponente(ISesionCliente.class.getSimpleName()).newInstance();
			sesion.login(" ", " ");
			usuarios = (IGestionUsuarios) cBack.cargarConElComponente(IGestionUsuarios.class.getSimpleName()).newInstance();
			usuarios.listarUsuarios();
			asesor = (IAsesoriaCliente) cFront.cargarConElComponente(IAsesoriaCliente.class.getSimpleName()).newInstance();
			asesor.mandarMensaje("Se envia el mensaje", " ", " ");
			inventario= (IGestionInventario) cBack.cargarConElComponente(IGestionInventario.class.getSimpleName()).newInstance();
			inventario.agregarProducto("");
			carrito = (IGestionCarrito) cFront.cargarConElComponente(IGestionCarrito.class.getSimpleName()).newInstance();
			carrito.eliminarCarrito(" ", " ");
			pagos = (IPagos)cBack.cargarConElComponente(IPagos.class.getSimpleName()).newInstance();
			pagos.verificarPago("Interfaz de pagos");
		} catch (Exception e) {e.printStackTrace();} 
	}
}
