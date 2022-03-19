package model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
// Consulta para obtener todos
@NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM departamento d")
// Consulta para obtener todos los post dado el id de un usuario
//@NamedQuery(name = "Departamento.getByUserId", query = "SELECT p FROM Departamento p WHERE p.user.id = ?1")
@Table(name = "departamento") // Ojo con la minuscula que en la tabla está así
public class DepartamentoJPA {
    private long id;
    private String nombre;
    private long presupuesto;
    private Programador jefe;
    private List<Programador> programadores;

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
    @Column(name = "nombre", nullable = false, length = 250)
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "presupuesto", nullable = false, length = 250)
    public long getPresupuesto() {
        return presupuesto;
    }
    public void setPresupuesto(long presupuesto) {
        this.presupuesto = presupuesto;
    }

    /*
    //@ManyToOne
    //@JoinColumn(name = "programador_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    @JoinColumn(name = "programador_id", referencedColumnName = "id", nullable = false)
    public Programador getJefe() {
        return jefe;
    }
    public void setJefe(Programador jefe) {
        this.jefe = jefe;
    }

    // Pongo EAGER porque están en contexto diferentes y debememos conseguirlo
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "programador", cascade = CascadeType. REMOVE) // cascade = CascadeType.ALL
    public List<Programador> getProgramadores() {
        return programadores;
    }
    public void setProgramadores(List<Programador> programadores) {
        this.programadores = programadores;
    }

     */


}
