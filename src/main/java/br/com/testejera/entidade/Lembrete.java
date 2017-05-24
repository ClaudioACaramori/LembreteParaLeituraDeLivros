package br.com.testejera.entidade;

import br.com.testejera.DiasDaSemana;

import java.util.List;

/**
 * Created by claud on 20/05/2017.
 */
public class Lembrete {
    private DiasDaSemana[] diasDaSemanaList;
    private String horaMinuto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lembrete lembrete = (Lembrete) o;

        if (diasDaSemanaList != null ? !diasDaSemanaList.equals(lembrete.diasDaSemanaList) : lembrete.diasDaSemanaList != null)
            return false;
        return horaMinuto != null ? horaMinuto.equals(lembrete.horaMinuto) : lembrete.horaMinuto == null;

    }

    @Override
    public int hashCode() {
        int result = diasDaSemanaList != null ? diasDaSemanaList.hashCode() : 0;
        result = 31 * result + (horaMinuto != null ? horaMinuto.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Lembrete{" +
                "diasDaSemanaList=" + diasDaSemanaList +
                ", horaMinuto='" + horaMinuto + '\'' +
                '}';
    }

    public DiasDaSemana[] getDiasDaSemanaList() {
        return diasDaSemanaList;
    }

    public void setDiasDaSemanaList(DiasDaSemana[] diasDaSemanaList) {
        this.diasDaSemanaList = diasDaSemanaList;
    }

    public String getHoraMinuto() {
        return horaMinuto;
    }

    public void setHoraMinuto(String horaMinuto) {
        this.horaMinuto = horaMinuto;
    }
}
