package teste.umpraum;


import daoinfra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
    public static void main(String[] args) {
        Assento assento = new Assento("37D");
        Cliente cliente = new Cliente("Thiago",assento);

        DAO<Object> dao = new DAO();
        dao.abrirTransacao()
                .incluir(assento)
                .incluir(cliente)
                .fecharTransacao()
                .fechar();

    }
}
