package ads.bcd.repository.exemploMello;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import ads.bcd.exemplosMello.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {

    // Lista de cursos que ocorreram em um determinado ano
    // Fazendo de parâmetro nomeados.
    @Query("SELECT c FROM Course c WHERE YEAR(c.cdate) = :ano")
    List<Course> findByCursosRealizadosEmUmAno(@Param("ano") int ano);

}