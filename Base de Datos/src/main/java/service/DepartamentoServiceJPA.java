package service;

import dto.DepartamentoDTO;
import mapper.DepartamentoMapper;
import model.Departamento;
import repository.DepartamentoRepository;
import repository.DepartamentoRepositoryJPA;

import java.sql.SQLException;
import java.util.List;

public class DepartamentoServiceJPA extends BaseService<Departamento, Long, DepartamentoRepositoryJPA> {
    DepartamentoMapper mapper = new DepartamentoMapper();

// Inyección de dependencias en el constructor. El servicio necesita este repositorio
public DepartamentoServiceJPA(DepartamentoRepositoryJPA repository) {
        super(repository);
        }

// Otras operaciones o especificaciones para CRUD
// O podíamos mapear el nombre
// O simplemente ocultar las que no queramos usar en niveles superiores

    public List<DepartamentoDTO> getAllDepartamentos() throws SQLException {
        // Obtenemos la lista
        return mapper.toDTO(this.findAll());
    }

    public DepartamentoDTO getDepartamentoById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public DepartamentoDTO departamentoDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento dep = this.save(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(dep);
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento dep = this.update(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(dep);
    }

    public DepartamentoDTO deleteDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        Departamento dep = this.delete(mapper.fromDTO(departamentoDTO));
        return mapper.toDTO(dep);
    }

    public List<DepartamentoDTO> getDepartamentosByProgramadorId(Long progId) throws SQLException {
        // Obtenemos la lista
        return (List<DepartamentoDTO>) mapper.toDTO(repository.getById(progId));
    }
}
