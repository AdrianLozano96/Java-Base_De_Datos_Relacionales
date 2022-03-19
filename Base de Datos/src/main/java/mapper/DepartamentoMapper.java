package mapper;

import dto.DepartamentoDTO;
import model.Departamento;
import model.Programador;
import repository.ProgramadorRepository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DepartamentoMapper extends BaseMapper<Departamento, DepartamentoDTO> {
    @Override
    public Departamento fromDTO(DepartamentoDTO item) {
        return Departamento.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                //.jefe (item.getJefe())
                .build();
    }

    //Para pasar de dao
    @Override
    public DepartamentoDTO toDTO(Departamento item) {
        return DepartamentoDTO.builder()
                .id(item.getId())
                .nombre(item.getNombre())
                .presupuesto(item.getPresupuesto())
                .jefe(getJefe(item.getJefe()))
                //.programadores(getProgramadores(item.getProgramadores()))
                .build();

    }

    private Programador getJefe(long id){
        return ProgramadorRepository.getInstance().getProgramadoresList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private List<Programador> getProgramadores(List<String> programadores){
        return ProgramadorRepository.getInstance().getProgramadoresList();
    }

}



/*
    private List<Proyecto> getTerminados(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id) && x.isFinalizado()).collect(Collectors.toList());
    }

    private List<Proyecto> getEnDesarrollo(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id) && x.isFinalizado()==false).collect(Collectors.toList());
    }

      private Repositorio getRepo(String id){
        return RepositorioRepository.getInstance().getRepositoriosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Proyecto getProject(String id){
        return ProyectoRepository.getInstance().getProyectosList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Programador getProgramer(String id){
        return ProgramadorRepository.getInstance().getProgramadoresList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }

    private Issue getIssue(String id){
        return IssueRepository.getInstance().getIssuesList().stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);
    }
 */
/*
 public Post fromDTO(PostDTO item) {
        Post post = new Post();
        if (item.getId() != null) {
            post.setId(item.getId());
        }
        post.setTitulo(item.getTitulo());
        post.setUrl(item.getUrl());
        post.setContenido(item.getContenido());
        post.setFechaPublicacion(item.getFechaPublicacion());
        post.setUser(item.getUser());
        post.setCategory(item.getCategory());
        return post;

    }

    @Override
    public PostDTO toDTO(Post item) {
        return PostDTO.builder()
                .id(item.getId())
                .titulo(item.getTitulo())
                .url(item.getUrl())
                .contenido(item.getContenido())
                .fechaPublicacion(item.getFechaPublicacion())
                .user(item.getUser())
                .category(item.getCategory())
                .comments((List<Comment>) item.getComments())
                .build();
    }
 */
