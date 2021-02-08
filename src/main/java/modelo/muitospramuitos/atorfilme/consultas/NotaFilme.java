package modelo.muitospramuitos.atorfilme.consultas;

import lombok.Data;

@Data
public class NotaFilme {

    private double media;

    public NotaFilme(double media) {
        this.media = media;
    }
}
