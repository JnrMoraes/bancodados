package teste.consultas;

import daoinfra.DAO;
import modelo.muitospramuitos.atorfilme.consultas.NotaFilme;

public class ObterMediasFilmes {
    public static void main(String[] args) {

        DAO<NotaFilme> dao = new DAO<>(NotaFilme.class);
        NotaFilme nota = dao.consultarUm("obterMediaGeralDosFilmes" );
        System.out.println(nota.getMedia());

    }
}
