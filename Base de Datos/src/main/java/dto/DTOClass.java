package dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DTOClass {
    //Para los DTOs
   // Son las clases objetos no las clases tabla
    //Poner:

    private Long id;
    private String texto;
    private LocalDateTime fechaPublicacion;
    // Autor que la realiza
    //private User user;
    // Post al que pertenece
   // private Post post;
    // Para mejorar las relaciones y como es un dTO vamos a poner los ids
    private Long user_id, post_id;

    // TODO Bidireccionalidad
    // Lista de post que tiene asociado. Por ahora suprimo la bidireccionalidad
    // private final Set<Post> posts = new HashSet<>();


// From/To JSON
    /*
    public static NombreClaseDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, NombreClaseDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }

     */
}
