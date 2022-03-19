package org.alozano.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class Departamento {
    private int id;
    private String nombre;
    private long presupuesto;
    private Programador jefe;
    private List<Programador> programadores;

    public Departamento(int id, String nombre, long presupuesto, Programador jefe, List<Programador> programadores) {
        this.id = id;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.jefe = jefe;
        this.programadores = programadores;
    }
}
