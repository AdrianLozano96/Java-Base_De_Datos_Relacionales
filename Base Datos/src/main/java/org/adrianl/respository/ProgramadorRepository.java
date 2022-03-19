package org.adrianl.respository;

import org.adrianl.database.DataBaseController;
import org.adrianl.model.Programador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgramadorRepository {

    //SELECT * FROM PROGRAMADORES
    public Optional<List<Programador>> selectAll() {
        //System.out.println("Obteniendo todos los usuarios");
        String query = "SELECT * FROM programadores";
        DataBaseController db = DataBaseController.getInstance();   //Devuelve la instancia
        try {
            db.open();  //Abre la base de datos
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar registros de Programadores"));//Devuelve Optional
            ArrayList<Programador> list = new ArrayList<>();
            while (result.next()) {
                list.add(
                        new Programador(
                                result.getLong("id"),
                                result.getString("nombre"),
                                result.getInt("experiencia"),
                                result.getDouble("salario"),
                                result.getLong("idDepartamento"),
                                List.of(result.getString("lenguajes").split(";"))
                        )
                );
            }
            db.close();
            return Optional.of(list);
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los programadores: " + e.getMessage());
            return Optional.empty();
        }
    }

    //Hacemos un select de una tabla mediante un identificador
    public Optional<Programador> selectById(long id) {
        //System.out.println("Obteniendo programador con id: " + id);
        String query = "SELECT * FROM programadores WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            ResultSet result = db.select(query, id).orElseThrow(() -> new SQLException("Error al consultar programadores con ID " + id));
            if (result.first()) {
                Programador prog = new Programador(
                        result.getLong("id"),
                        result.getString("nombre"),
                        result.getInt("experiencia"),
                        result.getDouble("salario"),
                        result.getLong("idDepartamento"),
                        List.of(result.getString("lenguajes").split(";"))
                );
                db.close();
                //System.out.println(user.toString());
                return Optional.of(prog);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener programador con id: " + id + " - " + e.getMessage());
            return Optional.empty();
        }
    }

    //Se realiza la insercción de un nuevo campo/fila en la tabla
    public Optional<Programador> insert(Programador prog) {
        System.out.println("Insertando programador");
        String query = "INSERT INTO programadores VALUES (null, ?, ?, ?, ?, ?)"; //El null se pone en le campo en el que va la clave
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            //No pasa la clave
            ResultSet res = db.insert(query, prog.getNombre(), prog.getExperiencia(), prog.getSalario(),
            String.join(";", prog.getLenguajes()), prog.getIdDepartamento())
                    .orElseThrow(() -> new SQLException("Error insertar Programador"));   //Excepcion
            // Para obtener su ID
            if (res.first()) {
                prog.setId(res.getLong(1));

                // una vez insertado comprobamos que esta correcto para devolverlo
                db.close();
                System.out.println(prog.toString());
                return Optional.of(prog);   //Revisar
            }else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar Programador" + e.getMessage());
            return Optional.empty();
        }
    }

    //UPDATE
    public Optional<Programador> update(Programador programador) {
        System.out.println("Actualizando programador con id: " + programador.getId());
        String query = "UPDATE programadores SET nombre = ?, experiencia = ?, salario = ?," +
                "lenguajes = ?, idDepartamento = ? WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            int res = db.update(query, programador.getNombre(), programador.getExperiencia(), programador.getSalario(),
                    String.join(";", programador.getLenguajes()), programador.getIdDepartamento(), programador.getId());
            db.close();
            if (res > 0)
                System.out.println(programador.toString());
            return Optional.of(programador);

        } catch (SQLException e) {
            System.err.println("Error al actualizar programador" + e.getMessage());
            return Optional.empty();
        }

    }

    //DELETE
    public void delete(Programador programador) {
        System.out.println("Eliminando programador con id: " + programador.getId());
        String query = "DELETE FROM programadores WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            int res = db.delete(query, programador.getId());
            db.close();
            if (res > 0)
                System.out.println(programador.toString());
        } catch (SQLException e) {
            System.err.println("Error al eliminar usuario" + e.getMessage());
        }
    }
    





}

