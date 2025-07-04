package ads.bcd;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ads.bcd.model.Campus;
import ads.bcd.model.Curso;
import ads.bcd.repository.CampusRepository;
import ads.bcd.repository.CursoRepository;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@SpringBootApplication
public class ExemploJpaApplication {
    @Autowired
    CampusRepository campusRepository;
    @Autowired
    CursoRepository cursoRepository;
    public static void main(String[] args) {
        SpringApplication.run(ExemploJpaApplication.class, args);
        log.info("Aplicação finalizada");
    }
    private void povoando() throws Exception {
        Campus campusSje = new Campus("São José", "SJE", "Rua José Lino, 608", "São José");
        Campus campusFln = new Campus("Florianópolis", "FLN", "Avenida Mauro Ramos, 100", "Florianópolis");
        campusRepository.save(campusSje);
        campusRepository.save(campusFln);
        cursoRepository.save(new Curso("Engenharia de Telecomunicações", 4300, campusSje));
        cursoRepository.save(new Curso("Engenharia de Computação", 4200, campusSje));
        cursoRepository.save(new Curso("Engenharia Elétrica", 4500, campusFln));
    }
    private void listandoRegistros() throws Exception {
        System.out.println("--------------- Campus -------------------------");
        for (var element : campusRepository.findAll()) {
            System.out.println(element);
        }
        System.out.println("--------------- Cursos ------------------------");
        cursoRepository.findAll().forEach(System.out::println);
        System.out.println("---------- Cursos paginados e ordenados ---------");
        Pageable pagina = PageRequest.of(0, 20, Sort.by("nome").ascending());
        cursoRepository.findByCargaHorariaGreaterThan(4000, pagina).forEach(System.out::println);
        System.out.println("--------------- Total de cursos ---------------");
        Optional<Campus> buscaCampus = campusRepository.findBySigla("SJE");
        if (buscaCampus.isPresent()) {
            int totalCursosSje = cursoRepository.countByCampus(buscaCampus.get());
            System.out.println("Total de cursos no campus São José: " + totalCursosSje);
        }
    }
    @Bean
    public CommandLineRunner demoUmParaMuitos() {
        return (args) -> {
            try {
                log.info("Iniciando aplicação");
                this.povoando();
                this.listandoRegistros();
            } catch (Exception e) {
                log.error(e.toString());
            }
        };
    }
}
