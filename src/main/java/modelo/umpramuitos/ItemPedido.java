package modelo.umpramuitos;

import lombok.Data;
import modelo.basico.Produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private Pedido pedido;

    // esse é o valor default de fecth (...ToOne -> EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    @Column(nullable = false)
    private int quantidade;

    @Column(nullable = false)
    private Double preco;

    public ItemPedido() {

    }

    public ItemPedido(Pedido pedido, Produto produto, int quantidade) {
        this.setPedido(pedido) ;
        this.setProduto(produto);
        this.setQuantidade(quantidade);
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        if(produto != null && this.preco == null){
            this.setPreco(produto.getPreco());
        }

    }
}
