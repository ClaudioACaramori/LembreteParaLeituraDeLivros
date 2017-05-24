package br.com.testejera.controller;

import br.com.testejera.entidade.Lembrete;
import br.com.testejera.service.LembreteService;
import br.com.testejera.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by claud on 24/05/2017.
 */
public class LembreteController {
    private Lembrete lembrete;

    @Autowired
    private LembreteService lembreteService;

    public LembreteController() {
        lembrete = new Lembrete();
    }

    public void salvar(){
        try {
            lembreteService.salvar(lembrete);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
