
package productoestados;


public class EnInventario extends AEstado {

    @Override
    public void lanzar(Producto producto) {
        if (producto.getEstado().equals(this) && producto.getInventario() >= producto.getSeleccionado() 
                && producto.getInventario() > 1 && producto.getSeleccionado()>0) {
            System.out.println("se han agregado "+producto.getSeleccionado()+" unidades del producto al carrito");
        }else if(producto.getEstado().equals(this) && producto.getSeleccionado()==0){
            System.out.println("ahi "+producto.getInventario()+" unidades del producto en inventario");
        }else{        
             System.out.println("No se puede ejecutar la operacion");
        }
    }

    @Override
    public void setCompra(boolean compra) {
        
    }
}
