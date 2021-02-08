package daoinfra;

import modelo.basico.Produto;

import java.util.List;

public class ObterProdutos {
    public static void main(String[] args) {

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.obterTodos();
        for (Produto produto: produtos){
            System.out.println("Id: " + produto.getId() + ", Nome: "
                                + produto.getNome());
        }

//        double precoTotal = produtos
//                .stream()
//                .map(Produto::getPreco)
//                .reduce(0.0, Double::sum);

//        Double acc = 0.0;
//        for (Produto p : produtos) {
//            Double preco = p.getPreco();
//            acc = acc + preco;
//        }
//        double precoTotal = acc
//                .doubleValue();

        double precoTotal = produtos
                .stream()
                .map(p ->p.getPreco())
                .reduce(0.0, (t,p) -> t + p)
                .doubleValue();

        System.out.println("Valor total é R$ " + precoTotal);
    }
}
