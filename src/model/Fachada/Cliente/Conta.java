package model.Fachada.Cliente;

public class Conta {
    private final int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, String cliente) {
        this.numero = numero;
        this.saldo = 0.0;
        this.cliente = new Cliente(cliente);
    }

    public void deposito(double valor) {
        if(valor > 0) {
            saldo += valor;
        }
    }

    public boolean saque(double valor) {
        if(valor > 0) {
            if(saldo >= valor) {
                saldo -= valor;
                return true;
            }
        }
        return false;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return new Cliente(cliente.getNome());
    }


}
