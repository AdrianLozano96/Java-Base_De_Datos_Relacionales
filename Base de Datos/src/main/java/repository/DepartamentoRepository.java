package repository;



import database.DataBaseController;
import model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartamentoRepository {

    private static DepartamentoRepository depSingleton = null;
    private DepartamentoRepository(){}

    public static DepartamentoRepository getInstance(){
        if(depSingleton ==null){
            depSingleton =new DepartamentoRepository();
        }
        return depSingleton;
    }

    //SELECT * FROM DEPARTAMENTO
    public Optional<List<Departamento>> selectAll() {
        String query = "SELECT * FROM departamento";
        DataBaseController db = DataBaseController.getInstance();   //Devuelve la instancia
        try {
            db.open();  //Abre la base de datos
            ResultSet result = db.select(query).orElseThrow(() -> new SQLException("Error al consultar registros de Departamentos"));//Devuelve Optional
            ArrayList<Departamento> list = new ArrayList<>();
            while (result.next()) {
                list.add(
                        new Departamento(
                                result.getLong("id"),
                                result.getString("nombre"),
                                result.getLong("presupuesto"),
                                result.getLong("idJefe")
                        )
                );
            }
            db.close();
            return Optional.of(list);
        } catch (SQLException e) {
            System.err.println("Error al obtener todos los departamentos: " + e.getMessage());
            return Optional.empty();
        }
    }

    //Hacemos un select de una tabla mediante un identificador
    public Optional<Departamento> selectById(long id) {
        //System.out.println("Obteniendo programador con id: " + id);
        String query = "SELECT * FROM departamento WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            ResultSet result = db.select(query, id).orElseThrow(() -> new SQLException("Error al consultar departamento con ID " + id));
            if (result.first()) {
                Departamento dep = new Departamento(
                        result.getLong("id"),
                        result.getString("nombre"),
                        result.getLong("presupuesto"),
                        result.getLong("idJefe")
                );
                db.close();
                //System.out.println(user.toString());
                return Optional.of(dep);
            } else {
                return Optional.empty();
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener departamento con id: " + id + " - " + e.getMessage());
            return Optional.empty();
        }
    }

    //Se realiza la insercción de un nuevo campo/fila en la tabla
    public Optional<Departamento> insert(Departamento dep) {
        System.out.println("Insertando departamento");
        String query = "INSERT INTO departamento VALUES (null, ?, ?, ?)"; //El null se pone en le campo en el que va la clave
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            //No pasa la clave
            ResultSet res = db.insert(query, dep.getNombre(), dep.getPresupuesto(), dep.getJefe())
                    .orElseThrow(() -> new SQLException("Error insertar Departamento"));   //Excepcion
            // Para obtener su ID
            if (res.first()) {
                dep.setId(res.getLong(1));

                // una vez insertado comprobamos que esta correcto para devolverlo
                db.close();
                System.out.println(dep.toString());
                return Optional.of(dep);   //Revisar
            }else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar Departamento" + e.getMessage());
            return Optional.empty();
        }
    }

    //UPDATE
    public Optional<Departamento> update(Departamento dep) {
        System.out.println("Actualizando departamento con id: " + dep.getId());
        String query = "UPDATE departamento SET nombre = ?, presupuesto = ?, idJefe = ? WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            int res = db.update(query, dep.getNombre(), dep.getPresupuesto(), dep.getJefe(), dep.getId());
            db.close();
            if (res > 0)
                System.out.println(dep.toString());
            return Optional.of(dep);

        } catch (SQLException e) {
            System.err.println("Error al actualizar departamento" + e.getMessage());
            return Optional.empty();
        }

    }

    //DELETE
    public void delete(Departamento dep) {
        System.out.println("Eliminando departamento con id: " + dep.getId());
        String query = "DELETE FROM departamento WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            int res = db.delete(query, dep.getId());
            db.close();
            if (res > 0)
                System.out.println(dep.toString());

        } catch (SQLException e) {
            System.err.println("Error al eliminar departamento" + e.getMessage());
        }
    }

    public String deletes(Departamento dep) {
    //public Optional<String> deletes(Departamento dep) {
        System.out.println("Eliminando departamento con id: " + dep.getId());
        String query = "DELETE FROM departamento WHERE id = ?";
        DataBaseController db = DataBaseController.getInstance();
        try {
            db.open();
            int res = db.delete(query, dep.getId());
            db.close();
            if (res > 0)
                System.out.println(dep.toString());

        } catch (SQLException e) {
            System.err.println("Error al eliminar departamento" + e.getMessage());
            //return Optional.empty();

        }
        return dep.toString();
    }


}
