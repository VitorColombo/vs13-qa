public interface Movimentacao {

    boolean depositar(double valor);

    boolean transferir(Conta beneficiario, double valor);

    boolean sacar(double valor);

}


