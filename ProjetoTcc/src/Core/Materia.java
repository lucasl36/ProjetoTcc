package Core;

/**
 *
 * @author Lucas
 */
public class Materia
{

    private String codigoMateria;
    private Professor professor;
    private Disciplina disciplina;

    public Materia(String codigoMateria, Professor professor, Disciplina disciplina)
    {
        this.codigoMateria = codigoMateria;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Materia(Professor professor, Disciplina disciplina)
    {
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public Materia()
    {

    }

    public void buildCodigoMateria() throws Exception
    {
        if (this.professor == null || this.disciplina == null)
        {
            throw new Exception("Não foi possível definir código de matéria, professor ou disciplina não estipulados");
        }
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append(this.professor.getCodigoProfessor());
        strBuilder.append(this.disciplina.getCodigoDisciplina());
        this.codigoMateria = strBuilder.toString();
    }

    public String getCodigoMateria()
    {
        return codigoMateria;
    }

    public void setCodigoMateria(String codigoMateria)
    {
        this.codigoMateria = codigoMateria;
    }

    public Professor getProfessor()
    {
        return professor;
    }

    public void setProfessor(Professor professor)
    {
        this.professor = professor;
    }

    public Disciplina getDisciplina()
    {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina)
    {
        this.disciplina = disciplina;
    }

}
