package modelo.muitospramuitos.tiosobrinho;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Sobrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "sobrinhos")
    private List<Tio> tios = new ArrayList<>();

    public Sobrinho() {
    }

    public Sobrinho(String nome) {
        this.nome = nome;
    }

    public Sobrinho(String nome, List<Tio> tios) {
        this.nome = nome;
        this.tios = tios;
    }


}
