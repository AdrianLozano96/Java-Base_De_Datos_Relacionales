package repository;

import model.Departamento;
import model.Programador;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ProgramadorRepository test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProgramadorRepositoryTest {
    List<String> lenguages1 = Arrays.asList("java","javaScript");
    List<String> lenguages2 = Arrays.asList("java","c");
    Programador progTest = new Programador("Jhon", 10,11000, lenguages1, 1);
    private ProgramadorRepository repositoryTest = ProgramadorRepository.getInstance();

    @Test
    @Order(1)
    void insert() {
        Optional<Programador> prog = repositoryTest.insert(progTest);
        Assertions.assertEquals(Optional.of(progTest),prog);
    }

    @Test
    @Order(2)
    void selectAll() {
        Optional<List<Programador>> prog = repositoryTest.selectAll();
        Assertions.assertEquals(1,prog.stream().count());
    }

    @Test
    @Order(3)
    void selectById() {
        //Optional<Departamento> dep = repositoryTest.selectById(testObject.getId());
        Programador progTest2 = new Programador(1, "Paco", 5, 10000.0, lenguages2, 1);
        Optional<Programador> prog = repositoryTest.selectById(1);
        Assertions.assertEquals(Optional.of(progTest2),prog);
    }

    @Test
    @Order(4)
    void update() {
        Programador p = new Programador(3,"Frank", 10,11000, lenguages1, 1);
        Optional<Programador> prog = repositoryTest.update(p);
        Assertions.assertEquals(Optional.of(p), prog);
    }

    @Test
    @Order(5)
    void delete() {
        String ans = repositoryTest.deletes(progTest);
        Assertions.assertEquals(progTest.toString(),ans);
    }
}