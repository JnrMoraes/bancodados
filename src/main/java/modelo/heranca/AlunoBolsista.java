package modelo.heranca;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
@DiscriminatorValue("AB")
public class AlunoBolsista extends Aluno {

    private double valorBolsa;

    public AlunoBolsista(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public AlunoBolsista(Long matricula, String nome, double valorBolsa) {
        super(matricula, nome);
        this.valorBolsa = valorBolsa;
    }
}
