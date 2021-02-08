package teste.basico;


import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObterUsuario {

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        Usuario usuario = manager.find(Usuario.class, 1L);
        System.out.println("Nome do usuario: " + usuario.getNomeUsuario());

        manager.close();
        factory.close();

    }
}
