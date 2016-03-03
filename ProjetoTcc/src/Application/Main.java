package Application;

import Core.Domain.Disciplina;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import Core.Service.PopulacaoService;
import Core.Service.TesteService;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Main
{
    public static void main(String[] args) {
        
        TesteService testeSrv = new TesteService();
        PopulacaoService popSrv = new PopulacaoService();
        
        ArrayList<Professor> professores = testeSrv.inicializarProfessoresPadroes();
        ArrayList<Disciplina> disciplinas = testeSrv.inicializarDisciplinasPadroes();
        ArrayList<Materia> materias = testeSrv.inicializarMateriasPadroes(professores, disciplinas);
        
        Populacao novaPopulacao = popSrv.inicializarPopulacao(PopulacaoService.defaultIndividuosPopulacao, materias);
    }
}
