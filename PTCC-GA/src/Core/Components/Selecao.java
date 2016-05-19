package Core.Components;

import Core.Domain.Horario;
import Core.Domain.Populacao;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Selecao
{

    /* Valor de Inversão */
    public static final Integer defaultValorInversao = 1000;

    public Horario[] selecionarIndividuos(Populacao populacao)
    {
        this.inverterNotaPopulacao(populacao);
        Integer notaTotal = this.somarNotasPopulacao(populacao.getIndividuos());
        int i, j;
        do
        {
            i = rodarRoleta(populacao.getIndividuos(), notaTotal);
            j = rodarRoleta(populacao.getIndividuos(), notaTotal);
        } while (i == j);
        Horario[] individuosSelecionados =
        {
            populacao.getIndividuos().get(i), populacao.getIndividuos().get(j)
        };
        this.inverterNotaPopulacao(populacao);
        return individuosSelecionados;
    }

    private Integer rodarRoleta(ArrayList<Horario> individuos, Integer notaTotal)
    {
        Integer notaEscolhida = (int) (Math.random() * notaTotal);
        Integer notaParcial = 0;
        int i = 0;
        while (notaParcial < notaEscolhida && i < individuos.size() - 1)
        {
            notaParcial += individuos.get(i).getNota();
            i++;
        }
        return i;
    }

    private void inverterNotaPopulacao(Populacao populacao)
    {
        for (Horario h : populacao.getIndividuos())
        {
            h.setNota(defaultValorInversao - h.getNota());
        }
    }

    private Integer somarNotasPopulacao(ArrayList<Horario> individuos)
    {
        Integer notaTotal = 0;
        for (Horario h : individuos)
        {
            notaTotal += h.getNota();
        }
        return notaTotal;
    }

}
