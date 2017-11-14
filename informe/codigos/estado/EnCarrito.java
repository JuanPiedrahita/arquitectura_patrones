
package productoestados;


public class EnCarrito extends AEstado {
   
    private boolean compra;

    @Override
    public void lanzar(Producto producto) {
        if(producto.getEstado().equals(this) && compra==true){
            System.out.println("el producto ha sido comprado");
        }else if(producto.getEstado().equals(this) && compra==false){
            
            System.out.println("la compra ha sido cancelada, el producto ha sido retirado del carrito");
        }else{
            System.out.println("no se ha podido efectuar la operacion");
        }
    }
    
    public void lanzar(Producto producto, boolean compra){
            this.compra=compra;
            lanzar(producto);
        }

    public boolean isCompra() {
        return compra;
    }

    @Override
    public void setCompra(boolean compra) {
        this.compra = compra;
    }
    }

    
    

