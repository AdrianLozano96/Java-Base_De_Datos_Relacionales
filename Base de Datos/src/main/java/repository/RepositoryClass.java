package repository;

import database.DataBaseController;
import model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryClass {

    /*
    HACER UN SELECT ALL         SELECT * FROM DEPARTAMENTO
    1º Hacer un método que devuelva un Optional de un lista de la clase.
    2º Instanciar clase DataBaseController y crear un String en donde guardar la consulta.
    3º Dentro de un try catch  méter el código, siendo lo primero abrir la base de datos.
    4º Hacer ResultSet (ver bien para lo que es) y asignarle el DataBaseController.select(String consulta).orElseThrow(()->new SQLException("Error"));
    5º Crear la lista e inicializarla.
    6º Dentro de un while(resultSet.next()), añadir a la lista un nuevo objeto de la clase metiendole como valores
       el resultSet.getLong, getString, getInt con el nombre del campo correspondiente y cerrar el while.
    7º Cerrar la DataBaseController y devover Optional.of(lista) y terminar el try.
    8º Para el catch imprimir el error y devolver un Optional.empty();

    Para el caso de sleccionar por id u otro campo habra que ponerselo por parámetros al método, cambiar la consulta (WHERE id = ?)
    En vez de devolver una lista Optional de la clase, devolverá un objeto Optional de la clase. En el dbc.select poner (consulta, id o campo)
    En vez de poner un while poner un if (resultSet.first()), depués se crea un objeto de la clase donde almacenar los datos y devolverlo.
     */

    /*
    HACER UN INSERT     Se realiza la insercción de un nuevo campo/fila en la tabla
    1º Crear un método que devuelve un Optional de la clase y pasarle por parámetro un objeto de la clase.
    2ºHacer un String donde guardar la consulta "INSERT INTO departamento VALUES (null, ?, ?, ?)" y una instancia de DataBaseController.
    3º Abrir try catch y dentro del try abrir el dbc y hacer un ResultSet asignandole el
    dbc.insert(consulta, objeto del parametro con sus gets obj.get, obj.get ).orElseThrow(()->new SQLException("Error"));
    4º Con un if(resultSet.first()) obj.setId(resultSet.getLong(1), cerrar el dbc, imprimir el objeto y devolverlo con Optional.of(obj);
    5º Sino devolver optional.empty() y cerrar el try habrir el catch y devovlver Optional.empty();
     */

    /*
    ACTUALIZAR UPDATE
    1º Hacer un método que devulelva un Optional de la clase y pasarle por parámetro un objeto de la clase.
    2º Guardar en un String la consulta "UPDATE departamento SET nombre = ?, presupuesto = ?, idJefe = ? WHERE id = ?"; e instanciar dbc
    3º Abrir try, abrir dbc, en un int almacenar dbc.update(consulta, getters del obj pasado por parámetro y cerrar dbc.
    4º If(el entero anterior es mayor a 0 muestrame el obj y fin del if, después devolver Optional.of(obj del parámetro.
    5º Cerrar el try abrir el catch y devolver Optional.empty();
     */

    /*
    Eleminal DELETE
    1º Hacer un método que no devuelve nada y pasarle por parámetros un objeto de la clase .
    2º Guardar en un String la consulta "DELETE FROM departamento WHERE id = ?"; e instanciar DataBaseControler.
    3º Abrir un try, abrir el dbc, en un int almacenar dbc.delete(consulta, obj del parametro.getId()) y cerrar dbc.
    4º If(el entero anterior es mayor a 0 muestrame el obj y fin del if.
    5º Cerrar el try abrir el catch.
     */



}
