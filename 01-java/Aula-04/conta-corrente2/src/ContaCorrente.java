public class ContaCorrente extends Conta implements Impressao {

    private double chequeEspecial;

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo, double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }
    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
    public boolean sacar(double valor){
        if(valor > this.retornarSaldoComChequeEspecial())
            return false;
        else if (valor <= 0)
            return false;
        double novoSaldo = getSaldo();
        novoSaldo -= valor;
        setSaldo(novoSaldo);
        return true;
    }

    public boolean depositar(double valor){
        if(valor <= 0)
            return false;
        double novoSaldo = getSaldo();
        novoSaldo += valor;
        setSaldo(novoSaldo);
        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        return chequeEspecial + getSaldo();
    }

    public void imprimir() {
        System.out.println("ContaCorrente - " +
                " cliente: " + getCliente().getNome() +
                " numeroConta: " + getNumeroConta() +
                " agencia: " + getAgencia() +
                " saldo: " + getSaldo() +
                " chequeEspecial: " + chequeEspecial +
                " saldo + cheque especial: " + retornarSaldoComChequeEspecial());
    }
}
