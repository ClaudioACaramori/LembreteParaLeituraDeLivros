import br.com.testejera.entidade.Livro;
import br.com.testejera.persistencia.dao.DAOException;
import br.com.testejera.persistencia.dao.LivroDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * Created by claud on 23/05/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class TestLivroDAOJPA {

    @Autowired
    private LivroDAO livroDAO;

    EntityManager entityManager;

    @Test
    public void testSalvar() throws DAOException {
        Livro livro = new Livro();

        livro.setNomeDoLivro("A volta dos que não foram");
        livro.setNumeroDePaginas(171);

        livroDAO.salvar(livro);
    }

    @Test
    public void testBuscarTodos(){
        List<Livro> livroList = livroDAO.buscarTodos();

        assert(livroList!=null && livroList.size()>0);
    }

    @Test
    public void testRemover(){
        Livro livro = new Livro();
        livro.setId(4);

        livroDAO.remover(livro);
    }

    @Test
    public void testBuscarNomeDoLivro()throws DAOException{
        assertNotNull(livroDAO.buscarNomeDoLivro("Java for Ninjas"));
    }
}
