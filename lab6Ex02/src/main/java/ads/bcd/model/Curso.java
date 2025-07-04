package ads.bcd.model;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;
/**
 * POJO para representar a entidade Curso.
 *
 * É necessário que a classe tenha getter/setter, construtores, toString, hashCode e equals.
 * O Lombok gera tudo isso automaticamente.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "Curso")
public class Curso implements Serializable {
    // Construtor padrão exigido pelo JPA
    protected Curso() {}
    /**
     * A anotação @Id define a chave primária da entidade.
     * @GeneratedValue com estratégia IDENTITY permite que o valor seja gerado automaticamente
     * no banco de dados (AUTO_INCREMENT no MySQL).
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCurso;
    /**
     * Nome do curso (obrigatório).
     */
    @NonNull
    private String nome;
    /**
     * Carga horária do curso (obrigatória).
     */
    @NonNull
    private int cargaHoraria;
    /**
     * Relacionamento muitos-para-um com a entidade Campus.
     *
     * Muitos cursos podem estar associados a um único campus.
     * A anotação @JoinColumn define o nome da chave estrangeira na tabela Curso.
     */
    @ManyToOne
    @JoinColumn(name = "idCampus", nullable = false)
    @NonNull
    private Campus campus;
}