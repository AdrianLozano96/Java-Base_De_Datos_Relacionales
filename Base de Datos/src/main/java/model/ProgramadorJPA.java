package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.List;
//Se usan obj de otras clases
//Aquí no se usa @Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "programador") // Ojo con la minuscula que en la tabla está así
// Todos los programadores
@NamedQuery(name = "Programador.findAll", query = "SELECT p FROM ProgramadorJPA p")
// Todos los programadores con emial indicados
//@NamedQuery(name = "User.getByMail", query = "SELECT p FROM ProgramadorJPA p WHERE p.email = ?1")
// Todos los lenguajes de un usuario
//@NamedQuery(name = "User.getMyPosts", query = "SELECT p.getlenguajes FROM ProgramadorJPA p WHERE p.id = ?1")
public class ProgramadorJPA {

    private long id;
    private String nombre;
    private int experiencia;
    private double salario;
    private long idDepartamento;
    private List<String> lenguajes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 100)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "experiencia", nullable = false, length = 100)
    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    @Basic
    @Column(name = "salario", nullable = false, length = 100)
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Basic
    @Column(name = "departamento", nullable = false, length = 100)
    public long getIdDepartamento() {
        return idDepartamento;
    }
    public void setIdDepartamento(long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }




/*
    @Basic
    @ColumnTransformer(write = " SHA(?) ")
    // Le decimos que lo transforme con esta función. Nos ahorramos cifrarlo nosotros
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Basic
    @CreationTimestamp // Es una marca de tiempo
    @Column(name = "fecha_registro", nullable = false)
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

 */


}
