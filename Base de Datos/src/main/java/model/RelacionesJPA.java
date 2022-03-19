package model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Set;

public class RelacionesJPA {
    /*
    @OneToOne(mappedBy = "user")
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login loginById) {
        this.login = loginById;
    }

    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "topic", cascade = CascadeType.ALL)
    // Si lo ponemos a lazy perdemos el contecto de la sesión.. a veces y te puedes saltarte una excepción
    En @OneToMany el fetch type default es Lazy, esto hace que el atributo posts no sea instanciado hasta que se haga getPosts().
       El problema es que en ese momento ya no cuentas con la Session de JPA, es decir, que la llamada a getPosts()
       debería haber ocurrido antes cuando estabas buscando los datos en el userRepository.
        cambia el comportamiento default con @OneToMany(fetch=FetchType.EAGER).
        Esto hace que friends se instancie junto con el resto de los atributos.

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user" ) // Estudiar la cascada
    public Set<Post> getPosts() {
        return posts;
    }

    // No es necesario si no queremos cambiar los post desde usuario
    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    // La Cascada
    // http://openjpa.apache.org/builds/2.4.0/apache-openjpa/docs/jpa_overview_meta_field.html#jpa_overview_meta_cascade
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.REMOVE) // cascade = CascadeType.ALL
    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

     */
}
