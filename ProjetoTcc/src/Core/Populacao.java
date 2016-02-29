package Core;

import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Populacao
{

    private Integer codigoPopulacao;
    private Date dataCriacao;
    private String nome;

    public Populacao(Integer codigoPopulacao, Date dataCriacao, String nome)
    {
        this.codigoPopulacao = codigoPopulacao;
        this.dataCriacao = dataCriacao;
        this.nome = nome;
    }

    public Populacao(Date dataCriacao, String nome)
    {
        this.dataCriacao = dataCriacao;
        this.nome = nome;
    }

    public Populacao()
    {

    }

    public Integer getCodigoPopulacao()
    {
        return codigoPopulacao;
    }

    public void setCodigoPopulacao(Integer codigoPopulacao)
    {
        this.codigoPopulacao = codigoPopulacao;
    }

    public Date getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao)
    {
        this.dataCriacao = dataCriacao;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

}
