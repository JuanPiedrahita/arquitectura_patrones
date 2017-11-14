
package productoestados;


public class Agotado extends AEstado {

    @Override
    public void lanzar(Producto producto) {
        System.out.println("el producto se encuentra agotado");
    }   

    @Override
    public void setCompra(boolean compra) {
        
    }
}
