package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.DepartamentoDTO;
import repository.DepartamentoRepository;
import service.DepartamentoService;

import java.sql.SQLException;

public class DepartamentoController {

        private static DepartamentoController controller = null;

        // Mi Servicio unido al repositorio
        private final DepartamentoService departamentoService;

        // Implementamos nuestro Singleton para el controlador
        private DepartamentoController(DepartamentoService departamentoService) {
            this.departamentoService = departamentoService;
        }

        public static DepartamentoController getInstance() {
            if (controller == null) {
                controller = new DepartamentoController(new DepartamentoService(DepartamentoRepository.getInstance()));
            }
            return controller;
        }


        // Ejemplo de operaciones
        // Usamos DTO para implementar este patrón en represantación y trasporte de la información
//    public List<CategoryDTO> getAllCategories() {
//        return categoryService.getAllCategories();
//    }

        public String getAllDepartamentosJSON() throws SQLException {	//hacer esto con byid, update, delate e inserts solo cambia el nombre el cuerpo es el mismo
            // Vamos a devolver el JSON de las categorías
            final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
            return prettyGson.toJson(departamentoService.getAllDepartamento());
        }

    public String getAllDepartamentoJSON() throws SQLException {
        // Vamos a devolver el JSON de las categorías
        final Gson prettyGson = new GsonBuilder()
                //.addSerializationExclusionStrategy(strategy)  //Para excluir un campo ver en clase Controller
                .setPrettyPrinting()
                .create();
        return prettyGson.toJson(departamentoService.getAllDepartamento());
    }
/*
    public String getDepartamentoByIdJSON(Long id) {
        // Vamos a devolver el JSON de las categorías
        try {
            final Gson prettyGson = new GsonBuilder()
                    //.addSerializationExclusionStrategy(strategy)
                    .setPrettyPrinting()
                    .create();
            return prettyGson.toJson(departamentoService.getDepartamentoById(id));
        } catch (SQLException e) {
            System.err.println("Error UserController en getUserById " + e.getMessage());
            return "Error UserController en getUserById: " + e.getMessage();
        }
    }

 */
/*
    public String postUserJSON(DepartamentoDTO userDTO) {
        try {
            final Gson prettyGson = new GsonBuilder()
                    //.addSerializationExclusionStrategy(strategy)
                    .setPrettyPrinting()
                    .create();
            return prettyGson.toJson(departamentoService.postUser(userDTO));
        } catch (SQLException e) {
            System.err.println("Error UserController en postUser " + e.getMessage());
            return "Error UserController en postUser: " + e.getMessage();
        }
    }

 */
/*
    public String updateDepartamentoJSON(DepartamentoDTO userDTO) {
        try {
            final Gson prettyGson = new GsonBuilder()
                    //.addSerializationExclusionStrategy(strategy)
                    .setPrettyPrinting()
                    .create();
            return prettyGson.toJson(departamentoService.updateDepartamento(userDTO));
        } catch (SQLException e) {
            System.err.println("Error UserController en updateUser " + e.getMessage());
            return "Error UserController en updateUser: " + e.getMessage();
        }
    }

    public String deleteDepartamentoJSON(DepartamentoDTO userDTO) {
        try {
            final Gson prettyGson = new GsonBuilder()
                    //.addSerializationExclusionStrategy(strategy)
                    .setPrettyPrinting()
                    .create();
            return prettyGson.toJson(departamentoService.deleteDepartamento(userDTO));
        } catch (SQLException e) {
            System.err.println("Error UserController en deleteUser " + e.getMessage());
            return "Error UserController en deleteUser: " + e.getMessage();
        }
    }

 */



}
