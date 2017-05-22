package persistencia.dao;

import entidades.Livro;

import java.util.List;

/**
 * Created by claud on 20/05/2017.
 */
public interface LivroDAO<L> {

    Livro salvar(Livro livro) throws DAOException;
    void remover(Livro livro);
    List<Livro> buscarTodos();
    Livro buscarPorNomeDoLivro(String nomeDoLivro);
    Livro buscarPorId(int id);
}
