package Application;

import Core.Domain.Disciplina;
import Core.Domain.Horario;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import Core.Service.AvaliacaoService;
import Core.Service.MutacaoService;
import Core.Service.PopulacaoService;
import Core.Service.ReproducaoService;
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
        ReproducaoService repSrv = new ReproducaoService();
        MutacaoService mutSrv = new MutacaoService();
        
        ArrayList<Professor> professores = testeSrv.inicializarProfessoresPadroes();
        ArrayList<Disciplina> disciplinas = testeSrv.inicializarDisciplinasPadroes();
        ArrayList<Materia> materias = testeSrv.inicializarMateriasPadroes(professores, disciplinas);
        
        Populacao populacao = popSrv.inicializarPopulacao(PopulacaoService.defaultIndividuosPopulacao, materias);
        populacao = avaSrv.avaliarIndividuos(populacao, professores);
        Populacao novaPopulacao = repSrv.gerarNovaPopulacao(populacao);
        mutSrv.mutarPopulacao(novaPopulacao);
        testeSrv.exibirPopulacao(novaPopulacao);
    }
}
