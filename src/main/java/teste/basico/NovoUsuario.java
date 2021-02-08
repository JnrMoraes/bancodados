package teste.basico;


import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NovoUsuario {

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario();
        usuario1.setNomeUsuario("Micheal Jackson");
        usuario1.setEmail("jackson@gmail.com");

        Usuario usuario2 = new Usuario();
        usuario2.setNomeUsuario("Boby Macwell");
        usuario2.setEmail("macwell@gmail.com");

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();
        manager.persist(usuario1);
        manager.persist(usuario2);
        manager.getTransaction().commit();

        System.out.println("Id do usuário: " + usuario1.getId());
        System.out.println("Nome do usuário: " + usuario1.getNomeUsuario());
        System.out.println("E-mail do usuário: " + usuario1.getEmail());

        System.out.println("Id do usuário: " + usuario2.getId());
        System.out.println("Nome do usuário: " + usuario2.getNomeUsuario());
        System.out.println("E-mail do usuário: " + usuario2.getEmail());

        manager.close();
    }
}
