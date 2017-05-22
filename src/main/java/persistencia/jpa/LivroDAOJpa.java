package persistencia.jpa;

import entidades.Livro;
import org.springframework.transaction.annotation.Transactional;
import persistencia.dao.DAOException;
import persistencia.dao.LivroDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by claud on 22/05/2017.
 */
public class LivroDAOJpa{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Livro salvar(Livro livro) throws DAOException {

        try{
            return entityManager.merge(livro);
        }catch (Exception e ) {
            throw new DAOException(e);
        }
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
