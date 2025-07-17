package ads.bcd;

import java.util.InputMismatchException;
import java.util.Scanner;

import ads.bcd.repository.exemploMello.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * A anotação abaixo é para indicar que essa é uma aplicação SpringBoot
 */
@SpringBootApplication
public class ExemploJpaApplication {

	// O uso de Logger é uma boa prática para registrar informações de depuração,
	// erro, etc.
	private static final Logger log = LoggerFactory.getLogger(ExemploJpaApplication.class);

	//jovem
	@Autowired
	private JovemRepository jovemRepository;

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
			try (Scanner scan = new Scanner(System.in)) {
				log.info("Iniciando aplicação...");



				int opcao = -1;
				do {
					System.out.println("\n--- MENU ---");
					System.out.println("1 - Listar dados de um jovem");
					System.out.println("0 - Sair");
					System.out.print("Digite uma opção: ");



					try {
						opcao = Integer.parseInt(scan.nextLine());
						switch (opcao) {
							case 1: // Listar o jovem por nome
								System.out.print("Digite o nome do jovem: ");
								String nome = scan.nextLine();

								jovemRepository.listarDadosDoJovem(nome);
								break;

							case 0:
								System.out.println("Saindo...");
								break;

							default:
								System.out.println("Você inseriu uma opção inválida");
						}
					} catch (InputMismatchException | NumberFormatException e) {
						System.err.println("Entrada inválida. Por favor, insira um número.");
					}
				} while (opcao != 0);

			} catch (InputMismatchException e) {

				log.error("ERRO: "+ e);
			}
		};



	}










}
