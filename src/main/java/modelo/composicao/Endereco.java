package modelo.composicao;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Endereco {

    private String logradouro;
    private String complemento;

    public Endereco(String logradouro, String complemento) {
        this.logradouro = logradouro;
        this.complemento = complemento;
    }
}
