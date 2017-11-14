
package productoestados;

public class Vendido extends AEstado {

    @Override
    public void lanzar(Producto producto) {
        producto.setInventario(producto.getInventario()-producto.getSeleccionado());
        if (producto.getInventario() > 1) {
            
            System.out.println(producto.getNombre()+ " inventario disponible :"+ producto.getInventario());
            producto.inventariar();
        } else {
            
            System.out.println("producto agotado");
            producto.agotar();
        }
    }

    @Override
    public void setCompra(boolean compra) {
        
    }

}
