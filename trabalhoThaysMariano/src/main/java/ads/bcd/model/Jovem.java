package ads.bcd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@Entity
public class Jovem {

    //Atributos
    @Id
    @NonNull
    private Integer idJovem;

    @NonNull
    private String nome;

    @NonNull
    private Date dataNascimento;

    @NonNull
    private String telefone;

    @NonNull
    private String tipoSanguineo;

//    @NonNull
//    private String alergia;

    @NonNull
    private String email;

    //Construtor
    protected Jovem(){}

    //Relacoes

    //N..1 com endereço
    @ManyToOne
    @JoinColumn(name = "idEndereco", nullable = false)

    @NonNull
    private Endereco endereco;

    //N..N Jovem responsavel
    @ManyToMany
    @JoinTable(name = "jovemResponsavel",
            joinColumns = {
            @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "idResponsavel", referencedColumnName = "idResponsavel", nullable = false)
            }
    )

    @Autowired
    private List<Responsavel> responsaveis = new ArrayList<>();

    //N..N Jovem Alergia
    @ManyToMany
    @JoinTable(name = "jovemAlergia",
            joinColumns = {
                    @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "idAlergia", referencedColumnName = "idAlergia", nullable = false)
            }
    )

    @Autowired
    private List<Alergia> alergias = new ArrayList<>();







// VER COMO FAZER MANY TO MANY EM CASO DE MAIS COLUNAS ALEM DAS CHAVES


     /* Se na tabela do relacionamento muitos-para-muitos tiver colunas além das duas
     * que fazem parte da chave, então precisará seguir outra abordagem e criar uma
     * entidade dedicada para isso. Usará as anotações OneToMany, ManyToOne,
     * Embeddable e EmbeddedId. Veja exemplo em:
    *
    * https://docs.jboss.org/hibernate/annotations/3.5/reference/en/html/entity.html#entity-mapping-association
    *
    */

//    //N..N Jovem atividade
//    @ManyToMany
//    @JoinTable(name = "Participacao",
//            joinColumns = {
//                    @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "idAtividade", referencedColumnName = "idAtividade", nullable = false)
//            }
//    )
//
//    @Autowired
//    private List<Atividade> atividades = new ArrayList<>();

}
