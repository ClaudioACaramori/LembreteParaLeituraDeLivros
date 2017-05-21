import entidades.Livro;
import persistencia.dao.LivroDAO;

/**
 * Created by claud on 21/05/2017.
 */
public class TestLivroDAO {

    public static void main(String[] args){
        testCadastrar();
    }

    private static void testCadastrar() {
        Livro livroCadastrado = new Livro();
        livroCadastrado.setNomeDoLivro("O Alquimista");
        livroCadastrado.setNumeroDePaginas(176);

        LivroDAO livroDAO = new LivroDAO();

        livroDAO.cadastrar(livroCadastrado);
    }
}
