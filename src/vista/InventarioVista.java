package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;

public class InventarioVista {
    private Scanner scanner;
    
    public InventarioVista() {
        this.scanner = new Scanner(System.in);
    }
    
    public int mostrarMenu() {
        System.out.println("\n===== Menu de Inventario =====");
        System.out.println("1. Agregar producto");
        System.out.println("2. Buscar producto por SKU");
        System.out.println("3. Mostrar todos los productos");
        System.out.println("4. Eliminar producto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return opcion;
    }
    
    public Producto pedirDatosProducto() {
        System.out.print("Ingrese nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el SKU del producto: ");
        String sku = scanner.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();
        return new Producto(nombre, sku, cantidad, precio);
    }
    
    public String pedirSku() {
        System.out.print("Ingrese el SKU del producto: ");
        return scanner.nextLine();
    }
    
    public void mostrarProducto(Producto producto) {
        if (producto != null) {
            System.out.println("=== PRODUCTO ENCONTRADO ===");
            System.out.println(producto);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    
    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.println("=== LISTA DE PRODUCTOS ===");
        for (Producto p : productos) {
            System.out.println("----------------------------------");
            Syst

git clear

