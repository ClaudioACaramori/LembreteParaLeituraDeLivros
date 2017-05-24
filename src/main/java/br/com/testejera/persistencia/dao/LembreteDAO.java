package br.com.testejera.persistencia.dao;

import br.com.testejera.entidade.Lembrete;

/**
 * Created by claud on 21/05/2017.
 */
public interface LembreteDAO {

    void salvar(Lembrete lembrete) throws DAOException;
}
