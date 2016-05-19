package Core.Components;

import Core.Domain.Horario;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Lucas
 */
public class Geracao {
    
    /* Quantidade de Ciclos no processo de Gerações */
    public static final Integer defaultCiclosGeracao = 50;
    /* Quantidade de individuos que continuaram na população seguinte */
    public static final Integer defaultIndividuosElite = 5;
    
    Avaliacao avaliacao;
    Selecao selecao;
    Reproducao reproducao;
    Mutacao mutacao;
    
    public Geracao()
    {
        avaliacao = new Avaliacao();
        selecao = new Selecao();
        reproducao = new Reproducao();
        mutacao = new Mutacao();
    }
    
    public Populacao executarProcessoGeracao(Populacao populacaoPais, ArrayList<Professor> professores)
    {
        populacaoPais = avaliacao.avaliarIndividuos(populacaoPais, professores);
        Populacao populacaoFilhos = reproducao.gerarNovaPopulacao(populacaoPais);
        mutacao.mutarPopulacao(populacaoFilhos);
        Populacao novaPopulacao = selecionarIndividuosMaisAptos(populacaoPais, populacaoFilhos);
        for(int i = 0; i < Geracao.defaultCiclosGeracao; i++)
        {
            Populacao antigaPopulacao = avaliacao.avaliarIndividuos(novaPopulacao, professores);
            novaPopulacao = reproducao.gerarNovaPopulacao(antigaPopulacao);
            mutacao.mutarPopulacao(novaPopulacao);
            novaPopulacao = selecionarIndividuosMaisAptos(antigaPopulacao, novaPopulacao);
        }
        return novaPopulacao;
    }
    
    public Populacao selecionarIndividuosMaisAptos(Populacao antigaPopulacao, Populacao novaPopulacao)
    {
        antigaPopulacao = ordenarPopulacao(antigaPopulacao);
        novaPopulacao = ordenarPopulacao(novaPopulacao);
        for(int i = 1; i <= Geracao.defaultIndividuosElite; i++)
        {
            novaPopulacao.getIndividuos().set((Criacao.defaultIndividuosPopulacao - i), antigaPopulacao.getIndividuos().get(i - 1));
        }
        return novaPopulacao;
    }
    
    public Populacao ordenarPopulacao(Populacao populacao)
    {
        Collections.sort(populacao.getIndividuos(), new CompararIndividuo());
        return populacao;
    }
    
    public class CompararIndividuo implements Comparator<Horario>
    {
        @Override
        public int compare(Horario h1, Horario h2)
        {
            return h1.getNota().compareTo(h2.getNota());
        }
    }

}
