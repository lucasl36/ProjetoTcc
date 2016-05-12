package Core.Domain;

/**
 *
 * @author Lucas
 */
public class Horario
{

    private Integer codigoHorario;
    private String horario;
    private Integer nota;
    private Populacao populacao;

    public Horario(Integer codigoHorario, String horario, Populacao populacao)
    {
        this.codigoHorario = codigoHorario;
        this.horario = horario;
        this.populacao = populacao;
        this.nota = 0;
    }

    public Horario(String horario, Populacao populacao)
    {
        this.horario = horario;
        this.populacao = populacao;
        this.nota = 0;
    }

    public Horario()
    {
        this.nota = 0;
    }
    
    public Integer getCodigoHorario()
    {
        return codigoHorario;
    }

    public void setCodigoHorario(Integer codigoHorario)
    {
        this.codigoHorario = codigoHorario;
    }

    public String getHorario()
    {
        return horario;
    }

    public void setHorario(String horario)
    {
        this.horario = horario;
    }

    public Integer getNota()
    {
        return nota;
    }

    public void setNota(Integer nota)
    {
        this.nota = nota;
    }
    
    public Populacao getPopulacao()
    {
        return populacao;
    }

    public void setPopulacao(Populacao populacao)
    {
        this.populacao = populacao;
    }

}
