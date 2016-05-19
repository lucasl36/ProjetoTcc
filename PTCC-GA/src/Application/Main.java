package Application;

import Core.Domain.Disciplina;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import Core.Components.Avaliacao;
import Core.Components.Mutacao;
import Core.Components.Criacao;
import Core.Components.Reproducao;
import Core.Services.TesteService;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Main
{
    public static void main(String[] args) {
        
        TesteService testeSrv = new TesteService();
        Criacao popSrv = new Criacao();
        Avaliacao avaSrv = new Avaliacao();
        Reproducao repSrv = new Reproducao();
        Mutacao mutSrv = new Mutacao();
        
        ArrayList<Professor> professores = testeSrv.inicializarProfessoresPadroes();
        ArrayList<Disciplina> disciplinas = testeSrv.inicializarDisciplinasPadroes();
        ArrayList<Materia> materias = testeSrv.inicializarMateriasPadroes(professores, disciplinas);
        
        Populacao populacao = popSrv.inicializarPopulacao(Criacao.defaultIndividuosPopulacao, materias);
        populacao = avaSrv.avaliarIndividuos(populacao, professores);
        Populacao novaPopulacao = repSrv.gerarNovaPopulacao(populacao);
        mutSrv.mutarPopulacao(novaPopulacao);
        testeSrv.exibirPopulacao(novaPopulacao);
    }
}
