/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1;

import org.repodriller.domain.Commit;
import org.repodriller.persistence.PersistenceMechanism;
import org.repodriller.scm.SCMRepository;

/**
 *
 * @author a1857355
 */
public class CommitVisitor implements org.repodriller.scm.CommitVisitor{

    @Override
    public void process(SCMRepository scmr, Commit commit, PersistenceMechanism pm) {
        pm.write(commit.getHash(),
                 commit.getAuthor().getName(), 
                 commit.getAuthor().getEmail()
        );
    }

    @Override
    public String name() {
        return "commit";
    }
    
}
