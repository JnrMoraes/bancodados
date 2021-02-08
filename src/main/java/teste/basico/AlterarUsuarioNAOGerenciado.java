package teste.basico;


import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterarUsuarioNAOGerenciado {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();

        Usuario usuario = manager.find(Usuario.class, 3l);
        usuario.setNomeUsuario("Miquelito Jordin");
        usuario.setEmail("miquelito@jogador.com.br");

        //tiro o gerenciamento de estado
        manager.detach(usuario);

        manager.merge(usuario);

        manager.getTransaction().commit();

        manager.close();
        factory.close();

    }
}
