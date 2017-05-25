package br.com.testejera.controller;

import br.com.testejera.entidade.Lembrete;
import br.com.testejera.entidade.Livro;
import br.com.testejera.service.LembreteService;
import br.com.testejera.service.LivroService;
import br.com.testejera.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;

/**
 * Created by claud on 24/05/2017.
 */

@ManagedBean
@Controller
public class GeralController {
    Lembrete lembrete;
    Livro livro;

    @Autowired
    private LembreteService lembreteService;

    @Autowired
    private LivroService livroService;

    public void salvarLembrete(){
        try {
            lembreteService.salvar(lembrete);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
