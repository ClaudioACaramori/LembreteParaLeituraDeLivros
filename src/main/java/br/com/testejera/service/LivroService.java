package br.com.testejera.service;

import br.com.testejera.entidade.Livro;
import br.com.testejera.persistencia.dao.DAOException;
import br.com.testejera.persistencia.dao.LivroDAO;
import br.com.testejera.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by claud on 23/05/2017.
 */

@Service
public class LivroService {
    @Autowired
    private LivroDAO livroDAO;

    public void salvar(Livro livro) throws ServiceException {
        try {
            Livro livroExistente = livroDAO.buscarNomeDoLivro(livro.getNomeDoLivro());

            if(livroExistente != null){
                throw new ServiceException("Livro ja existe!");
            }
            livroDAO.salvar(livro);
        }catch (DAOException e){
            throw new ServiceException(e);
        }
    }
    public List<Livro> buscarTodos(){
        return livroDAO.buscarTodos();
    }

    public void excluir(Livro livro) throws ServiceException{
        livroDAO.remover(livro);
    }
}
