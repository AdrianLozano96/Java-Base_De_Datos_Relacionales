package org.alozano.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class Programador {
    private int id;
    private String nombre;
    private int experiecia;
    private double salario;
    private String lenguaje;    //Se ha de mejorar
    //private List<Lenguajes> lenguagesPro;

    public Programador(int id, String nombre, int experiecia, double salario, String lenguaje) {
        this.id = id;
        this.nombre = nombre;
        this.experiecia = experiecia;
        this.salario = salario;
        this.lenguaje = lenguaje;
    }
}
