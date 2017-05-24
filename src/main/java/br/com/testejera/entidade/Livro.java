package br.com.testejera.entidade;

import javax.persistence.*;

/**
 * Created by claud on 20/05/2017.
 */

@Entity
@Table(name="livro")
public class Livro {

    private static final long serialVersionUID = 7822113190612870420L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id private Integer id;

    private String nomeDoLivro;

    private int numeroDePaginas;

    public Livro() {
    }

    public Livro(String nomeDoLivro, int numeroDePaginas) {
        super();
        this.nomeDoLivro = nomeDoLivro;
        this.numeroDePaginas = numeroDePaginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        if (numeroDePaginas != livro.numeroDePaginas) return false;
        if (!nomeDoLivro.equals(livro.nomeDoLivro)) return false;
        return id != null ? id.equals(livro.id) : livro.id == null;

    }

    @Override
    public int hashCode() {
        int result = nomeDoLivro.hashCode();
        result = 31 * result + numeroDePaginas;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", numeroDePaginas=" + numeroDePaginas +
                ", nomeDoLivro='" + nomeDoLivro + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public void setNomeDoLivro(String nomeDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }
}
