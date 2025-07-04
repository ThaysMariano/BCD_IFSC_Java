package ads.bcd.repository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ads.bcd.model.Campus;
@RepositoryRestResource(collectionResourceRel = "campus", path = "campus")
public interface CampusRepository extends CrudRepository<Campus, Long> {
    // Consulta personalizada: encontrar um campus pela sigla
    Optional<Campus> findBySigla(String sigla);
    // Consulta personalizada: listar todos os campus com determinado nome
    List<Campus> findByNome(String nome);
}