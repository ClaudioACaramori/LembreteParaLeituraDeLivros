import br.com.testejera.entidade.Livro;
import br.com.testejera.persistencia.dao.DAOException;
import br.com.testejera.persistencia.dao.LivroDAO;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by claud on 21/05/2017.
 */
public class TestLivroDAO {

    static LivroDAO<Livro> livroDAO;

    EntityManager entityManager;

    public static void main(String[] args) throws DAOException {
        testInserir();

        //testBuscarPorId();

        //testAlterar();
        //testBuscarTodos();
        //testBuscarPorNomeDoLivro();
        //testExcluir();
    }

    public static void testInserir() throws DAOException {
        livroDAO.salvar(new Livro("Java For Dummies", 350));
    }

    public static void testBuscarTodos(){
        List<Livro> buscarTodos = livroDAO.buscarTodos();
        for(Livro livro: buscarTodos){
            System.out.println(livro.getId() + " "+ livro.getNomeDoLivro() + " " + livro.getNumeroDePaginas());
        }
    }

    public void excluir(Livro livro) {
        entityManager.remove(entityManager.getReference(Livro.class,livro.getId()));
        }

}
