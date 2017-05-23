import br.com.testejera.entidade.Livro;
import br.com.testejera.persistencia.dao.DAOException;
import br.com.testejera.persistencia.dao.LivroDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by claud on 23/05/2017.
 */
public class TestLivroDAOJPA {
    public static void main(String[] args) throws DAOException {
        // Carregando o contexto do Spring
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");

        // Obtendo uma instancia de UsuarioDAO pelo Contexto do Spring
        LivroDAO livroDAO = (LivroDAO)classPathXmlApplicationContext.getBean("LivroDAOJpa");

        // Criando uma nova Instancia de usuário para ser salvo
        Livro livro = new Livro();
        livro.setNomeDoLivro("Java for Ninjas");
        livro.setNumeroDePaginas(420);

        // Salvando
        livroDAO.salvar(livro);
    }
}
