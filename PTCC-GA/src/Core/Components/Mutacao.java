package Core.Components;

import Core.Domain.Horario;
import Core.Domain.Populacao;
import Core.Services.FormatoService;

/**
 *
 * @author Lucas
 */
public class Mutacao {

    /* Chance da Mutacao Ocorrer */
    public static final double defaultPercentualMutacao = 0.4
            ;
    
    public void mutarPopulacao(Populacao populacao)
    {
        for(Horario horario : populacao.getIndividuos())
        {
            double loteria = Math.random();
            if(loteria < Mutacao.defaultPercentualMutacao)
            {
                this.mutarIndividuo(horario);
            }
        }
    }
    
    public void mutarIndividuo(Horario horario)
    {
        Integer pos = (int)(Math.random() * Criacao.defaultIndividuosPopulacao);
        String[] genes = FormatoService.converterGenesParaArray(horario.getHorario());
        String aux;
        switch(pos)
        {
            case 24:
            case 49:
            case 74:
            case 99:
            case 124:
            case 149:
                aux = genes[pos];
                genes[pos] = genes[pos-1];
                genes[pos-1] = aux;
                break;
            default:
                aux = genes[pos];
                genes[pos] = genes[pos+1];
                genes[pos+1] = aux;
                break;
        }
        horario.setHorario(FormatoService.converterGenesParaString(genes));
    }
    
}
