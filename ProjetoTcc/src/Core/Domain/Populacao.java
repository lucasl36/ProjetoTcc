package Core.Domain;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public class Populacao
{

    private Integer codigoPopulacao;
    private String dataCriacao;
    private String nome;
    private ArrayList<Horario> individuos;

    public Populacao(Integer codigoPopulacao, String dataCriacao, String nome)
    {
        this.codigoPopulacao = codigoPopulacao;
        this.individuos = new ArrayList<>();
        this.dataCriacao = dataCriacao;
        this.nome = nome;
    }

    public Populacao(String dataCriacao, String nome)
    {
        this.individuos = new ArrayList<>();
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

    public String getDataCriacao()
    {
        return dataCriacao;
    }

    public void setDataCriacao(String dataCriacao)
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
    
    public ArrayList<Horario> getIndividuos()
    {
        if(this.individuos == null)
        {
            this.individuos = new ArrayList<>();
        }
        return this.individuos;
    }
    
    public void setIndividuos(ArrayList<Horario> individuos)
    {
        this.individuos = individuos;
    }
    
    public void pushIndividuos(Horario individuo)
    {
        this.individuos.add(individuo);
    }

}
