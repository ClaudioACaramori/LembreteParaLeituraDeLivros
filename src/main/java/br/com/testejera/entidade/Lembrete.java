package br.com.testejera.entidade;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by claud on 20/05/2017.
 */
@Entity
@Table(name = "livro")
public class Lembrete {

    private static final long serialVersionUID = 7822113190612870420L;

    private DiasDaSemana diasDaSemana;
    private String horaMinuto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lembrete lembrete = (Lembrete) o;

        if (diasDaSemana != null ? !diasDaSemana.equals(lembrete.diasDaSemana) : lembrete.diasDaSemana != null)
            return false;
        return horaMinuto != null ? horaMinuto.equals(lembrete.horaMinuto) : lembrete.horaMinuto == null;

    }

    @Override
    public int hashCode() {
        int result = diasDaSemana != null ? diasDaSemana.hashCode() : 0;
        result = 31 * result + (horaMinuto != null ? horaMinuto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lembrete{" +
                "diasDaSemana=" + diasDaSemana +
                ", horaMinuto='" + horaMinuto + '\'' +
                '}';
    }

    public DiasDaSemana getDiasDaSemana() {
        return diasDaSemana;
    }

    public void setDiasDaSemana(DiasDaSemana diasDaSemana) {
        this.diasDaSemana = diasDaSemana;
    }

    public String getHoraMinuto() {
        return horaMinuto;
    }

    public void setHoraMinuto(String horaMinuto) {
        this.horaMinuto = horaMinuto;
    }

    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
