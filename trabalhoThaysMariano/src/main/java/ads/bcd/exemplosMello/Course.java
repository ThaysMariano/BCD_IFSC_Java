package ads.bcd.exemplosMello;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString(exclude = { "employees" })
@Entity
public class Course {

    @Id
    @NonNull
    private Integer courseno;

    @NonNull
    private String cname;
    @NonNull
    private Date cdate;

    /**
     * A anotação ManyToMany ficará responsável por criar ou mapear a tabela no
     * banco de dados. A propriedade mappedBy é usada para indicar a entidade que é
     * a proprietária do relacionamento bidirecional. Neste exemplo é a entidade
     * Employee.
     */
    @ManyToMany(mappedBy = "courses")
    private Set<Employee> employees = new HashSet<>();

    protected Course(){}
}