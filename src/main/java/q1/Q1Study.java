/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author a1857355
 */
public class Q1Study implements Study{
    
    public static void main(String[] args) {
        new RepoDriller().start(new Q1Study());
    }

    @Override
    public void execute() {
        new RepositoryMining()
                .in(GitRepository.singleProject("/home/todos/alunos/cm/a1857355/minicurso/materialize"))
                .through(Commits.all())
                .process(new CommitVisitor(), new CSVFile("/home/todos/alunos/cm/a1857355/minicurso/questoes/materialize/q1.csv"))
                .mine();
    }
    
}
