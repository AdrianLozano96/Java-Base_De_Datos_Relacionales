package controller;

public class ControllerClass {

    //Para los Controllers
    //Por cada clase
/*
    public class CategoryController {
        private static CategoryController controller = null;

        // Mi Servicio unido al repositorio
        private final CategoryService categoryService;

        // Implementamos nuestro Singleton para el controlador
        private CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }

        public static CategoryController getInstance() {
            if (controller == null) {
                controller = new CategoryController(new CategoryService(new CategoryRepository()));
            }
            return controller;
        }


        // Ejemplo de operaciones
        // Usamos DTO para implementar este patrón en represantación y trasporte de la información
//    public List<CategoryDTO> getAllCategories() {
//        return categoryService.getAllCategories();
//    }


        public String getAllCategoriesJSON() {	//hacer esto con byid, update, delate e inserts solo cambia el nombre el cuerpo es el mismo
            try {
                // Vamos a devolver el JSON de las categorías
                final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                return prettyGson.toJson(categoryService.getAllCategories());
            } catch (SQLException e) {
                System.err.println("Error CategoryController en getAllCategories: " + e.getMessage());
                return "Error CategoryController en getAllCategories: " + e.getMessage();
            }
        }

 */


}
