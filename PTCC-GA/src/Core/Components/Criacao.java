package Core.Components;

import Core.Domain.Horario;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Services.FormatoService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Lucas
 */
public class Criacao
{

    /* Quantiade de Cromossomos por Período */
    public static final Integer defaultCromossomosPeriodo = 25;
    /* Quantiade de Cromossomos por Indivíduo */
    public static final Integer defaultCromossomosTotal = 150;
    /* Quantidade de Indivíduos por População */
    public static final Integer defaultIndividuosPopulacao = 50;
    /* Variável para Matária livre */
    public static final String defaultEmptyClass = "0000";

    public Populacao inicializarPopulacao(Integer numIndividuos, ArrayList<Materia> materias)
    {
        Populacao novaPopulacao = new Populacao(FormatoService.agora(), "");
        
        String[] primeiroPeriodo = this.recuperarMateriasPorPeriodo(separarMateriasPorPeriodo(1, materias));
        String[] segundoPeriodo = this.recuperarMateriasPorPeriodo(separarMateriasPorPeriodo(2, materias));
        String[] terceiroPeriodo = this.recuperarMateriasPorPeriodo(separarMateriasPorPeriodo(3, materias));
        String[] quartoPeriodo = this.recuperarMateriasPorPeriodo(separarMateriasPorPeriodo(4, materias));
        String[] quintoPeriodo = this.recuperarMateriasPorPeriodo(separarMateriasPorPeriodo(5, materias));
        String[] sextoPeriodo = this.recuperarMateriasPorPeriodo(separarMateriasPorPeriodo(6, materias));

        for (int i = 0; i < Criacao.defaultIndividuosPopulacao; i++)
        {
            String[] todosPeriodos = null;
            todosPeriodos = this.juntarPeriodos(this.baguncarPeriodo(primeiroPeriodo), this.baguncarPeriodo(segundoPeriodo));
            todosPeriodos = this.juntarPeriodos(todosPeriodos, this.baguncarPeriodo(terceiroPeriodo));
            todosPeriodos = this.juntarPeriodos(todosPeriodos, this.baguncarPeriodo(quartoPeriodo));
            todosPeriodos = this.juntarPeriodos(todosPeriodos, this.baguncarPeriodo(quintoPeriodo));
            todosPeriodos = this.juntarPeriodos(todosPeriodos, this.baguncarPeriodo(sextoPeriodo));
            
            Horario novoHorario = new Horario(Arrays.toString(todosPeriodos), novaPopulacao);
            novaPopulacao.pushIndividuos(novoHorario);
        }
        
        return novaPopulacao;
    }

    private String[] recuperarMateriasPorPeriodo(ArrayList<Materia> materias)
    {
        String[] materiasPeriodo = new String[Criacao.defaultCromossomosPeriodo];
        String materiaLivre = Criacao.defaultEmptyClass;
        
        Integer cargaHorariaTotal = 0;
        int i = 0;
        for (Materia materia : materias)
        {
            for (int j = 0; j < materia.getDisciplina().getCargaHoraria(); j++)
            {
                materiasPeriodo[i] = materia.getCodigoMateria();
                i++;
            }
            cargaHorariaTotal += materia.getDisciplina().getCargaHoraria();
        }
        if (cargaHorariaTotal < Criacao.defaultCromossomosPeriodo)
        {
            Integer quantidadeHorariosLivres = Criacao.defaultCromossomosPeriodo - cargaHorariaTotal;
            for (int k = quantidadeHorariosLivres; k > 0; k--)
            {
                materiasPeriodo[i] = materiaLivre;
                i++;
            }
        }
        return materiasPeriodo;
    }

    private ArrayList<Materia> separarMateriasPorPeriodo(Integer periodo, ArrayList<Materia> materias)
    {
        ArrayList<Materia> materiasPeriodo = new ArrayList<>();
        for (Materia materia : materias)
        {
            Integer periodoMateria = materia.getDisciplina().getPeriodo();
            if (Objects.equals(periodoMateria, periodo))
            {
                materiasPeriodo.add(materia);
            }
        }
        return materiasPeriodo;
    }

    private String[] juntarPeriodos(String[] periodo1, String[] periodo2)
    {
        StringBuilder builder = new StringBuilder();
        for (String str : periodo1)
        {
            builder.append(str);
            builder.append(",");
        }
        for (String str : periodo2)
        {
            builder.append(str);
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        String periodoXY = builder.toString();
        return periodoXY.split(",");
    }

    private String[] baguncarPeriodo(String[] periodo)
    {
        Random rnd = ThreadLocalRandom.current();
        for (int i = periodo.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            String str = periodo[index];
            periodo[index] = periodo[i];
            periodo[i] = str;
        }
        return periodo;
    }

}
