
package productoestados;

public abstract class AEstado {
    private Producto producto;
    
    public abstract void lanzar(Producto producto); 
    public abstract void setCompra(boolean compra);    
    
}
