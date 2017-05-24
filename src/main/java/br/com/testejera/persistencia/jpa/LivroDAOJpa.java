package br.com.testejera.persistencia.jpa;

import br.com.testejera.entidade.Livro;
import br.com.testejera.persistencia.dao.DAOException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.testejera.persistencia.dao.LivroDAO;

import javax.persistence.*;
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

    @Override
    public Livro buscarNomeDoLivro(String nomeDoLivro) throws DAOException {
        try{
            String jpql = "SELECT l FROM Livro l WHERE l.nomeDoLivro=:nomeDoLivroParam";

            Query consulta = entityManager.createQuery(jpql);
            consulta.setParameter("nomeDoLivroParam", nomeDoLivro);

            return (Livro) consulta.getSingleResult();
        }catch (NoResultException e){
            throw new DAOException("Nenhum livro encontrado!");
        }catch (NonUniqueResultException e){
            throw new DAOException("Mais de um livro encontrado!");
        }catch (Exception e){
            throw new DAOException(e);
        }
    }


}
