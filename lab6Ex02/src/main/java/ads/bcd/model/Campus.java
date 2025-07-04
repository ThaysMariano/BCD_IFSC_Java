package ads.bcd.model;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
/**
 * POJO para representar a entidade Campus.
 *
 * As anotações Getter, Setter, EqualsAndHashCode, toString e NoArgsConstructor
 * são da biblioteca lombok que facilita a criação do POJO
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = {"cursos"})
@RequiredArgsConstructor
@Entity
public class Campus implements Serializable {
    // JPA exige construtor padrão
    protected Campus() {}
    /**
     * A anotação @Id indica que o atributo é a chave primária da entidade.
     * A anotação @GeneratedValue define a estratégia de geração automática.
     * Aqui usamos IDENTITY, o que significa que o valor será gerado no banco (MySQL AUTO_INCREMENT).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCampus;
    /**
     * A anotação @Column define restrições para a coluna no banco.
     * O atributo nome é obrigatório (nullable = false).
     * A anotação @NonNull é do Lombok e marca esse campo como obrigatório
     * no construtor gerado pela anotação @RequiredArgsConstructor.
     */
    @Column(nullable = false)
    @NonNull
    private String nome;
    /**
     * A sigla do campus deve ser única e não nula.
     */
    @Column(nullable = false, unique = true)
    @NonNull
    private String sigla;
    @NonNull
    private String endereco;
    @NonNull
    private String cidade;
    /**
     * Relacionamento 1:N com a entidade Curso.
     * Um campus pode ter vários cursos.
     * A anotação mappedBy indica que o lado dono da associação é o atributo "campus" da classe Curso.
     * CascadeType.ALL garante que persistência, atualização e remoção se apliquem também aos cursos.
     */
    @OneToMany(mappedBy = "campus", cascade = {CascadeType.ALL})
    private Set<Curso> cursos = new HashSet<>();
}
