package teste.umpraum;


import daoinfra.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {
    public static void main(String[] args) {

        Assento assento = new Assento("52F");
        Cliente cliente = new Cliente("João Roberto", assento);

        DAO<Cliente> dao = new DAO<>(Cliente.class);



    }
}
