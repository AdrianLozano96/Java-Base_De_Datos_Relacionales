package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;
import service.DepartamentoService;
import service.ProgramadorService;

import java.sql.SQLException;

public class ProgramadorController {

    private static ProgramadorController controller = null;

    // Mi Servicio unido al repositorio
    private final ProgramadorService programadorService;

    // Implementamos nuestro Singleton para el controlador
    private ProgramadorController(ProgramadorService programadorService) {
        this.programadorService = programadorService;
    }

    public static ProgramadorController getInstance() {
        if (controller == null) {
            controller = new ProgramadorController(new ProgramadorService(ProgramadorRepository.getInstance()));
        }
        return controller;
    }


    // Ejemplo de operaciones
    // Usamos DTO para implementar este patrón en represantación y trasporte de la información
//    public List<CategoryDTO> getAllCategories() {
//        return categoryService.getAllCategories();
//    }

    public String getAllCategoriesJSON() {	//hacer esto con byid, update, delate e inserts solo cambia el nombre el cuerpo es el mismo
        // Vamos a devolver el JSON de las categorías
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(programadorService.getAllCategories());
    }
}
