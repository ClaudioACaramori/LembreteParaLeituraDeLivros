package br.com.testejera.controller;


import br.com.testejera.entidade.Livro;

/**
 * Created by claud on 22/05/2017.
 */
public class LivroController {
    private Livro livro;

    public LivroController() {
        livro = new Livro();
    }

    public void salvar(){
        toString();

        System.out.println(livro);
    }

    @Override
    public String toString() {

        return "LivroController{" +
                "livro=" + livro +
                '}';
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
