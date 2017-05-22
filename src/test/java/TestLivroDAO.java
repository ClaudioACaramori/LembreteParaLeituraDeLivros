import entidades.Livro;
import persistencia.dao.DAOException;
import persistencia.dao.LivroDAO;

import java.util.List;

/**
 * Created by claud on 21/05/2017.
 */
public class TestLivroDAO {

    static LivroDAO<Livro> livroDAO;

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

    public static void testBuscarPorId(){
        Livro livroBuscado = livroDAO.buscarPorId(1);
        System.out.println(livroBuscado.getId() +  " " + livroBuscado.getNomeDoLivro() );
    }

    public static void testAlterar() throws DAOException{
        Livro livroBuscado = livroDAO.buscarPorId(1);
        livroBuscado.setNomeDoLivro("Zé");
        livroDAO.salvar(livroBuscado);
    }

    public static void testBuscarTodos(){
        List<Livro> buscarTodos = livroDAO.buscarTodos();
        for(Livro livro: buscarTodos){
            System.out.println(livro.getId() + " "+ livro.getNomeDoLivro() + " " + livro.getNumeroDePaginas());
        }
    }


    public static void testBuscarPorNomeDoLivro(){
        Livro livroBuscado = livroDAO.buscarPorNomeDoLivro("Java For Dummies");
        System.out.println(livroBuscado.getId() +  " " + livroBuscado.getNomeDoLivro() );
    }

    public static void testExcluir (){
        Livro livroBuscado = livroDAO.buscarPorId(1);
        livroDAO.remover(livroBuscado);
    }
}
