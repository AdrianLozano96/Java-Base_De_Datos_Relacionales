package controller;

public class Controller {
    //Este paquete estaría entre el servicio y el paquete de las clases Orientadas a Objetos.
    //Decimos como se quieren los datos llamando al servicio coge los datos y puede devolver una lista, un csv, un xml, etc.
    //Acciones y llamadas, peticiones.
    //Ejemplo obtener una lista de alumnos en xml.
    //Lanzara las excepciones en caso de que el servicio no devuelva los datos solicitados.
    /*
    // Con esto evitamos que se imprima el campo password si no queremos
    // https://www.baeldung.com/gson-exclude-fields-serialization
    ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return field.getName().startsWith("password");
        }
    };
     */
}
