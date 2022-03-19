package service;

import com.google.gson.JsonElement;
import dto.DepartamentoDTO;
import lombok.Data;
import mapper.DepartamentoMapper;
import model.Departamento;
import repository.DepartamentoRepository;

import java.sql.SQLException;
import java.util.List;

@Data
public class DepartamentoService{
    private DepartamentoRepository departamentoRepository;
    DepartamentoMapper mapper = new DepartamentoMapper();

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public static JsonElement getAllDepartamento() {
        return null;
    }




    public List<DepartamentoDTO> getAllDepartamentos() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public DepartamentoDTO getDepartamentoById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public DepartamentoDTO postUser(UserDTO userDTO) throws SQLException {
        // Ciframos antes el password
        userDTO.setPassword(Cifrador.getInstance().SHA256(userDTO.getPassword()));
        User res = this.save(mapper.fromDTO(userDTO));
        return mapper.toDTO(res);
    }



    public DepartamentoDTO updateDepartamento(DepartamentoDTO DepartamentoDTO) throws SQLException {
        Departamento res = this.update(mapper.fromDTO(DepartamentoDTO));
        return mapper.toDTO(res);
    }



    public DepartamentoDTO deleteDepartamento(DepartamentoDTO userDTO) throws SQLException {
        Departamento res = this.delete(mapper.fromDTO(userDTO));
        return mapper.toDTO(res);
    }

    public Departamento getDepartamentoByMail(String userMail) throws SQLException {
        return repository.getByMail(userMail);
    }

 */





}


/*
//public class DepartamentoService extends BaseService<Departamento, Long, DepartamentoRepository>{
public class DepartamentoService{
    DepartamentoMapper mapper = new DepartamentoMapper();
    // Inyección de dependencias en el constructor. El servicio necesita este repositorio

    private DepartamentoRepository departamentoRepository;

    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        super();
        this.departamentoRepository = departamentoRepository;
    }


    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public static JsonElement getAllDepartamento() {
        return null;
    }



    // Inyección de dependencias en el constructor. El servicio necesita este repositorio


    // Otras operaciones o especificaciones para CRUD
    // O podíamos mapear el nombre
    // O simplemente ocultar las que no queramos usar en niveles superiores
    // Utilizamos los DTO para par datos del servico al controlador que los presenta


    public List<DepartamentoDTO> getAllCategories() throws SQLException {
        return mapper.toDTO(this.findAll());
    }



    public DepartamentoDTO getCategoryById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public DepartamentoDTO postCategory(DepartamentoDTO DepartamentoDTO) throws SQLException {
        Departamento res = this.save(mapper.fromDTO(DepartamentoDTO));
        return mapper.toDTO(res);
    }

    public DepartamentoDTO updateCategory(DepartamentoDTO DepartamentoDTO) throws SQLException {
        Departamento res = this.update(mapper.fromDTO(DepartamentoDTO));
        return mapper.toDTO(res);
    }

    public DepartamentoDTO deleteCategory(DepartamentoDTO DepartamentoDTO) throws SQLException {
        Departamento res = this.delete(mapper.fromDTO(DepartamentoDTO));
        return mapper.toDTO(res);
    }

 */





//}
