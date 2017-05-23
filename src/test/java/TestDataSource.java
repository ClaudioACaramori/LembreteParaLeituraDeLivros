import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by claud on 23/05/2017.
 */
public class TestDataSource {
    public static void main(String[] args) {

        //Carregando o contexto do Spring
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new
                ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");

        //Acessando o objeto BasicDataSource criado dentro do contexto do Spring
        BasicDataSource basicDataSource = (BasicDataSource)classPathXmlApplicationContext.getBean("dataSource");

        //Imprimindo dados do objeto BasicDataSource criado no contexto do Spring
        System.out.println( basicDataSource.getDriverClassName() );
        System.out.println( basicDataSource.getUrl() );
        System.out.println( basicDataSource.getUsername() );
        System.out.println( basicDataSource.getPassword());

        //O Objeto de Carregamento de Recursos ClassPathXmlApplicationContext deve ser fechado após seu uso.
        classPathXmlApplicationContext.close();
    }
}

