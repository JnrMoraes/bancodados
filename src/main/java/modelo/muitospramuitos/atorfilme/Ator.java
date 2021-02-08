package modelo.muitospramuitos.atorfilme;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "atores")
public class Ator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @ManyToMany(mappedBy = "atores", cascade = CascadeType.PERSIST)
    private List<Filme> filmes = new ArrayList<>();

    //Contrutores folded
    public Ator() {}

    public Ator(String nome) {
        this.nome = nome;
    }

    public Ator(String nome, List<Filme> filmes) {
        this.nome = nome;
        this.filmes = filmes;
    }

}
