package teste.muitospramuitos;

import daoinfra.DAO;
import modelo.muitospramuitos.atorfilme.Ator;
import modelo.muitospramuitos.atorfilme.Filme;

public class NovoFilmeAtor {

    public static void main(String[] args) {
        Filme filmeA = new Filme("Star Wars Ep 1", 8.9);
        Filme filmeB = new Filme("O Fugitivo",8.1);

        Ator atorA = new Ator("Harrison Ford");
        Ator atorB = new Ator("Carrie Fischer");

        filmeA.adicionarAtor(atorA);
        filmeA.adicionarAtor(atorB);

        filmeB.adicionarAtor(atorA);

        DAO<Filme> dao = new DAO<Filme>();
        dao.incluirAtomico(filmeA);

    }
}
