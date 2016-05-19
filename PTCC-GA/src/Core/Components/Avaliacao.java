package Core.Components;

import Core.Domain.Horario;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import Core.Services.FormatoService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Lucas
 */
public class Avaliacao
{

    /* Pesos dos Critérios */
    public static final Integer defaultPesoAlto = 5;
    public static final Integer defaultPesoIntermediario = 3;
    public static final Integer defaultPesoBaixo = 1;

    public Populacao avaliarIndividuos(Populacao populacao, ArrayList<Professor> professores)
    {
        Integer notaIndividuo;
        ArrayList<Horario> individuos = populacao.getIndividuos();
        for (Horario horario : individuos)
        {
            notaIndividuo = 0;
            /* Critério de Indisponibilidade */
            Integer ci = this.avaliarIndisponibilidade(horario, professores);
            /* Critério de Choques */
            Integer cc = this.avaliarChoques(horario);
            /* Critério de Horários Dispersos */
            Integer cd = this.avaliarMateriasDispersas(horario);
            /* Critério de Horários Concentrados */
            Integer ct = this.avaliarMateriasConcentradas(horario);
            notaIndividuo = ci + cc + cd + ct;
            horario.setNota(notaIndividuo);
        }
        populacao.setIndividuos(individuos);
        return populacao;
    }

    public Integer avaliarIndisponibilidade(Horario horario, ArrayList<Professor> professores)
    {
        Integer ci = 0;
        Integer cursorDisp = 0;
        String[] genes = FormatoService.converterGenesParaArray(horario.getHorario());
        for (String gene : genes)
        {
            /* Horários vagos - "0000" - não possuem professor, 
             * portanto não são avaliados 
             */
            if (!gene.equals(Criacao.defaultEmptyClass))
            {
                String[] geneSeparado = FormatoService.dividirCodigoMateria(gene);
                Professor professor = this.retornarProfessorPorCodigo(geneSeparado[0], professores);
                boolean disponivel = professor.verificarDisponibilidade(cursorDisp);
                if (!disponivel)
                {
                    ci += Avaliacao.defaultPesoAlto;
                }
            }
            cursorDisp++;
            if (Objects.equals(cursorDisp, Criacao.defaultCromossomosPeriodo))
            {
                cursorDisp = 0;
            }
        }
        return ci;
    }

    public Integer avaliarChoques(Horario horario)
    {
        Integer cc = 0;
        Integer c;
        Integer q;
        Integer fragTam = Criacao.defaultCromossomosPeriodo;
        Integer fragQtde = Criacao.defaultCromossomosTotal / Criacao.defaultCromossomosPeriodo;
        String[] genes = FormatoService.converterGenesParaArray(horario.getHorario());
        Map<String, Integer> materiasProfessor = new HashMap<>();
        for (int i = 0; i < fragTam; i++)
        {
            for (int j = 0; j < fragQtde; j++)
            {
                int pos = i + 25 * j;
                String gene = genes[pos];
                String[] geneSeparado = FormatoService.dividirCodigoMateria(gene);
                if (materiasProfessor.containsKey(geneSeparado[0]))
                {
                    materiasProfessor.replace(geneSeparado[0], (materiasProfessor.get(geneSeparado[0]) + 1));
                } else
                {
                    materiasProfessor.put(geneSeparado[0], 1);
                }
            }
            for (Map.Entry<String, Integer> entry : materiasProfessor.entrySet())
            {
                if (entry.getValue() > 1)
                {
                    c = entry.getValue();
                    q = (((c * c) - c) / 2);
                    cc += q * Avaliacao.defaultPesoAlto;
                }
            }
            materiasProfessor = new HashMap<>();
        }
        return cc;
    }

    public Integer avaliarMateriasDispersas(Horario horario)
    {
        Integer cd = 0;
        String[] genes = FormatoService.converterGenesParaArray(horario.getHorario());
        int i = 0;
        do
        {
            if (!genes[i].equals(genes[i + 1]))
            {
                if (genes[i].equals(genes[i + 2])
                        || genes[i].equals(genes[i + 3])
                        || genes[i].equals(genes[i + 4]))
                {
                    cd += Avaliacao.defaultPesoIntermediario;
                }
            }
            if (!genes[i + 1].equals(genes[i + 2]))
            {
                if (genes[i + 1].equals(genes[i + 3])
                        || genes[i + 1].equals(genes[i + 4]))
                {
                    cd += Avaliacao.defaultPesoIntermediario;
                }
            }
            if (!genes[i + 2].equals(genes[i + 3]))
            {
                if (genes[i + 2].equals(genes[i + 4]))
                {
                    cd += Avaliacao.defaultPesoIntermediario;
                }
            }
            i += 5;
        } while (i < 150);
        return cd;
    }

    public Integer avaliarMateriasConcentradas(Horario horario)
    {
        Integer ct = 0;
        String[] genes = FormatoService.converterGenesParaArray(horario.getHorario());
        int i = 0;
        do
        {
            if (genes[i].equals(genes[i + 1]) && genes[i + 1].equals(genes[i + 2]) && genes[i + 2].equals(genes[i + 3]))
            {
                ct += Avaliacao.defaultPesoBaixo;
            }
            if (genes[i + 1].equals(genes[i + 2]) && genes[i + 2].equals(genes[i + 3]) && genes[i + 3].equals(genes[i + 4]))
            {
                ct += Avaliacao.defaultPesoBaixo;
            }

            i += 5;
        } while (i < 150);
        return ct;
    }
    
    private Professor retornarProfessorPorCodigo(String codProfessor, ArrayList<Professor> professores)
    {
        Professor professor = new Professor();
        for(Professor prof : professores)
        {
            if(prof.getCodigoProfessor().equals(codProfessor))
            {
                professor = prof;
            }
        }
        return professor;
    }

}
