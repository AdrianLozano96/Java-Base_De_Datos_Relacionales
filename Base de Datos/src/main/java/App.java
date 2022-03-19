import model.Departamento;
import model.Programador;
import repository.DepartamentoRepository;
import repository.ProgramadorRepository;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * CRUD base de datos
 *
 */
public class App
{
    public static void main( String[] args ) throws SQLException {

        System.out.println( "Consultas SQL" );
        ProgramadorRepository progRepo = ProgramadorRepository.getInstance();
        DepartamentoRepository depRepo = DepartamentoRepository.getInstance();

        //SELECT *
        System.out.println("Obteniendo Programadores");
        Optional<List<Programador>> programadores = progRepo.selectAll();
        programadores.ifPresent(programadors -> programadors.forEach(System.out::println));
        System.out.println("Obteniendo Departamentos");
        Optional<List<Departamento>> departamentos = depRepo.selectAll();
        departamentos.ifPresent(depart -> depart.forEach(System.out::println));


        //SELECT * FROM  WHERE ID = ?
        System.out.println("\nObteniendo Programador con ID");
        Optional<Programador>programador = progRepo.selectById(1);
        programador.ifPresent(System.out::println);
        System.out.println("Obteniendo Departamento con ID");
        Optional<Departamento>departamento = depRepo.selectById(1);
        departamento.ifPresent(System.out::println);

/*
        //LISTAS LENGUAJES
        List<String>lenguages1 = Arrays.asList("java","javaScript");
        List<String>lenguages2 = Arrays.asList("php", "html", "css");
        List<String>lenguages3 = Arrays.asList("c#","c++");


        //INSERT
        Programador prog = new Programador("Pedro", 7,1000, lenguages1, 1);
        System.out.println("\nInsertando un nuevo Programador");
        //Optional<Programador> proga = progRepo.insert(prog);
        //proga.ifPresent(System.out::println);
        Departamento dep = new Departamento("Fabrica",50000,2);
        System.out.println("Insertando un nuevo Departamento");
        //Optional<Departamento> dept = depRepo.insert(dep);
        //dept.ifPresent(System.out::println);

        //UPDATE
        Programador programadorUpdate = new Programador(2,"Manu", 7,1100, lenguages2, 1);
        //Optional<Programador> prograUpdate = progRepo.update(programadorUpdate);
        Departamento departamentoUpdate = new Departamento (2,"Producción", 55000, 2);
        //Optional<Departamento> departUpdate = depRepo.update(departamentoUpdate);

        //DELETE
        //progRepo.delete(programadorUpdate);
        //depRepo.delete(departamentoUpdate);

 */


    }
}