package br.com.testejera.persistencia.dao;

import br.com.testejera.entidade.Livro;

import java.util.List;

/**
 * Created by claud on 20/05/2017.
 */
public interface LivroDAO<L> {

    void salvar(Livro livro) throws DAOException;
    void remover(Livro livro);
    List<Livro> buscarTodos();

    Livro buscarNomeDoLivro(String nomeDoLivro) throws DAOException;
}
