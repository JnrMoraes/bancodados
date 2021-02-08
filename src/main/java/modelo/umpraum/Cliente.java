package modelo.umpraum;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name="assento_id", unique = true)
    private Assento assento;

    public Cliente() {
    }

    public Cliente(String nome, Assento assento) {
        super();
        this.nome = nome;
        this.assento = assento;
    }
}
