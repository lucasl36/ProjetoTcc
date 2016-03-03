package Core.Domain;

/**
 *
 * @author Lucas
 */
public class Horario
{

    private Integer codigoHorario;
    private String horario;
    private Populacao populacao;

    public Horario(Integer codigoHorario, String horario, Populacao populacao)
    {
        this.codigoHorario = codigoHorario;
        this.horario = horario;
        this.populacao = populacao;
    }

    public Horario(String horario, Populacao populacao)
    {
        this.horario = horario;
        this.populacao = populacao;
    }

    public Horario()
    {

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

    public Populacao getPopulacao()
    {
        return populacao;
    }

    public void setPopulacao(Populacao populacao)
    {
        this.populacao = populacao;
    }

}
