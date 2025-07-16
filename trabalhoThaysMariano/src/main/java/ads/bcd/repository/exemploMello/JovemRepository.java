package ads.bcd.repository.exemploMello;


import ads.bcd.exemplosMello.Employee;
import ads.bcd.model.Jovem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JovemRepository extends CrudRepository<Employee, Integer> {

    //Dados biográficos de um determinado jovem;
    @Query("SELECT J FROM Jovem J")
    List<Jovem> listarDadosDoJovem(Jovem J);


    //Deixar aqui apenas jovem, o que for join colocar na aplicacao

    //Jovens que possuem uma determinada especialidade;




    //As especialidades e insígnias de interesse especial que um determinado jovem possui;




    //Requisitos já cumpridos por um determinado jovem para uma determinada especialidade;




    //Jovens que possuem todos os requisitos para obter o Cruzeiro do Sul.



}
