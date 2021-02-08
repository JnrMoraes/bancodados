package teste.basico;


import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Remover {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

        Usuario usuario = manager.find(Usuario.class, 6l);

        if(usuario != null){
            manager.getTransaction().begin();
            manager.remove(usuario);
            manager.getTransaction().commit();
        }

        manager.close();
        factory.close();
    }

}
