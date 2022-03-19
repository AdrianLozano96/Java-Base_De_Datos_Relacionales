package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
    private long id;
    private String nombre;
    private long presupuesto;
    private long jefe;
    //private List<String> programadores;

    public Departamento(String nombre, long presupuesto, long jefe) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.jefe = jefe;
    }


}