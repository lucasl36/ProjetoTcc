package Application;

import Core.Domain.Disciplina;
import Core.Domain.Horario;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import Core.Service.AvaliacaoService;
import Core.Service.PopulacaoService;
import Core.Service.SelecaoService;
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
        AvaliacaoService avaSrv = new AvaliacaoService();
        SelecaoService selSrv = new SelecaoService();
        
        ArrayList<Professor> professores = testeSrv.inicializarProfessoresPadroes();
        ArrayList<Disciplina> disciplinas = testeSrv.inicializarDisciplinasPadroes();
        ArrayList<Materia> materias = testeSrv.inicializarMateriasPadroes(professores, disciplinas);
        
        Populacao novaPopulacao = popSrv.inicializarPopulacao(PopulacaoService.defaultIndividuosPopulacao, materias);
        novaPopulacao = avaSrv.avaliarIndividuos(novaPopulacao, professores);
        
    }
}
