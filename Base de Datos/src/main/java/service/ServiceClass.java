package service;

public class ServiceClass {
    //Se encargará de pasar la clases repository a clases orientadas a objetos usando DTO.
    //Puede haber varios DTO porEjemplo para insertar, hacer select, etc.

    /*DTO Programador
            Se pasarian tanto ProgramadorRepository como DepartamentoRepository en programador en vez de coger departamentoId
            se obtendrá el id de DepartamentoRepository.
            Con ello se obtendrán los objetos y listas.
            Realiza las busquedas y peticiones necesarias para darselas al controlador. con los datos del repositorio.
     */

    /*

Luego una por clase
public class CategoryService extends BaseService<Category, Long, CategoryRepository> {
    CategoryMapper mapper = new CategoryMapper();

    // Inyección de dependencias en el constructor. El servicio necesita este repositorio
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }

    // Otras operaciones o especificaciones para CRUD
    // O podíamos mapear el nombre
    // O simplemente ocultar las que no queramos usar en niveles superiores
    // Utilizamos los DTO para par datos del servico al controlador que los presenta
    public List<CategoryDTO> getAllCategories() throws SQLException {
        return mapper.toDTO(this.findAll());
    }

    public CategoryDTO getCategoryById(Long id) throws SQLException {
        return mapper.toDTO(this.getById(id));
    }

    public CategoryDTO postCategory(CategoryDTO categoryDTO) throws SQLException {
        Category res = this.save(mapper.fromDTO(categoryDTO));
        return mapper.toDTO(res);
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) throws SQLException {
        Category res = this.update(mapper.fromDTO(categoryDTO));
        return mapper.toDTO(res);
    }

    public CategoryDTO deleteCategory(CategoryDTO categoryDTO) throws SQLException {
        Category res = this.delete(mapper.fromDTO(categoryDTO));
        return mapper.toDTO(res);
    }

}
     */
}
