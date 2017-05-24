import br.com.testejera.entidade.Livro;
import br.com.testejera.service.LivroService;
import br.com.testejera.service.exception.ServiceException;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by claud on 23/05/2017.
 */
public class TestLivroService {
    private LivroService livroService;

    @Test
    public void testSalvar() throws ServiceException{
        Livro livro = new Livro();

        livro.setNomeDoLivro("As tranças de um careca");
        livro.setNumeroDePaginas(123);
        livro.setId(15);

        livroService.salvar(livro);
    }

    @Test
    public void testBuscarTodos(){
        List<Livro> livroList = livroService.buscarTodos();

        assert(livroList != null && livroList.size()>0);
    }

    @Test
    public void testRemover() throws ServiceException {
        Livro livro = new Livro();
        livro.setId(2);

        livroService.excluir(livro);
    }
}
