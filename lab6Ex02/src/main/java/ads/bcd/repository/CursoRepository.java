package ads.bcd.repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ads.bcd.model.Campus;
import ads.bcd.model.Curso;
@RepositoryRestResource(collectionResourceRel = "cursos", path = "cursos")
public interface CursoRepository extends PagingAndSortingRepository<Curso, Long>, CrudRepository<Curso, Long>
{
    Page<Curso> findByNome(String nomeDoCurso, Pageable pageable);
    Page<Curso> findDistinctByNomeIgnoreCase(String nomeDoCurso, Pageable pageable);
    Page<Curso> findByNomeContainingOrderByNome(String nomeDoCurso, Pageable pageable);
    int countByCampus(Campus campus);
    List<Curso> findByCampusAndCargaHoraria(Campus campus, int cargaHoraria);
    List<Curso> findByCargaHorariaIsNull();
    Page<Curso> findByNomeStartingWith(String prefixo, Pageable pageable);
    Page<Curso> findByNomeEndingWith(String sufixo, Pageable pageable);
    Page<Curso> findByNomeContaining(String padrao, Pageable pageable);
    Page<Curso> findByCargaHorariaGreaterThan(int valor, Pageable pageable);
    Page<Curso> findByCargaHorariaBetween(int inicio, int fim, Pageable pageable);
    void deleteByNome(String nome);
}