package Administracion;

import Cliente.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.time.LocalTime;

public final class AdministracionCine {

    public final ArrayList<Sucursal> sucursales;
    private List<Usuario> usuarios;
    
    // Constructor
    public AdministracionCine() {
        this.sucursales = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario("", "", "1", "","", "", ""));
        usuarios.add(new Usuario("", "", "2", "","", "", ""));
        
        inicializarCines();
    }
    
    
     public void inicializarCines(){
        //Lists de peliculas en cada sucursal
        ArrayList<Peliculas> PeliculasCU = new ArrayList<>();
        ArrayList<Peliculas> PeliculasUniversidad = new ArrayList<>();
        ArrayList<Peliculas> PeliculasDelta = new ArrayList<>();
        ArrayList<Peliculas> PeliculasXochimilco = new ArrayList<>();
        
        //Sucursales
        Sucursal CU = new Sucursal("CU", PeliculasCU, 120, 150, 200);
        Sucursal Universidad = new Sucursal("Universidad",PeliculasUniversidad, 100, 160, 175);
        Sucursal Delta = new Sucursal("Delta", PeliculasDelta, 80, 100, 150);
        Sucursal Xochimilco = new Sucursal("Xochimilco", PeliculasXochimilco, 90, 125, 140);
        
        sucursales.add(CU);
        sucursales.add(Universidad);
        sucursales.add(Delta);
        sucursales.add(Xochimilco);
          
     
        //CU
        Peliculas Five_Nights_at_Freddys_CU = new Peliculas ("Five Nights at Freddys",3,120 );
        Five_Nights_at_Freddys_CU.setHorarioInicio("22:00");
        
        Peliculas Matrix_CU = new Peliculas ("Matrix", 2 , 120);
        Matrix_CU.setHorarioInicio("19:30");
        
        Peliculas Deadpool_Wolverine_CU = new Peliculas ("Deadpool & Wolverine",1,120);
        Deadpool_Wolverine_CU.setHorarioInicio("18:20");
        
        Peliculas Oppenheimer_CU = new Peliculas ("Oppenheimer",1, 120);
        Oppenheimer_CU.setHorarioInicio("19:30");
        
        Peliculas Barbie_CU = new Peliculas ("Barbie",1, 90);
        Barbie_CU.setHorarioInicio("16:00");
        // Agregar películas a la lista de CU
        PeliculasCU.add(Five_Nights_at_Freddys_CU);
        PeliculasCU.add(Matrix_CU);
        PeliculasCU.add(Deadpool_Wolverine_CU);
        PeliculasCU.add(Oppenheimer_CU);
        PeliculasCU.add(Barbie_CU);
                
        //Universidad
        Peliculas Five_Nights_at_Freddys_Universidad = new Peliculas ("Five Nights at Freddys",1,120);
        Five_Nights_at_Freddys_Universidad.setHorarioInicio("20:30");        
        
        Peliculas Rápidos_y_Furiosos_10_Universidad = new Peliculas("Rápidos_y_Furiosos_10",1,120);
        Rápidos_y_Furiosos_10_Universidad.setHorarioInicio("18:00");
        
        Peliculas Super_Mario_Bros_Universidad = new Peliculas("Super Mario Bros",3,120);
        Super_Mario_Bros_Universidad.setHorarioInicio("13:00");
        
        Peliculas Deadpool_Wolverine_Universidad = new Peliculas("Deadpool_Wolverine",2,140);
        Deadpool_Wolverine_Universidad.setHorarioInicio("20:30");
        
        Peliculas Godzilla_vs_Kong_2_Universidad = new Peliculas("Godzilla_vs_Kong_2",3,120);
        Godzilla_vs_Kong_2_Universidad.setHorarioInicio("13:00");
        
        // Agregar películas a la lista de Universidad
        PeliculasUniversidad.add(Five_Nights_at_Freddys_Universidad);
        PeliculasUniversidad.add(Rápidos_y_Furiosos_10_Universidad);
        PeliculasUniversidad.add(Super_Mario_Bros_Universidad);
        PeliculasUniversidad.add(Deadpool_Wolverine_Universidad);
        PeliculasUniversidad.add(Godzilla_vs_Kong_2_Universidad);
        
        
        
        Peliculas Hércules_Delta = new Peliculas("Hércules",2,90);
        Hércules_Delta.setHorarioInicio("16:00");
        
        Peliculas Hellboy_Delta = new Peliculas("Hellboy",2,120);
        Hellboy_Delta.setHorarioInicio("22:00");
        
        Peliculas Super_Mario_Bros_Delta = new Peliculas("Super_Mario_Bros",3,150);
        Super_Mario_Bros_Delta.setHorarioInicio("16:30");
        
        Peliculas El_Rey_León_Delta = new Peliculas("El_Rey_León",1,150);
        El_Rey_León_Delta.setHorarioInicio("16:30");
        
        Peliculas Deadpool_Wolverine_Delta = new Peliculas("Deadpool & Wolverine",3,120);
        Deadpool_Wolverine_Delta.setHorarioInicio("22:00");
        
        PeliculasDelta.add(Hércules_Delta);
        PeliculasDelta.add(Hellboy_Delta);
        PeliculasDelta.add(Super_Mario_Bros_Delta);
        PeliculasDelta.add(El_Rey_León_Delta);
        PeliculasDelta.add(Deadpool_Wolverine_Delta);
        
        Peliculas Hércules_Xochimilco = new Peliculas("Hércules",3,120);
        Hércules_Xochimilco.setHorarioInicio("13:00");
        
        Peliculas Deadpool_Wolverine_Xochimilco = new Peliculas("Deadpool & Wolverine",1,120);
        Deadpool_Wolverine_Xochimilco.setHorarioInicio("19:30");
        
        Peliculas Super_Mario_Bros_Xochimilco = new Peliculas("Super Mario Bros",3,90);
        Super_Mario_Bros_Xochimilco.setHorarioInicio("16:00");
        
        Peliculas  El_Rey_León_Xochimilco = new Peliculas("El_Rey_León",2,90);
        El_Rey_León_Xochimilco.setHorarioInicio("14:00");
        
        Peliculas  Alien_Romulus_Xochimilco = new Peliculas("Alien Romulus",2,120);
        Alien_Romulus_Xochimilco.setHorarioInicio("20:30");
        
        PeliculasXochimilco.add(Hércules_Xochimilco);
        PeliculasXochimilco.add(Deadpool_Wolverine_Xochimilco);
        PeliculasXochimilco.add(Super_Mario_Bros_Xochimilco);
        PeliculasXochimilco.add(El_Rey_León_Xochimilco);
        PeliculasXochimilco.add(Alien_Romulus_Xochimilco);
     
    }
    
    public static void mostrarPeliculasDeSucursal(Sucursal sucursal) {
        System.out.println("\n========================================");
        System.out.println("         Películas en " + sucursal.getNombre());
        System.out.println("========================================");
        System.out.printf("| %-30s | %-10s | %-10s |\n", "Nombre de Película", "Horario", "Sala");
        System.out.println("----------------------------------------");

        for (Peliculas pelicula : sucursal.getPeliculas()) {
            System.out.printf("| %-30s | %-10s | %-10d |\n",
                    pelicula.getNombreDePelicula(),
                    (pelicula.getHorarioInicio() != null ? pelicula.getHorarioInicio().toString() : "No definido"),
                    pelicula.getSala());
        }

        System.out.println("========================================\n");
    }
 
    
    public boolean registrarUsuario(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getCorreoElectronico().equals(usuario.getCorreoElectronico())) {
                return false; // Usuario ya registrado
            }
        }
        usuarios.add(usuario);
        return true;
    }
    public Usuario obtenerUsuario(String correo, String contrasena) {
        for (Usuario u : usuarios) {
            if (u.getCorreoElectronico().equals(correo) && u.iniciarSesion(correo, contrasena)) {
                return u;
            }
        }
        return null;
    }
    
   
    public void buscarPeliculaPorNombre(String nombrePelicula) {
        boolean encontrada = false;
        
        for (Sucursal sucursal : sucursales) {
            for (Peliculas pelicula : sucursal.getPeliculas()) {
                if (pelicula.getNombreDePelicula().equalsIgnoreCase(nombrePelicula)) {
                    System.out.println("Película encontrada en la sucursal: " + sucursal.getNombre());
                    System.out.printf("Nombre: %-30s | Horario: %-10s | Sala: %-10d\n",
                            pelicula.getNombreDePelicula(),
                            (pelicula.getHorarioInicio() != null ? pelicula.getHorarioInicio().toString() : "No definido"),
                            pelicula.getSala());
                    encontrada = true;
                }
            }
        }
        
        if (!encontrada) {
            System.out.println("Película no encontrada en ninguna sucursal.");
        }
    }
}