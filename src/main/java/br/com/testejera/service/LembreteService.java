package br.com.testejera.service;

import br.com.testejera.entidade.Lembrete;
import br.com.testejera.persistencia.dao.DAOException;
import br.com.testejera.persistencia.dao.LembreteDAO;
import br.com.testejera.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by claud on 24/05/2017.
 */
@Service
public class LembreteService {

    @Autowired
    LembreteDAO lembreteDAO;

    public void salvar(Lembrete lembrete) throws ServiceException {
        try {
            lembreteDAO.salvar(lembrete);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
