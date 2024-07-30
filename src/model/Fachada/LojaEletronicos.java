package model.Fachada;

import model.Fachada.Cliente.Conta;
import model.Fachada.Cliente.Pagamento;
import model.Fachada.Produtos.Estoque;
import model.Fachada.Produtos.Produto;

public class LojaEletronicos {
    private Estoque estoque;
    private Pagamento pagamento;

    public LojaEletronicos() {
        estoque = new Estoque();

    }

    public void adicionarProduto(Produto produto, int quantidade) {
        estoque.adicionarProduto(produto, quantidade);
        System.out.println(quantidade + " unidades de " + produto.getNome() + " adicionadas ao estoque.");
    }

    public void realizarPedido(Produto produto, int quantidade, Conta conta) {
        if (estoque.verificarDisponibilidade(produto, quantidade)) {
            double total = produto.getPreco() * quantidade;
            Pagamento pagamento1 = new Pagamento(conta, total);
            if (pagamento1.pagar(total)) {
                estoque.reduzirEstoque(produto, quantidade);
                System.out.println("Pedido de " + quantidade + " unidade(s) de " + produto.getNome() + " realizado com sucesso.");
            } else {
                System.out.println("Falha no processamento do pagamento.");
            }
        } else {
            System.out.println("Estoque insuficiente para " + produto.getNome() + ".");
        }
    }


}
