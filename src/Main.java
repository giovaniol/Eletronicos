import model.Fachada.Cliente.Conta;
import model.Fachada.LojaEletronicos;
import model.Fachada.Produtos.Produto;

public class Main {
    public static void main(String[] args) {


        LojaEletronicos loja = new LojaEletronicos();
        Conta conta = new Conta(123, "Giovani");
        Produto tv = new Produto("televisao", 1500);

        loja.adicionarProduto(tv, 1);
        loja.realizarPedido(tv, 1, conta);
        // erro de pagamento
        conta.deposito(10000000);
        loja.realizarPedido(tv, 1, conta);

    }
}
