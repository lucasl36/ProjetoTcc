package Application;

import Core.Disciplina;
import Core.Materia;
import Core.Professor;
import Services.TesteService;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Main
{
    public static void main(String[] args) {
        
        TesteService testeSrv = new TesteService();
        
        ArrayList<Professor> professores = testeSrv.inicializarProfessoresPadroes();
        ArrayList<Disciplina> disciplinas = testeSrv.inicializarDisciplinasPadroes();
        ArrayList<Materia> materias = testeSrv.inicializarMateriasPadroes(professores, disciplinas);
        
        TesteService.exibirListProfessores(professores);
        TesteService.exibirListDisciplinas(disciplinas);
        TesteService.exibirListMaterias(materias);
    }
}
