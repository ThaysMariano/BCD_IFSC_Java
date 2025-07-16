package ads.bcd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.util.ArrayList;
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
    protected Jovem() {
    }

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


    //N..N Jovem Especialidade
    @ManyToMany
    @JoinTable(name = "JovemEspecialidade",
            joinColumns = {
                    @JoinColumn(name = "idJovem", referencedColumnName = "idJovem", nullable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "idEspecialidade", referencedColumnName = "idEspecialidade", nullable = false)
            }
    )
    @Autowired
    private List<Especialidade> especialidades = new ArrayList<>();


}




