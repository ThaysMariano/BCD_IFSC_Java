package ads.bcd.repository.exemploMello;


import ads.bcd.exemplosMello.Employee;
import ads.bcd.model.Jovem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JovemRepository extends CrudRepository<Employee, Integer> {

    //Dados biográficos de um determinado jovem;
    @Query("SELECT J.nome FROM Jovem J JOIN Endereco E ON J.idEndereco=E.idEndereco WHERE J.nome = : nome")
    List<Jovem> listarDadosDoJovem(@Param("nome") String nome);


    //Deixar aqui apenas jovem, o que for join colocar na aplicacao
    //Jovens que possuem uma determinada especialidade;
    @Query("SELECT E.nome, J.nome  FROM Jovem J JOIN RequisitoCumpridoEspecialidade ReqCumpEsp ON J.idJovem = ReqCumpEsp.idJovem JOIN RequisitoEspecialidade reqEsp ON ReqCumpEsp.idRequisitoEspecialidade = reqEsp.idRequisitoEspecialidade JOIN Especialidade E ON E.idEspecialidade = reqEsp.idEspecialidade GROUP BY J.idJovem, e.idEspecialidade HAVING COUNT(*) = E.numRequisitos AND E.nome = :nomeEspecialidade" )
    List<Jovem> listarJovensPorEspecialidade(@Param("nomeEspecialidade") String nome);


    //As especialidades e insígnias de interesse especial que um determinado jovem possui;




    //Requisitos já cumpridos por um determinado jovem para uma determinada especialidade;




    //Jovens que possuem todos os requisitos para obter o Cruzeiro do Sul.


    //selecionar nivel das especialidades




}
