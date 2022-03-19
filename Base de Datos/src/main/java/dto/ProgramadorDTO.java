package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.*;
import model.Departamento;
import model.Programador;

import java.util.List;

@Data
@Builder
public class ProgramadorDTO {

    private long id;
    private String nombre;
    private int experiencia;
    private double salario;
    private Departamento departamento;
    private List<String> lenguajes;


    // TODOs Bidireccionalidad
    // Lista de post que tiene asociado. Por ahora suprimo la bidireccionalidad
    // private final Set<Post> posts = new HashSet<>();
// From/To JSON
    public static ProgramadorDTO fromJSON(String json) {
        final Gson gson = new Gson();
        return gson.fromJson(json, ProgramadorDTO.class);
    }

    public String toJSON() {
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        return prettyGson.toJson(this);
    }
}
