package Core.Domain;

/**
 *
 * @author Lucas
 */
public class Disciplina
{

    private String codigoDisciplina;
    private String nome;
    private Integer cargaHoraria;
    private Integer periodo;

    public Disciplina(String codigoDisciplina, String nome, Integer cargaHoraria, Integer periodo)
    {
        this.codigoDisciplina = codigoDisciplina;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.periodo = periodo;
    }

    public Disciplina()
    {

    }

    public Integer getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Integer periodo)
    {
        this.periodo = periodo;
    }

    public String getCodigoDisciplina()
    {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina)
    {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public Integer getCargaHoraria()
    {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria)
    {
        this.cargaHoraria = cargaHoraria;
    }

}
