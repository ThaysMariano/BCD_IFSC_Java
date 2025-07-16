package ads.bcd;

import java.util.List;
import java.util.Optional;

import ads.bcd.model.Jovem;
import ads.bcd.repository.exemploMello.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ads.bcd.exemplosMello.Employee;
import ads.bcd.exemplosMello.JobHistory;

/**
 * A anotação abaixo é para indicar que essa é uma aplicação SpringBoot
 */
@SpringBootApplication
public class ExemploJpaApplication {

	// O uso de Logger é uma boa prática para registrar informações de depuração,
	// erro, etc.
	private static final Logger log = LoggerFactory.getLogger(ExemploJpaApplication.class);
	@Autowired
	ResponsavelRepository responsavelRepository;
	@Autowired
	JovemRepository jovemRepository;


	public static void main(String[] args) {
		// Método run para executar a aplicação. É necessário passar como parâmetro uma
		// classe que tenha a anotação de aplicação e, neste caso, que tenha uma Bean para executar
		// um cliente em linha de comando
		SpringApplication.run(ExemploJpaApplication.class, args);
		log.info("Aplicação finalizada");
	}

	// Este método será invocado assim que a aplicação for executada.
	@Bean
	public CommandLineRunner demo() {
		return (args) -> {
			try {
				log.info("Iniciando aplicação");

				// Listando todos os jovens
				for (var element : jovemRepository.findAll()) {
					System.out.println(element);
				}

				System.out.println("Listando o jovem selecionado (por nome)");
				jovemRepository.listarDadosDoJovem("thays");

//				System.out.println("Lista de aniversariamente do mês de março");
//				// Listando todos os funcionários que fazem aniversário em março
//				employeeRepository.findByAniversariantesNoMes(3).forEach(System.out::println);
//
//				System.out.println("Cursos que aconteceram no ano de 1989");
//				// Listando os nomes dos cursos que aconteceram em um ano
//				courseRepository.findByCursosRealizadosEmUmAno(1989).forEach(curso -> {
//					System.out.println("Nome do curso: " + curso.getCname());
//				});
//
//				Optional<Jovem> buscaJovem = jovemRepository.listarDadosDoJovem("thays");
//
//				// Se encontrou alguma entidade
//				if (buscaJovem.isPresent()) {
//					Employee jones = buscaJovem.get();
//
//					List<JobHistory> historicoCargos = jovemRepository.findByDeCargosNaEmpresa(jones);
//
//					System.out.println("Lista de todos os cargos assumidos pelo funcionário: " + jones.getForenames());
//
//					StringBuilder sb = new StringBuilder();
//
//					sb.append(String.format("|%-10s|%-10s|%-40s|\n", "Ingresso", "Saída", "Nome do cargo"));
//					sb.append("----------------------------------------------------------------\n");
//
//					historicoCargos.forEach(cargo -> {
//						sb.append(String.format("|%-10s|%-10s|%-40s|\n", cargo.getStartdate(), cargo.getEnddate(),
//								cargo.getPosition()));
//					});
//					System.out.println(sb);
//
//				}

			} catch (Exception e) {
				log.error(e.toString());
			}
		};
	}
}