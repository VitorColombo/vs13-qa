public class ContaPagamento extends Conta implements Impressao{
    private static final double TAXA_SAQUE = 4.25;

    public ContaPagamento(){
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo){
        super(cliente, numeroConta, agencia, saldo);
    }
@Override
    public boolean sacar(double valor){
        if (valor <= 0)
            return false;
        else if(this.getSaldo() < (valor + TAXA_SAQUE))
            return false;
        double novoSaldo = this.getSaldo() - (valor + TAXA_SAQUE);
        this.setSaldo(novoSaldo);
        return true;
    }

    public void imprimir() {
        System.out.println("ContaPagamento - " +
                " cliente: " + getCliente().getNome() +
                " numeroConta: " + getNumeroConta() +
                " agencia: " + getAgencia() +
                " saldo: " + getSaldo() +
                " taxa de saque: " + TAXA_SAQUE);
    }
}
