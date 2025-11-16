import controlador.ControladorInventario;
import modelo.BaseDeDatos;
import vista.InventarioVista;

public class App {
    public static void main(String[] args) {
        // Crear instancia del Modelo (lógica de negocio y datos)
        BaseDeDatos baseDatos = new BaseDeDatos();
        
        // Crear instancia de la Vista (interfaz de usuario)
        InventarioVista vista = new InventarioVista();
        
        // Crear instancia del Controlador (coordinador) con inyección de dependencias
        ControladorInventario controlador = new ControladorInventario(baseDatos, vista);
        
        // Iniciar la aplicación
        controlador.iniciar();
    }
}
