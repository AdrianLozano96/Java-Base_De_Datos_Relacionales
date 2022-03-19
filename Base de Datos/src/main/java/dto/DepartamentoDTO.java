package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.*;
import model.Departamento;
import model.Programador;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DepartamentoDTO {
    // Exposé expone solo los campso que queramos en el JSON
    private long id;
    private String nombre;
    // @Expose
    private long presupuesto;
    private Programador jefe;
    private List<Programador> programadores;

    // TODOs Bidireccionalidad
    // Lista de post que tiene asociado. Por ahora suprimo la bidireccionalidad
    // private final Set<Post> posts = new HashSet<>();
    // From/To JSON
    public static DepartamentoDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, DepartamentoDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }
}

/*
private Long id;
    private String texto;
    private LocalDateTime fechaPublicacion;
    // Autor que la realiza
            //private User user;
    // Post al que pertenece
            //private Post post;
    // Para mejorar las relaciones y como es un dTO vamos a poner los ids
    private Long user_id, post_id;
 */
