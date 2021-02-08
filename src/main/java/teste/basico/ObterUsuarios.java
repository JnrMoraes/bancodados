package teste.basico;


import modelo.basico.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ObterUsuarios {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev-UP");
        EntityManager manager = factory.createEntityManager();

//        String jpql = "select u from Usuario u";
//        TypedQuery<Usuario> query = manager.createQuery(jpql, Usuario.class);
//        query.setMaxResults(4);
//
//        List<Usuario>  usuarios = query.getResultList();

        List<Usuario> usuarios = manager
                .createQuery("select u from Usuario u", Usuario.class)
                .setMaxResults(4)
                .getResultList();

        for(Usuario usuario: usuarios){
            System.out.println("Id: " + usuario.getId()
                + " -> Nome: " + usuario.getNomeUsuario());
        }

        manager.close();
        factory.close();
    }

}
