package Sistema;

import Cliente.Usuario;
import Administracion.AdministracionCine;
import Administracion.Boleto;
import Administracion.Peliculas;
import Administracion.Sucursal;
import Ventas.CarritoDeCompra;
import Ventas.Dulceria;
import Ventas.Producto;
import Ventas.TicketVirtual;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class CineFacil {

    // Instancia de AdministracionCine
    static AdministracionCine adminCine = new AdministracionCine();
    private static final Dulceria dulceria = new Dulceria();
    private static final CarritoDeCompra carritoDeCompra = new CarritoDeCompra();
    Scanner scanner = new Scanner(System.in);
    // Definir las sucursales de forma más clara, accediendo directamente a la lista
    static Sucursal sucursalCU = adminCine.sucursales.get(0);
    static Sucursal sucursalUniversidad = adminCine.sucursales.get(1);
    static Sucursal sucursalDelta = adminCine.sucursales.get(2);
    static Sucursal sucursalXochimilco = adminCine.sucursales.get(3);
    private static Usuario usuarioActual;

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Menú para seleccionar la sucursal
        System.out.println("==================================");
        System.out.println("        SELECCIONA UNA SUCURSAL");
        System.out.println("==================================");
        System.out.println("1. Sucursal CU");
        System.out.println("2. Sucursal Universidad");
        System.out.println("3. Sucursal Delta");
        System.out.println("4. Sucursal Xochimilco");
        System.out.println("==================================");
        System.out.print("Seleccione una opción (1-4): ");
        int sucursal = scanner.nextInt();

        // Guardar la sucursal seleccionada
        Sucursal sucursalActual = null;

        // Selección de sucursal
        switch (sucursal) {
            case 1:
                sucursalActual = sucursalCU;  // Sucursal CU
                break;
            case 2:
                sucursalActual = sucursalUniversidad;  // Sucursal Universidad
                break;
            case 3:
                sucursalActual = sucursalDelta;  // Sucursal Delta
                break;
            case 4:
                sucursalActual = sucursalXochimilco;  // Sucursal Xochimilco
                break;
            default:
                System.out.println("Opción no válida. Selecciona entre 1 y 4.");
                return; // Salir si la opción es inválida
        }

        // Menú principal
        while (!salir) {
            System.out.println("==================================");
            System.out.println("         MENÚ PRINCIPAL");
            System.out.println("==================================");
            System.out.println("[CARTELERA Y PELÍCULAS]");
            System.out.println("1. Ver Cartelera");
            System.out.println("2. Buscar Película");
            System.out.println();
            System.out.println("[SUCURSALES]");
            System.out.println("3. Cambiar Sucursal");
            System.out.println();
            System.out.println("[SESIÓN]");
            System.out.println("4. Iniciar Sesión");
            System.out.println();
            System.out.println("[COMPRAS]");
            System.out.println("5. Buscar Producto");
            System.out.println("6. Ver Carrito");
            System.out.println("   a. Ver carrito (editar)");
            System.out.println("   b. Comprar");
            System.out.println();
            System.out.println("[⚙️ CONFIGURACIÓN]");
            System.out.println("7. Actualizar Datos Personales");
            System.out.println("8. Registrarse");
            System.out.println("9. Ver Mis compras (solo si inició sesión)");
            System.out.println("10.Ver Mis puntos (solo si inició sesión)");
            System.out.println("11.Salir");
            System.out.println("==================================");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (opcion) {
                case 1:
                    // Ver Cartelera
                    AdministracionCine.mostrarPeliculasDeSucursal(sucursalActual);
                    // Preguntar si quiere comprar un boleto
                    System.out.println("\n¿Quieres comprar un boleto? (s/n): ");
                    String respuesta = scanner.nextLine().toLowerCase();

                    if (respuesta.equals("s")) {
                        // Aquí llamas a la lógica para comprar boletos
                        ComprarBoletos(scanner, sucursalActual);
                    } else {
                        System.out.println("Volviendo al menú principal...");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la película que desea buscar: ");
                    String nombrePelicula = scanner.nextLine(); // Leer el nombre de la película
                    adminCine.buscarPeliculaPorNombre(nombrePelicula); // Buscar la película
                    break;
                case 3:
                    System.out.println("==================================");
                    System.out.println("        SELECCIONA UNA SUCURSAL");
                    System.out.println("==================================");
                    System.out.println("1. Sucursal CU");
                    System.out.println("2. Sucursal Universidad");
                    System.out.println("3. Sucursal Delta");
                    System.out.println("4. Sucursal Xochimilco");
                    System.out.println("==================================");
                    System.out.print("Seleccione una opción (1-4): ");
                    int sucursalCambiada = scanner.nextInt();

                    // Selección de sucursal
                    switch (sucursalCambiada) {
                        case 1:
                            sucursalActual = sucursalCU;  // Sucursal CU
                            break;
                        case 2:
                            sucursalActual = sucursalUniversidad;  // Sucursal Universidad
                            break;
                        case 3:
                            sucursalActual = sucursalDelta;  // Sucursal Delta
                            break;
                        case 4:
                            sucursalActual = sucursalXochimilco;  // Sucursal Xochimilco
                            break;
                        default:
                            System.out.println("Opción no válida. Selecciona entre 1 y 4.");
                            return; // Salir si la opción es inválida
                    }

                case 4:
                    iniciarSesion(scanner);
                    break;
                case 5:
                    verDulceria(sucursalActual, scanner);
                    break;
                case 6:
                    System.out.println("   a. Ver carrito (editar)");
                    System.out.println("   b. Comprar");
                    System.out.println("   c. Salir");

                    System.out.print("Seleccione una opción: ");
                    String x = scanner.nextLine().toLowerCase();

                    switch (x) {
                        case "a":
                            verCarritoDeCompras(sucursalActual, scanner);
                            break;

                        case "b":
                            System.out.println("Procesando la compra...");
                            verCarritoDeCompras(sucursalActual, scanner);
                            break;

                        case "c":
                            System.out.println("Saliendo al menu");
                            salir = true;
                            break;

                        default:
                            System.out.println("Opción inválida. Intente de nuevo.");
                            break;
                    }
                    scanner.close();

                    break;
                case 7:
                   
                    break;

                case 8:
                    break;

                case 9:
                    break;

                case 10:

                    break;
                case 11:

                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void iniciarSesion(Scanner scanner) {
        System.out.print("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = adminCine.obtenerUsuario(correo, contrasena);
        if (usuario != null) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso. Bienvenido, " + usuarioActual.getNombre() + "!");
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos. Intente de nuevo.");
        }
    }

    private static void ComprarBoletos(Scanner scanner, Sucursal sucursalActual) {
        if (usuarioActual == null) {
            System.out.println("Debe iniciar sesión para comprar boletos.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("         Comprar Boleto en " + sucursalActual.getNombre());
        System.out.println("========================================");

        // Listar las películas con índices
        List<Peliculas> peliculas = sucursalActual.getPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas disponibles en esta sucursal.");
            return;
        }

        for (int i = 0; i < peliculas.size(); i++) {
            Peliculas pelicula = peliculas.get(i);
            System.out.printf("%d. %s (Horario: %s, Sala: %d, Capacidad restante: %d)\n",
                    i + 1,
                    pelicula.getNombreDePelicula(),
                    (pelicula.getHorarioInicio() != null ? pelicula.getHorarioInicio().toString() : "No definido"),
                    pelicula.getSala(),
                    sucursalActual.getSalas().getOrDefault(pelicula.getSala(), 0)); // Mostrar capacidad
        }
        System.out.println("========================================");

        // Seleccionar una película
        System.out.print("Seleccione el número de la película que desea: ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        // Validar la selección
        if (seleccion < 1 || seleccion > peliculas.size()) {
            System.out.println("Selección inválida. Inténtelo de nuevo.");
            return;
        }

        Peliculas peliculaSeleccionada = peliculas.get(seleccion - 1);

        // Mostrar detalles de la película seleccionada
        System.out.println("\n========================================");
        System.out.println("Detalles de la película seleccionada:");
        System.out.println("Nombre: " + peliculaSeleccionada.getNombreDePelicula());
        System.out.println("Horario: " + (peliculaSeleccionada.getHorarioInicio() != null
                ? peliculaSeleccionada.getHorarioInicio().toString()
                : "No definido"));
        System.out.println("Sala: " + peliculaSeleccionada.getSala());
        System.out.println("Resumen: " + peliculaSeleccionada.getResumen());
        System.out.println("Sinopsis: " + peliculaSeleccionada.getSinopsis());
        System.out.println("Actores: " + peliculaSeleccionada.getActores());
        System.out.println("Clasificación: " + peliculaSeleccionada.getClasificacion());
        System.out.println("Capacidad restante: " + sucursalActual.getSalas().getOrDefault(peliculaSeleccionada.getSala(), 0));
        System.out.println("========================================");

        System.out.print("¿Desea agregar boletos al carrito? (s/n): ");
        String confirmar = scanner.nextLine().toLowerCase();

        if (confirmar.equals("s")) {
            // Reducir capacidad de la sala
            if (sucursalActual.reducirCapacidadSala(peliculaSeleccionada.getSala())) {

                System.out.println("Costo de la entrada por persona:");
                System.out.println("Adulto: $80");
                System.out.println("Niño: $50");

                System.out.print("Ingrese la cantidad de boletos de adulto que desea comprar: ");
                int cantidadAdultos = scanner.nextInt();
                scanner.nextLine(); // Limpiar

                System.out.print("Ingrese la cantidad de boletos de niño que desea comprar: ");
                int cantidadNinos = scanner.nextInt();
                scanner.nextLine(); // Limpiar

                carritoDeCompra.agregarBoletos(cantidadAdultos, cantidadNinos);
                Boleto.realizarPago(scanner, usuarioActual, cantidadAdultos, cantidadNinos);
                System.out.println("Ha comprado " + cantidadAdultos + " boletos de adulto y " + cantidadNinos + " boletos de niño");

                System.out.print("¿Desea agregar productos de la tienda a su compra? (1: sí, 0: no): ");
                int respuesta = scanner.nextInt();
                scanner.nextLine(); // Limpiar
                if (respuesta == 1) {
                    agregarProductos(sucursalActual, scanner);
                }
                peliculaSeleccionada.programarLiberacion(sucursalActual);

                generarTicketVirtual(sucursalActual, scanner);

            } else {
                System.out.println("No hay lugares disponibles en la sala " + peliculaSeleccionada.getSala() + ".");
            }
        } else {
            System.out.println("Compra cancelada.");
        }

    }

    private static void agregarProductos(Sucursal sucursalActual, Scanner scanner) {
        String identificadorConsumo = UUID.randomUUID().toString();
        System.out.println("Identificador de consumo: " + identificadorConsumo);

        boolean agregarMas = true;
        while (agregarMas) {
            List<Producto> productos = dulceria.getProductosPorSucursal(sucursalActual.getNombre());
            if (productos == null || productos.isEmpty()) {
                System.out.println("No hay productos disponibles en la dulcería.");
                return;
            }

            System.out.println("Productos disponibles en la dulcería de " + sucursalActual.getNombre() + ":");
            for (Producto producto : productos) {
                System.out.println("Producto: " + producto.getNombre() + " - Código: " + producto.getCodigo()
                        + " - Precio: $" + producto.getPrecio() + " - Categoría: " + producto.getCategoria()
                        + " - Stock: " + producto.getStock(sucursalActual.getNombre()));
            }

            System.out.print("Ingrese el código del producto que desea agregar: ");
            String codigoProducto = scanner.nextLine();
            Producto productoSeleccionado = null;
            for (Producto producto : productos) {
                if (producto.getCodigo().equals(codigoProducto)) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            if (productoSeleccionado == null) {
                System.out.println("Producto no encontrado. Intente de nuevo.");
                continue;
            }

            System.out.print("Ingrese la cantidad que desea agregar: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor a cero. Intente de nuevo.");
                continue;
            }

            if (cantidad > productoSeleccionado.getStock(sucursalActual.getNombre())) {
                System.out.println("Cantidad no disponible en stock. Intente de nuevo.");
                continue;
            }

            carritoDeCompra.agregarProducto(productoSeleccionado, cantidad);
            System.out.println("Ha agregado " + cantidad + " " + productoSeleccionado.getNombre() + "(s) a su compra.");

            System.out.print("¿Desea agregar más productos? (1: sí, 0: no): ");
            try {
                int respuesta = scanner.nextInt();
                scanner.nextLine(); // Limpiar
                if (respuesta != 1) {
                    agregarMas = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Intente nuevamente.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        carritoDeCompra.mostrarCarrito();
        System.out.println("Productos agregados a su compra. Identificador de consumo: " + identificadorConsumo);
    }

    private static void generarTicketVirtual(Sucursal sucursalActual, Scanner scanner) {
        TicketVirtual ticket = new TicketVirtual(sucursalActual.getNombre(), carritoDeCompra);
        ticket.mostrarTicket();
        ticket.guardarTicketEnArchivo();
        Boleto.realizarPagoFinal(scanner, usuarioActual, carritoDeCompra.getTotal());
    }

    private static void verCarritoDeCompras(Sucursal sucursalActual, Scanner scanner) {
        boolean editarCarrito = true;
        while (editarCarrito) {
            carritoDeCompra.mostrarCarrito();
            System.out.println("Opciones:");
            System.out.println("1. Agregar productos");
            System.out.println("2. Quitar productos");
            System.out.println("3. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar

            switch (opcion) {
                case 1:
                    agregarProductos(sucursalActual, scanner);
                    break;
                case 2:
                    quitarProductos(scanner);
                    break;
                case 3:
                    editarCarrito = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void verDulceria(Sucursal sucursalActual, Scanner scanner) {
        System.out.println("Productos disponibles en la dulcería de " + sucursalActual.getNombre() + ":");
        for (Producto producto : dulceria.getProductosPorSucursal(sucursalActual.getNombre())) {
            System.out.println("Producto: " + producto.getNombre() + " - Código: " + producto.getCodigo() + " - Precio: $" + producto.getPrecio() + " - Categoría: " + producto.getCategoria() + " - Stock: " + producto.getStock(sucursalActual.getNombre()));
        }
    }

    private static void quitarProductos(Scanner scanner) {
        System.out.print("Ingrese el código del producto que desea quitar: ");
        String codigoProducto = scanner.nextLine();
        Producto productoSeleccionado = null;
        int indiceProducto = -1;
        for (int i = 0; i < carritoDeCompra.getProductos().size(); i++) {
            Producto producto = carritoDeCompra.getProductos().get(i);
            if (producto.getCodigo().equals(codigoProducto)) {
                productoSeleccionado = producto;
                indiceProducto = i;
                break;
            }
        }

        if (productoSeleccionado == null) {
            System.out.println("Producto no encontrado en el carrito. Intente de nuevo.");
            return;
        }

        System.out.print("Ingrese la cantidad que desea quitar: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar

        if (cantidad > carritoDeCompra.getCantidades().get(indiceProducto)) {
            System.out.println("Cantidad no disponible en el carrito. Intente de nuevo.");
            return;
        }

        carritoDeCompra.quitarProducto(indiceProducto, cantidad);
        System.out.println("Ha quitado " + cantidad + " " + productoSeleccionado.getNombre() + "(s) de su carrito.");
    }

}
