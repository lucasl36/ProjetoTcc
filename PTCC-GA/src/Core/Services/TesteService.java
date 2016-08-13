package Core.Services;

import Core.Components.Criacao;
import Core.Domain.Disciplina;
import Core.Domain.Horario;
import Core.Domain.Materia;
import Core.Domain.Populacao;
import Core.Domain.Professor;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Lucas
 */
public class TesteService
{

    public ArrayList<Professor> inicializarProfessoresPadroes()
    {
        ArrayList<Professor> professores = new ArrayList<>();
        Integer[] disponibilidade;

        disponibilidade = this.fornecerDisponibilidade(0, 4);
        professores.add(new Professor("01", "Rafaela", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(5, 9);
        professores.add(new Professor("02", "Junia", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(20, 24);
        professores.add(new Professor("03", "Ademir", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(15, 19);
        professores.add(new Professor("04", "Eloisa", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(10, 14);
        professores.add(new Professor("05", "Matheus Garcia", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(20, 24);
        professores.add(new Professor("06", "Rogerio Costa", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(15, 19);
        professores.add(new Professor("07", "Wesley", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(10, 14);
        professores.add(new Professor("08", "Will Roger", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(0, 4);
        professores.add(new Professor("09", "Geise", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(5, 9);
        professores.add(new Professor("10", "Daniela", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(5, 9);
        professores.add(new Professor("11", "Clarimundo", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(20, 24);
        professores.add(new Professor("12", "Flamariom", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(15, 19);
        professores.add(new Professor("13", "Elson", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(0, 4);
        professores.add(new Professor("14", "Jane", disponibilidade));
        disponibilidade = this.fornecerDisponibilidade(15, 19);
        professores.add(new Professor("15", "Claudia", disponibilidade));

        return professores;
    }

    public ArrayList<Disciplina> inicializarDisciplinasPadroes()
    {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        // 1º Período
        disciplinas.add(new Disciplina("01", "Cálculo", 3, 1));
        disciplinas.add(new Disciplina("02", "Algoritmo", 8, 1));
        disciplinas.add(new Disciplina("03", "Interface Homem-Máquina", 3, 1));
        disciplinas.add(new Disciplina("04", "Português", 2, 1));
        disciplinas.add(new Disciplina("05", "Inglês", 2, 1));
        disciplinas.add(new Disciplina("06", "Introdução à Computação", 5, 1));
        disciplinas.add(new Disciplina("07", "Metodologia Científica", 2, 1));
        // 2º Período
        disciplinas.add(new Disciplina("08", "Álgebra", 3, 2));
        disciplinas.add(new Disciplina("09", "Cálculo II", 3, 2));
        disciplinas.add(new Disciplina("10", "Modelagem de Banco de Dados", 4, 2));
        disciplinas.add(new Disciplina("11", "Eng. de Software", 5, 2));
        disciplinas.add(new Disciplina("12", "Arquitetura de Computadores", 4, 2));
        disciplinas.add(new Disciplina("13", "Estrutura de Dados", 6, 2));
        // 3o Periodo
        disciplinas.add(new Disciplina("14", "Banco de Dados", 5, 3));
        disciplinas.add(new Disciplina("15", "Programação Orientada a Objetos", 4, 3));
        disciplinas.add(new Disciplina("16", "Pesquisa e Ordenação", 5, 3));
        disciplinas.add(new Disciplina("17", "Sistemas Operacionais", 4, 3));
        disciplinas.add(new Disciplina("18", "Matemática Discreta", 4, 3));
        disciplinas.add(new Disciplina("19", "Eng. de Software II", 3, 3));
        // 4o Periodo
        disciplinas.add(new Disciplina("20", "Programação Visual", 6, 4));
        disciplinas.add(new Disciplina("21", "Redes de Computadores", 5, 4));
        disciplinas.add(new Disciplina("22", "Matemática Financeira", 2, 4));
        disciplinas.add(new Disciplina("23", "Programação para Internet", 5, 4));
        disciplinas.add(new Disciplina("24", "Qualidade de Software", 3, 4));
        disciplinas.add(new Disciplina("25", "Adm. de Banco de Dados", 4, 4));
        // 5o Periodo
        disciplinas.add(new Disciplina("26", "Dispositivos Móveis", 5, 5));
        disciplinas.add(new Disciplina("27", "Sistemas Distribuídos", 4, 5));
        disciplinas.add(new Disciplina("28", "Implantação de Servidores", 4, 5));
        disciplinas.add(new Disciplina("29", "Aplicações WEB", 4, 5));
        disciplinas.add(new Disciplina("30", "Adm. de Empresas", 3, 5));
        disciplinas.add(new Disciplina("31", "Tópicos Avançados de Programação", 4, 5));
        // 6o Periodo
        disciplinas.add(new Disciplina("32", "Segurança de Redes", 5, 6));
        disciplinas.add(new Disciplina("33", "Gerenciamento de Projetos", 4, 6));
        disciplinas.add(new Disciplina("34", "Comércio Eletrônico", 4, 6));
        disciplinas.add(new Disciplina("35", "Inteligência Artificial", 4, 6));
        disciplinas.add(new Disciplina("36", "Marketing", 3, 6));
        disciplinas.add(new Disciplina("37", "Legislação", 2, 6));
        disciplinas.add(new Disciplina("38", "Ética", 2, 6));

        return disciplinas;
    }

    public ArrayList<Materia> inicializarMateriasPadroes(ArrayList<Professor> professores, ArrayList<Disciplina> disciplinas)
    {
        ArrayList<Materia> materias = new ArrayList<>();

        materias.add(this.instanciarMateria("01", "01", professores, disciplinas));
        materias.add(this.instanciarMateria("02", "02", professores, disciplinas));
        materias.add(this.instanciarMateria("03", "03", professores, disciplinas));
        materias.add(this.instanciarMateria("04", "04", professores, disciplinas));
        materias.add(this.instanciarMateria("05", "04", professores, disciplinas));
        materias.add(this.instanciarMateria("06", "05", professores, disciplinas));
        materias.add(this.instanciarMateria("07", "04", professores, disciplinas));
        materias.add(this.instanciarMateria("08", "01", professores, disciplinas));
        materias.add(this.instanciarMateria("09", "01", professores, disciplinas));
        materias.add(this.instanciarMateria("10", "06", professores, disciplinas));
        materias.add(this.instanciarMateria("11", "07", professores, disciplinas));
        materias.add(this.instanciarMateria("12", "03", professores, disciplinas));
        materias.add(this.instanciarMateria("13", "02", professores, disciplinas));
        materias.add(this.instanciarMateria("14", "06", professores, disciplinas));
        materias.add(this.instanciarMateria("15", "08", professores, disciplinas));
        materias.add(this.instanciarMateria("16", "09", professores, disciplinas));
        materias.add(this.instanciarMateria("17", "05", professores, disciplinas));
        materias.add(this.instanciarMateria("18", "10", professores, disciplinas));
        materias.add(this.instanciarMateria("19", "07", professores, disciplinas));
        materias.add(this.instanciarMateria("20", "11", professores, disciplinas));
        materias.add(this.instanciarMateria("21", "12", professores, disciplinas));
        materias.add(this.instanciarMateria("22", "01", professores, disciplinas));
        materias.add(this.instanciarMateria("23", "05", professores, disciplinas));
        materias.add(this.instanciarMateria("24", "10", professores, disciplinas));
        materias.add(this.instanciarMateria("25", "06", professores, disciplinas));
        materias.add(this.instanciarMateria("26", "08", professores, disciplinas));
        materias.add(this.instanciarMateria("27", "08", professores, disciplinas));
        materias.add(this.instanciarMateria("28", "13", professores, disciplinas));
        materias.add(this.instanciarMateria("29", "07", professores, disciplinas));
        materias.add(this.instanciarMateria("30", "14", professores, disciplinas));
        materias.add(this.instanciarMateria("31", "09", professores, disciplinas));
        materias.add(this.instanciarMateria("32", "13", professores, disciplinas));
        materias.add(this.instanciarMateria("33", "09", professores, disciplinas));
        materias.add(this.instanciarMateria("34", "03", professores, disciplinas));
        materias.add(this.instanciarMateria("35", "11", professores, disciplinas));
        materias.add(this.instanciarMateria("36", "14", professores, disciplinas));
        materias.add(this.instanciarMateria("37", "15", professores, disciplinas));
        materias.add(this.instanciarMateria("38", "15", professores, disciplinas));

        for (Materia obj : materias)
        {
            try
            {
                obj.buildCodigoMateria();
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        return materias;
    }

    private Integer[] fornecerDisponibilidade(Integer start, Integer end)
    {
        Integer[] disponibilidade = new Integer[25];
        for (int i = 0; i < 25; i++)
        {
            if (i >= start && i <= end)
            {
                disponibilidade[i] = 1;
            } else
            {
                disponibilidade[i] = 0;
            }
        }
        return disponibilidade;
    }

    private Integer[] fornecerDisponibilidadeAleatoria(Integer qtdeHorarios)
    {
        Integer[] disponibilidade = new Integer[25];
        Integer[] posicoes = new Integer[qtdeHorarios];
        for (Integer pos : posicoes)
        {
            pos = (int) (Math.random() * 26);
        }
        for (Integer pos : posicoes)
        {
            disponibilidade[pos] = 1;
        }
        return disponibilidade;
    }

    private Materia instanciarMateria(String codDisciplina, String codProfessor, ArrayList<Professor> professores, ArrayList<Disciplina> disciplinas)
    {
        Professor professor = new Professor();
        Disciplina disciplina = new Disciplina();

        for (Disciplina obj : disciplinas)
        {
            if (obj.getCodigoDisciplina().equals(codDisciplina))
            {
                disciplina = obj;
            }
        }
        for (Professor obj : professores)
        {
            if (obj.getCodigoProfessor().equals(codProfessor))
            {
                professor = obj;
            }
        }

        return new Materia(professor, disciplina);
    }

    public static void exibirListProfessores(ArrayList<Professor> professores)
    {
        for (Professor obj : professores)
        {
            System.out.println("Cod.:" + obj.getCodigoProfessor());
            System.out.println("Nome.:" + obj.getNome());
            System.out.println();
        }
    }

    public static void exibirListDisciplinas(ArrayList<Disciplina> disciplinas)
    {
        for (Disciplina obj : disciplinas)
        {
            System.out.println("Cod.:" + obj.getCodigoDisciplina());
            System.out.println("Nome:" + obj.getNome());
            System.out.println("Período.:" + obj.getPeriodo());
            System.out.println("Carga Horaria.:" + obj.getCargaHoraria());
            System.out.println();
        }
    }

    public static void exibirListMaterias(ArrayList<Materia> materias)
    {
        for (Materia obj : materias)
        {
            System.out.println("Cod.:" + obj.getCodigoMateria() + ", " + obj.getDisciplina().getPeriodo() + "º Período");
        }
    }

    public static void exibirPopulacao(Populacao populacao)
    {
        ArrayList<Horario> horarios = populacao.getIndividuos();
        int i = 1;
        for (Horario horario : horarios)
        {
            System.out.println("Indivíduo nº" + i + ":");
            TesteService.exibirHorario(horario.getNota(), horario.getHorario());
            i++;
        }
    }

    public static void exibirHorario(Integer nota, String horario)
    {
        System.out.println("Nota:" + nota);
        horario = horario.replace("]", "");
        horario = horario.replace("[", "");
        horario = horario.replace(" ", "");
        String[] arrayHorario = horario.split(",");
        for (int i = 0; i < arrayHorario.length; i++)
        {
            System.out.print(arrayHorario[i] + ",");
            switch (i)
            {
                case 24:
                case 49:
                case 74:
                case 99:
                case 124:
                    System.out.println();
            }
        }
        System.out.println();
    }

    public static void exibirGradeHorario(String horario, ArrayList<Materia> materias)
    {

        horario = horario.replace("]", "");
        horario = horario.replace("[", "");
        horario = horario.replace(" ", "");
        String[] arrayHorario = horario.split(",");

        for (int i = 0; i < 25; i++)
        {
            for (int j = 0; j < 6; j++)
            {
                Materia materia = TesteService.encontrarMateriaCodigo(arrayHorario[i], materias);
                if (materia.getProfessor() != null && materia.getDisciplina() != null)
                {
                    System.out.print(materia.getProfessor().getNome());
                    System.out.print(" - ");
                    System.out.print(materia.getDisciplina().getNome());
                } else
                {
                    System.out.print("vazio : vazio");
                }
                System.out.printf("\t");
            }

            materia = TesteService.encontrarMateriaCodigo(arrayHorario[i + 25], materias);
            if (materia.getProfessor() != null && materia.getDisciplina() != null)
            {
                System.out.print(materia.getProfessor().getNome());
                System.out.print(" - ");
                System.out.print(materia.getDisciplina().getNome());
            } else
            {
                System.out.print("vazio : vazio");
            }
            System.out.printf("\t");
            materia = TesteService.encontrarMateriaCodigo(arrayHorario[i + 50], materias);
            if (materia.getProfessor() != null && materia.getDisciplina() != null)
            {
                System.out.print(materia.getProfessor().getNome());
                System.out.print(" - ");
                System.out.print(materia.getDisciplina().getNome());
            } else
            {
                System.out.print("vazio : vazio");
            }
            System.out.printf("\t");
            materia = TesteService.encontrarMateriaCodigo(arrayHorario[i + 75], materias);
            if (materia.getProfessor() != null && materia.getDisciplina() != null)
            {
                System.out.print(materia.getProfessor().getNome());
                System.out.print(" - ");
                System.out.print(materia.getDisciplina().getNome());
            } else
            {
                System.out.print("vazio : vazio");
            }
            System.out.printf("\t");
            materia = TesteService.encontrarMateriaCodigo(arrayHorario[i + 100], materias);
            if (materia.getProfessor() != null && materia.getDisciplina() != null)
            {
                System.out.print(materia.getProfessor().getNome());
                System.out.print(" - ");
                System.out.print(materia.getDisciplina().getNome());
            } else
            {
                System.out.print("vazio - vazio");
            }
            System.out.printf("\t");
            materia = TesteService.encontrarMateriaCodigo(arrayHorario[i + 125], materias);
            if (materia.getProfessor() != null && materia.getDisciplina() != null)
            {
                System.out.print(materia.getProfessor().getNome());
                System.out.print(" - ");
                System.out.print(materia.getDisciplina().getNome());
            } else
            {
                System.out.print("vazio : vazio");
            }
            System.out.println();
        }

    }

    private static Materia encontrarMateriaCodigo(String codigoMateria, ArrayList<Materia> materias)
    {
        Materia materia = new Materia();
        for (Materia m : materias)
        {
            if (m.getCodigoMateria().equals(codigoMateria))
            {
                materia = m;
            }
        }
        return materia;
    }

    public static void exibirMediaNotasPopulacao(Populacao populacao)
    {
        Integer maiorNota;
        Integer menorNota;
        Integer mediaNotas;

        maiorNota = populacao.getIndividuos().get(0).getNota();
        menorNota = populacao.getIndividuos().get(0).getNota();

        mediaNotas = 0;
        for (Horario h : populacao.getIndividuos())
        {
            if (h.getNota() > maiorNota)
            {
                maiorNota = h.getNota();
            }
            if (h.getNota() < menorNota)
            {
                menorNota = h.getNota();
            }
            mediaNotas += h.getNota();
        }

        Double media = (double) (mediaNotas / Criacao.defaultIndividuosPopulacao);
        System.out.println("Media: " + media);
        System.out.println("Maior Nota: " + maiorNota);
        System.out.println("Menor Nota: " + menorNota);
        System.out.println();
    }

    public static void exibirMelhorIndividuoPopulacao(Populacao populacao, ArrayList<Materia> materias)
    {
        Integer maiorNota;
        Integer indice = 0;

        maiorNota = populacao.getIndividuos().get(0).getNota();

        Integer i = 0;
        for (Horario h : populacao.getIndividuos())
        {
            if (h.getNota() > maiorNota)
            {
                maiorNota = h.getNota();
                indice = i;
            }
            i++;
        }

        TesteService.exibirGradeHorario(populacao.getIndividuos().get(indice).getHorario(), materias);
    }

    public TesteService()
    {

    }

}
