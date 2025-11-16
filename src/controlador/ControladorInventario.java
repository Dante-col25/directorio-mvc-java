package controlador;

import modelo.BaseDeDatos;
import modelo.Producto;
import vista.InventarioVista;
import java.util.List;

public class ControladorInventario {
    private BaseDeDatos baseDatos;
    private InventarioVista vista;
    
    public ControladorInventario(BaseDeDatos baseDatos, InventarioVista vista) {
        this.baseDatos = baseDatos;
        this.vista = vista;
    }
    
    public void iniciar() {
        boolean salir = false;
        
        vista.mostrarMensaje("✨ Bienvenido al Sistema de Gestión de Inventario - DevSolutions");
        
        while (!salir) {
            int opcion = vista.mostrarMenu();
            
            switch (opcion) {
                case 1: 
                    try {
                        Producto nuevo = vista.pedirDatosProducto(); 
                        
                        if (baseDatos.buscarProductoPorSku(nuevo.getSku()) != null) {
                            vista.mostrarMensaje("⚠️  Error: Ya existe un producto con el SKU '" + nuevo.getSku() + "'");
                        } else {
                            baseDatos.agregarProducto(nuevo); 
                            vista.mostrarMensaje("✅ Producto agregado correctamente.");
                        }
                    } catch (Exception e) {
                        vista.mostrarMensaje("❌ Error al agregar producto. Verifique los datos ingresados.");
                    }
                    break;
                    
                case 2: 
                    String skuBuscar = vista.pedirSku();
                    Producto encontrado = baseDatos.buscarProductoPorSku(skuBuscar);
                    vista.mostrarProducto(encontrado);
                    break;
                    
                case 3: 
                    List<Producto> lista = baseDatos.buscarTodos();
                    vista.mostrarProductos(lista);
                    break;
                    
                case 4:
                    String skuEliminar = vista.pedirSku();
                    boolean eliminado = baseDatos.eliminarProducto(skuEliminar);
                    if (eliminado) {
                        vista.mostrarMensaje("✅ Producto eliminado exitosamente.");
                    } else {
                        vista.mostrarMensaje("❌ No se encontró el producto con ese SKU.");
                    }
                    break;
                    
                case 5:
                    salir = true;
                    vista.mostrarMensaje("👋 Gracias por usar el sistema. ¡Hasta pronto!");
                    vista.cerrar();
                    break;
                    
                default:
                    vista.mostrarMensaje("❌ Opción inválida. Por favor, seleccione una opción del 1 al 5.");
                    break;
            }
        }
    }
}
