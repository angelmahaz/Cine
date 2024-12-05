package Cliente;

import java.util.Scanner;
import java.util.UUID;

public class Usuario {
    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String direccion;
    private String celular;
    private String correoElectronico;
    private String contrasena;

    // Información de la tarjeta
    private String nombreTitular;
    private String numeroTarjeta;
    private String fechaVigencia;
    private String codigoVerificacion;
    private String tipoTarjeta;

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno,String direccion, String celular, String correoElectronico, String contrasena  ) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.direccion = direccion;
        this.celular=celular;
        this.correoElectronico= correoElectronico;
        this.contrasena = contrasena;       
    }

    // Método para establecer cuenta
    public void setCuenta() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nEscribe tu nombre(s):");
            this.nombre = scanner.nextLine();

            System.out.println("Escribe tu apellido paterno:");
            this.apellidoPaterno = scanner.nextLine();

            System.out.println("Escribe tu apellido materno:");
            this.apellidoMaterno = scanner.nextLine();

            System.out.println("Escribe tu dirección:");
            this.direccion = scanner.nextLine();

            System.out.println("Escribe tu número de celular:");
            this.celular = scanner.nextLine();

            System.out.println("Escribe tu correo electrónico:");
            this.correoElectronico = scanner.nextLine();
        }
    }

    // Método para mostrar la cuenta
    public void getCuenta() {
        System.out.println("Datos del Cliente:");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Apellido Paterno: " + this.apellidoPaterno);
        System.out.println("Apellido Materno: " + this.apellidoMaterno);
        System.out.println("Dirección: " + this.direccion);
        System.out.println("Celular: " + this.celular);
        System.out.println("Correo Electrónico: " + this.correoElectronico);
    }

    // Método para establecer contraseña
    public void setContrasena() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\nEscribe una contraseña de al menos 8 caracteres (sin caracteres especiales):");
            boolean entradaValida = false;

            while (!entradaValida) {
                String nuevaContrasena = scanner.nextLine();

                if (nuevaContrasena.length() >= 8 && nuevaContrasena.matches("[a-zA-Z0-9]*")) {
                    this.contrasena = nuevaContrasena;
                    entradaValida = true;
                    System.out.println("Contraseña establecida con éxito.");
                } else {
                    System.out.println("La contraseña debe tener al menos 8 caracteres y no incluir caracteres especiales. Inténtalo de nuevo.");
                }
            }
        }
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para iniciar sesión
    public boolean iniciarSesion(String correo, String contrasena) {
        return this.correoElectronico.equals(correo) && this.contrasena.equals(contrasena);
    }

    // Método para guardar datos de la tarjeta
    public void guardarTarjeta(String nombreTitular, String numeroTarjeta, String fechaVigencia, String codigoVerificacion, String tipoTarjeta) {
        this.nombreTitular = nombreTitular;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaVigencia = fechaVigencia;
        this.codigoVerificacion = codigoVerificacion;
        this.tipoTarjeta = tipoTarjeta;
    }

    // Verificar si hay una tarjeta guardada
    public boolean tieneTarjetaGuardada() {
        return nombreTitular != null && numeroTarjeta != null && fechaVigencia != null && codigoVerificacion != null && tipoTarjeta != null;
    }

    // Método para verificar membresía de lealtad (sin implementación en el código original)
    public boolean esMiembroLealtad() {
        return false; // Placeholder, depende de la implementación futura
    }
}

