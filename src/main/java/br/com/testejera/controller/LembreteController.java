package br.com.testejera.controller;

import br.com.testejera.entidade.Lembrete;
import br.com.testejera.service.LembreteService;
import br.com.testejera.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;

/**
 * Created by claud on 24/05/2017.
 */

@ManagedBean
@Controller
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

    public Lembrete getLembrete() {
        return lembrete;
    }

    public void setLembrete(Lembrete lembrete) {
        this.lembrete = lembrete;
    }
}
