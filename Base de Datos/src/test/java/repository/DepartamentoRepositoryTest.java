package repository;

import model.Departamento;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.Optional;

@DisplayName("DepartamentoRepository test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepartamentoRepositoryTest {

    private Departamento depTest = new Departamento("Empresa", 768789, 2);
    private DepartamentoRepository repositoryTest = DepartamentoRepository.getInstance();
/*
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

 */

    @Test
    @Order(1)
    void insert() {
        Optional<Departamento> dep = repositoryTest.insert(depTest);
        Assertions.assertEquals(Optional.of(depTest),dep);
    }

    @Test
    @Order(2)
    void selectAll() {
        Optional<List<Departamento>> dep = repositoryTest.selectAll();
        Assertions.assertEquals(3,dep.stream().count());
    }

    @Test
    @Order(3)
    void selectById() {
        //Optional<Departamento> dep = repositoryTest.selectById(testObject.getId());
        Optional<Departamento> dep = repositoryTest.selectById(4);
        Assertions.assertEquals(Optional.of(depTest),dep);
    }

    @Test
    @Order(4)
    void update() {
        Departamento dep = new Departamento(5,"Investigacion", 7887, 1);
        Optional<Departamento> updep = repositoryTest.update(dep);
        Assertions.assertEquals(Optional.of(dep.getId()),updep);
    }

    @Test
    @Order(5)
    void delete() {
        String ans = repositoryTest.deletes(depTest);
        Assertions.assertEquals(depTest.toString(),ans);
    }
}