package daoinfra;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory factory;
    private EntityManager manager;
    private Class<E> classe;

    static {
        try {
            factory = Persistence
                    .createEntityManagerFactory("dev-UP");
        } catch (Exception e) {
            // logar -> log4j
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        manager = factory.createEntityManager();
    }

    public DAO<E> abrirTransacao() {
        manager.getTransaction().begin();
        return this;
    }

    public DAO<E> fecharTransacao() {
        manager.getTransaction().commit();
        return this;
    }

    public DAO<E> incluir(E entidade) {
        manager.persist(entidade);
        return this;
    }

    public DAO<E> incluirAtomico(E entidade) {
        return this.abrirTransacao().incluir(entidade).fecharTransacao();
    }

    public E obterPorID(Object id) {
        return manager.find(classe, id);
    }

    public List<E> obterTodos() {
        return this.obterTodos(10, 0);
    }

    public List<E> obterTodos(int qtde, int deslocamento) {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe nula.");
        }

        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = manager.createQuery(jpql, classe);
        query.setMaxResults(qtde);
        query.setFirstResult(deslocamento);
        return query.getResultList();
    }

    public List<E> consultar(String nomeConsulta, Object... params) {
        TypedQuery<E> query = manager.createNamedQuery(nomeConsulta, classe);

        for (int i = 0; i < params.length; i += 2) {
            query.setParameter(params[i].toString(), params[i + 1]);
        }

        return query.getResultList();
    }

    public E consultarUm(String nomeConsulta, Object... params) {
        List<E> lista = consultar(nomeConsulta, params);
        return lista.isEmpty() ? null : lista.get(0);
    }

    public void fechar() {
        manager.close();
    }
}
