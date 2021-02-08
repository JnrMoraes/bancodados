package daoinfra;


import modelo.basico.Produto;

public class NovoProduto {
    public static void main(String[] args) {

        Produto produto = new Produto("Livro", 62.90);
        Produto produto1 = new Produto("Notebook", 3599.59);

        DAO<Produto> dao = new DAO<>(Produto.class);
//        dao.abrirTransacao().incluir(produto).fecharTransacao().fechar();

        dao.incluirAtomico(produto1);


    }
}
