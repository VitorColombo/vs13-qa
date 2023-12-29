public class ContaCorrente {
    public Cliente cliente;
    public String numeroConta;
    public String agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente() {
        System.out.println("\nContaCorrente - " +
                " \ncliente: " + cliente.nome +
                " \nnumeroConta: " + this.numeroConta +
                " \nagencia: " + this.agencia +
                " \nsaldo: " + this.saldo +
                " \nchequeEspecial: " + chequeEspecial +
                " \nsaldo + cheque especial: " + retornarSaldoComChequeEspecial());
    }

    public boolean sacar(double valor){
        if(valor > this.retornarSaldoComChequeEspecial())
            return false;
        if(valor <= 0)
            return false;
        saldo -= valor;
        return true;
    }

    public boolean depositar(double valor){
        if(valor <= 0)
            return false;
        saldo += valor;
        return true;
    }

    public double retornarSaldoComChequeEspecial(){
        return chequeEspecial + saldo;
    }

    public boolean transferir(ContaCorrente beneficiario, double valor){
        if(sacar(valor)){
            beneficiario.depositar(valor);
            return true;
        }
        return false;
    }
}
