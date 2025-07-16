package ads.bcd.repository.exemploMello;


import ads.bcd.exemplosMello.Employee;
import ads.bcd.model.Jovem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JovemRepository extends CrudRepository<Employee, Integer> {

    //Dados biográficos de um determinado jovem;
    @Query("SELECT '*' FROM Jovem J WHERE J.nome = : nome")
    List<Jovem> listarDadosDoJovem(@Param("nome") String nome);


    //Deixar aqui apenas jovem, o que for join colocar na aplicacao
    //Jovens que possuem uma determinada especialidade;
    @Query("SELECT '*' FROM Jovem J JOIN Especialidade E WHERE idJovem=idJovem")



    //As especialidades e insígnias de interesse especial que um determinado jovem possui;




    //Requisitos já cumpridos por um determinado jovem para uma determinada especialidade;




    //Jovens que possuem todos os requisitos para obter o Cruzeiro do Sul.



}
