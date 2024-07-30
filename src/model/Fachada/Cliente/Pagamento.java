package model.Fachada.Cliente;

public class Pagamento{
    private final Conta conta;
    private final double valor;

    public Pagamento(Conta conta, double valor) {
        this.conta = conta;
        this.valor = valor;
    }

    public boolean pagar(double total) {
        if(conta.getSaldo() < total){
            return false;
        }
        return conta.saque(total);

    }

    public Conta getConta() {
        return conta;
    }


    public double getValor() {
        return valor;
    }

}

