package br.com.testejera.controller;


import br.com.testejera.entidade.Livro;
import br.com.testejera.service.LivroService;
import br.com.testejera.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.faces.bean.ManagedBean;

/**
 * Created by claud on 22/05/2017.
 */
@ManagedBean
@Controller
public class LivroController {
    private Livro livro;

    @Autowired
    private LivroService livroService;

    public LivroController() {
        livro = new Livro();
    }

    public void salvar(){
        try {
            livroService.salvar(livro);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
