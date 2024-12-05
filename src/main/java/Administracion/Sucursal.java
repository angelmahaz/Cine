package Administracion;

import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class Sucursal {
    
    public static final int SALA_1 = 1;
    public static final int SALA_2 = 2;
    public static final int SALA_3 = 3;
     
    public String nombre_sucursal;
    public List<Peliculas> peliculas;     
    public Map<Integer, Integer> salas;    

    public Sucursal(String nombre, List<Peliculas> peliculas,int capacidadSala1, int capacidadSala2, int capacidadSala3) {
        salas = new HashMap<>();
        
        this.nombre_sucursal = nombre;
        this.peliculas = peliculas;
        
        salas.put(SALA_1, capacidadSala1);
        salas.put(SALA_2, capacidadSala2);
        salas.put(SALA_3, capacidadSala3);
    }
    
    public boolean reducirCapacidadSala(int sala) {
        if (salas.containsKey(sala) && salas.get(sala) > 0) {
            salas.put(sala, salas.get(sala) - 1);
            return true; // Operación exitosa
        }
        return false; // No hay lugares disponibles
    }


    public String getNombre() {
        return nombre_sucursal;
    }

    public List<Peliculas> getPeliculas() {
        return peliculas;
    }

    
    public void liberarCapacidadSala(int sala) {
        if (salas.containsKey(sala)) {
            salas.put(sala, salas.get(sala) + 1);
        }
    }

    public Map<Integer, Integer> getSalas() {
    return salas;
    } 
  }    
