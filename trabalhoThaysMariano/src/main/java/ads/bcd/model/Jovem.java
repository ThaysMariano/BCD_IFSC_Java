package ads.bcd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @NonNull
    private String email;

    //Construtor
    protected Jovem() {
    }

    //Relacoes

    //N..1 com endereço
    @ManyToOne
    @JoinColumn(name = "idEndereco", nullable = false)
    @NonNull
    private Endereco endereco;

    // 1 .. N com Participacap
    @OneToMany(mappedBy = "Jovem")
    private Set<Participacao> participacoes = new HashSet<>();

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

    // 1 .. N reqCumpEspecialidade
    @OneToMany(mappedBy = "Jovem")
    private Set<RequisitoCumpridoEspecialidade> requisitosCumpridosEspecialidade = new HashSet<>();

    // 1 .. N reqCumpProgressao
    @OneToMany(mappedBy = "Jovem")
    private Set<RequisitoCumpridoProgressao> requisitosCumpridosProgressao = new HashSet<>();

    // 1 .. N reqCumpInsignia
    @OneToMany(mappedBy = "Jovem")
    private Set<RequisitoCumpridoInsignia requisitosCumpridosInsignia = new HashSet<>();




//TODO ELE FAZ ESSA CONEXAO OU FICA SO NO REQ CUMPRIDO

//    //N..N Jovem Especialidade
//    @ManyToMany
//    @JoinTable(name = "JovemEspecialidade",
//            joinColumns = {
//                    @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "idEspecialidade", referencedColumnName = "idEspecialidade", nullable = false)
//            }
//    )
//    @Autowired
//    private List<Especialidade> especialidades = new ArrayList<>();
//
//    //N..N Jovem Progressao
//    @ManyToMany
//    @JoinTable(name = "JovemProgressao",
//            joinColumns = {
//                    @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "idProgressao", referencedColumnName = "idProgressao", nullable = false)
//            }
//    )
//    @Autowired
//    private List<Progressao> progressoes = new ArrayList<>();
//
//    //N..N Jovem Insignia
//    @ManyToMany
//    @JoinTable(name = "JovemInsignia",
//            joinColumns = {
//                    @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "idInsignia", referencedColumnName = "idInsignia", nullable = false)
//            }
//    )
//    @Autowired
//    private List<Insignia> insignias = new ArrayList<>();


}




