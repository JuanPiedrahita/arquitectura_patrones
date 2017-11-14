
package productoestados;


public class Producto {
    
    private AEstado estado;
    private int inventario;
    private int seleccionado;
    private String nombre;
    
    public Producto(int inventario,String nombre){
    this.inventario=inventario;
    this.seleccionado=0;
    this.nombre=nombre;
    
    }

    public AEstado getEstado() {
        if(estado==null){
            estado=new EnInventario();
        }
        return estado;
    }

    public void setEstado(AEstado estado) {
        this.estado = estado;
    }
    
    

    public int getInventario() {
        
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public int getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(int seleccionado) {
        this.seleccionado = seleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    public void agregarCarrito(int cantidad){
        seleccionado=cantidad;
        estado.lanzar(this);
        estado = new EnCarrito();        
    }
    
    public void desagregarCarrito(){
        estado.setCompra(false);
        estado.lanzar(this);
        estado = new EnInventario();
    }
    
    public void confirmarCompra(){
        estado.setCompra(true);
        estado.lanzar(this);
        estado = new Vendido();
        estado.lanzar(this);
    }
    
    public void agotar(){
        seleccionado = inventario;
        estado = new Agotado();
    }
    
    public void inventariar(){
        seleccionado = 0;
        estado = new EnInventario();
    }
    
    public void lanzar(){
        getEstado().lanzar(this);
    }
    
    
}
