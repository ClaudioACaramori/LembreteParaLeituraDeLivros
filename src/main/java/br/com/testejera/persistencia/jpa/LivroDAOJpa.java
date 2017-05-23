package br.com.testejera.persistencia.jpa;

import br.com.testejera.entidade.Livro;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.testejera.persistencia.dao.LivroDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by claud on 22/05/2017.
 */
@Repository("LivroDAOJpa")
public class LivroDAOJpa implements LivroDAO{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void salvar(Livro livro) {
        entityManager.merge(livro);
    }

    @Transactional
    public void remover(Livro livro) {
        livro = entityManager.find(Livro.class, livro.getId());
        entityManager.remove(livro);
    }

    public List<Livro> buscarTodos() {
        Query query = entityManager.createQuery("select livro from Livro livro");
        return query.getResultList();
    }

    public Livro buscarPorNomeDoLivro(String nomeDoLivro) {
        return entityManager.find(Livro.class,nomeDoLivro);
    }

    public Livro buscarPorId(int id) {
        return entityManager.find(Livro.class,id);
    }
}
