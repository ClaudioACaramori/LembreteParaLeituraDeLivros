import br.com.testejera.entidade.Livro;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Created by claud on 23/05/2017.
 */
public class TestDataBase {
    public static void main(String[] args){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
        EntityManagerFactory entityManagerFactory = (EntityManagerFactory)
                classPathXmlApplicationContext.getBean("entityManagerFactory");

        //Obtendo um objeto gerenciador de br.com.testejera.entidade
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Criando um objeto Usuario
        Livro livro = new Livro();
        livro.setNomeDoLivro("Java For Dummies");
        livro.setNumeroDePaginas(350);

        //Obtendo um objeto gerenciador de transacoes
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(livro);
        transaction.commit();

    }
    private static void testDataSource(){

    }
}
