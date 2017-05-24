package br.com.testejera.persistencia.jpa;

import br.com.testejera.entidade.Lembrete;
import br.com.testejera.persistencia.dao.LembreteDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by claud on 24/05/2017.
 */
@Repository("LembreteDAOJpa")
public class LembreteDAOJpa implements LembreteDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Lembrete lembrete) {
        entityManager.merge(lembrete);
    }
}
