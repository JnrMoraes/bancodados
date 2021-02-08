package teste.umpraum;


import daoinfra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {

    public static void main(String[] args) {

        DAO<Cliente> clienteDAO = new DAO(Cliente.class);
        Cliente cliente = clienteDAO.obterPorID(4L);
        System.out.println(cliente.getAssento().getNome() + " Pelo Cliente \n");
        clienteDAO.fechar();

        DAO<Assento> assentoDAO = new DAO<>(Assento.class);
        Assento assento = assentoDAO.obterPorID(4L);
        System.out.println(assento.getCliente().getNome() + " Pelo Assento");
        assentoDAO.fechar();


//        System.out.println(cliente.getAssento().getCliente().getNome());

    }
}
