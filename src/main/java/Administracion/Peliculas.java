package Administracion;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Peliculas {
    public String nombreDePelicula;
    private String clasificacion;
    private final int duracion; // Duración en minutos
    private List<String> actores;
    private String sinopsis;
    private String resumen;
    private int costo;
    private final int sala;
    private LocalTime horarioInicio;
    private LocalTime horarioFin;// Horario de inicio

    public Peliculas(String nombreDePelicula, int sala,int duracion) {
        this.duracion= duracion;
        this.nombreDePelicula = nombreDePelicula;
        this.sala = sala;
        this.actores = new ArrayList<>();
    }
    // Método para establecer el horario de inicio
    public void setHorarioInicio(String horarioInicioStr) {
        try {
            this.horarioInicio = LocalTime.parse(horarioInicioStr); // Convertir String a LocalTime
            calcularHorarioFin(); // Calcular automáticamente el horario de fin
        } catch (Exception e) {
            System.out.println("Formato de horario inválido. Use HH:mm (ejemplo: 14:30)");
        }
    }

    // Método para calcular el horario de finalización
    public void calcularHorarioFin() {
        if (horarioInicio != null) {
            this.horarioFin = horarioInicio.plusMinutes(duracion); // Sumamos la duración al horario de inicio
        }
    }

    public void programarLiberacion(Sucursal sucursal) {
        Timer timer = new Timer();
        int duracionEnMilisegundos = this.duracion * 60 * 1000; // Convertir duración a milisegundos

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                sucursal.liberarCapacidadSala(sala);
                System.out.println("Se liberó un lugar en la sala " + sala + " de la sucursal " + sucursal.nombre_sucursal);
            }
        }, duracionEnMilisegundos);
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public List<String> getActores() {
        return actores;
    }

    public void setActores(List<String> actores) {
        this.actores = actores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public String getNombreDePelicula() {
        return nombreDePelicula;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public int getSala() {
        return sala;
    }

    public String getResumen() {
        return resumen;
    }

    
    
}
