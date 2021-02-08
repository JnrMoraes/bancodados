package modelo.basico;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeUsuario;

    private String email;

    public Usuario() {
    }

    public Usuario(String nomeUsuario, String email) {
        this.nomeUsuario = nomeUsuario;
        this.email = email;
    }


}
