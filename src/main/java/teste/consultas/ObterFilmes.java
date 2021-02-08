package teste.consultas;

import daoinfra.DAO;
import modelo.muitospramuitos.atorfilme.Ator;
import modelo.muitospramuitos.atorfilme.Filme;

import java.util.List;

public class ObterFilmes {
    public static void main(String[] args) {

        DAO<Filme> dao = new DAO<Filme>(Filme.class);
        List<Filme> filmes = dao.consultar(
                "obterFilmesComNotaMaiorQue", "nota", 8.5);
        for(Filme filme: filmes){
            System.out.println(filme.getNome() +" nota -> "+ filme.getNota());

            for(Ator ator: filme.getAtores()){
                System.out.println(ator.getNome());
            }
        }

    }
}
