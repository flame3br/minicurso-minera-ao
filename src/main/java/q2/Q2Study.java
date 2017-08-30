/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2;

import org.repodriller.RepoDriller;
import org.repodriller.RepositoryMining;
import org.repodriller.Study;
import org.repodriller.filter.commit.OnlyInMainBranch;
import org.repodriller.filter.range.Commits;
import org.repodriller.persistence.csv.CSVFile;
import org.repodriller.scm.GitRepository;

/**
 *
 * @author a1857355
 */
public class Q2Study implements Study{
   
    public static void main(String[] args) {
        new RepoDriller().start(new Q2Study());
    }

    @Override
    public void execute() {
        new RepositoryMining()
                .in(GitRepository.singleProject("/home/todos/alunos/cm/a1857355/minicurso/clones/mypy"))
                .through(Commits.monthly(0))
                .filters(new OnlyInMainBranch())
                .process(new BugVisitor(), new CSVFile("/home/todos/alunos/cm/a1857355/minicurso/clones/q2_mypy.csv"))
                .mine();
    }
    
}
