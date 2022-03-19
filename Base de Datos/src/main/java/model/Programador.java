package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Programador {
    private long id;
    private String nombre;
    private int experiencia;
    private double salario;
    private long idDepartamento;
    private List<String> lenguajes;

    //Insert
    public Programador(String nombre, int experiencia, double salario, List<String> lenguajes, long idDepartamento ) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.salario = salario;
        this.idDepartamento = idDepartamento;
        this.lenguajes = lenguajes;
    }
    //Update
    public Programador(long id, String nombre, int experiencia, double salario, List<String> lenguajes, long idDepartamento) {
        this.id = id;
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.salario = salario;
        this.idDepartamento = idDepartamento;
        this.lenguajes = lenguajes;
    }
}
