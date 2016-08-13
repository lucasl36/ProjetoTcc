package Application;

import Core.Domain.Disciplina;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import Core.Components.Avaliacao;
import Core.Components.Mutacao;
import Core.Components.Criacao;
import Core.Components.Geracao;
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
        
        ArrayList<Professor> professores = testeSrv.inicializarProfessoresPadroes();
        ArrayList<Disciplina> disciplinas = testeSrv.inicializarDisciplinasPadroes();
        ArrayList<Materia> materias = testeSrv.inicializarMateriasPadroes(professores, disciplinas);
                
        Criacao criacao = new Criacao();
        Populacao populacaoInicial = criacao.inicializarPopulacao(Criacao.defaultIndividuosPopulacao, materias);
        
        Geracao geracao = new Geracao();
        Populacao populacaoFinal = geracao.executarProcessoGeracao(populacaoInicial, professores);
        TesteService.exibirMelhorIndividuoPopulacao(populacaoFinal, materias);
        
//        TesteService.exibirPopulacao(populacaoFinal);
    }
}
