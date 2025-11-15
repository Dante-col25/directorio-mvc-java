
package modelo;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author herna
 */
public class BaseDeDatos {
    
    private List<Producto> productos;

    public BaseDeDatos() {
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public Producto buscarProductoPorSku(String sku) {
        for (Producto producto : productos) {
            if (producto.getSku().equalsIgnoreCase(sku)) {
                return producto;
            }
        }
        return null;
    }

    public List<Producto> buscarTodos() {
        return new ArrayList<>(productos);
    }

    public boolean eliminarProducto(String sku) {
        Producto producto = buscarProductoPorSku(sku);
        if (producto != null) {
            productos.remove(producto);
            return true;
        }
        return false;
    }
    
}
