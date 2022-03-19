package controller;

import dto.DepartamentoDTO;
import repository.DepartamentoRepository;
import repository.DepartamentoRepositoryJPA;
import service.DepartamentoService;
import service.DepartamentoServiceJPA;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class DepartamentoControllerJPA {

    private static DepartamentoControllerJPA controller = null;

    // Mi Servicio unido al repositorio
    private final DepartamentoServiceJPA departamentoService;

    // Implementamos nuestro Singleton para el controlador
    private DepartamentoControllerJPA(DepartamentoServiceJPA departamentoService) {
        this.departamentoService = departamentoService;
    }

    public static DepartamentoControllerJPA getInstance() {
        if (controller == null) {
            //controller = new DepartamentoControllerJPA(new DepartamentoServiceJPA(DepartamentoRepositoryJPA.getInstance()));
        }
        return controller;
    }

    // Ejemplo de operaciones
    public List<DepartamentoDTO> getAllDepartamento() throws SQLException {
        return departamentoService.getAllDepartamentos();
    }

    public DepartamentoDTO getDepartamentoById(Long id) throws SQLException {
        return departamentoService.getDepartamentoById(id);
    }

    public DepartamentoDTO departamentoDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        return departamentoService.departamentoDepartamento(departamentoDTO);
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        return departamentoService.updateDepartamento(departamentoDTO);
    }

    public DepartamentoDTO deletedepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        return departamentoService.deleteDepartamento(departamentoDTO);
    }

    // Lo hago como Optional para que veas como deberías hacerlo sin devolver siempre null
    public Optional<DepartamentoDTO> getDepartamentoByIdOptional(Long id) throws SQLException {
        return Optional.of(departamentoService.getDepartamentoById(id));
    }

    public List<DepartamentoDTO> getDepartamentoByProgramadorId(Long progId) throws SQLException {
        // Vamos a devolver el JSON de las categorías
        return departamentoService.getDepartamentosByProgramadorId(progId);
    }

}
