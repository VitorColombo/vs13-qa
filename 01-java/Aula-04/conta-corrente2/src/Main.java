
public class Main {
    public static void main(String[] args) {

        Endereco endereco1 = new Endereco("Brasil", "Cidade A", "12345-678", "Apto 2", 1, "RS", "Rua das Flores", 123);
        Endereco endereco2 = new Endereco("Brasil", "Cidade B", "82921-876","Sala 101", 2, "SC","Avenida Principal", 456);
        Endereco endereco3 = new Endereco("Brasil", "Cidade C", "54321-876","Casa", 1, "SE","viela B", 789);

        Contato contatoResidencial = new Contato(1, "Fixo da casa", "367843210");
        Contato contatoComercial = new Contato(2, "Telefone da firma", "986543210");
        Contato contatoResidencial2 = new Contato(1, "Telefone fixo casa", "196543210");

        Cliente cliente1 = new Cliente("Leticia", "12345678", endereco2, contatoResidencial);
        cliente1.adicionarEndereco(endereco1);
        cliente1.adicionarContato(contatoComercial);

        Cliente cliente2 = new Cliente("Vitor", "87654321", endereco3, contatoResidencial2);

        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "1852", "1", 2000, 500);
        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "2321", "2", 100, 3000);

        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente2, "3123",  "4", 1000);

        cliente1.imprimirCliente();
        contaCorrente1.imprimir();
        System.out.println("\n");

        cliente2.imprimirCliente();
        contaCorrente2.imprimir();
        contaPoupanca1.imprimir();

        if (contaCorrente1.sacar(10000)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if (contaCorrente1.sacar(-1)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if (contaCorrente1.depositar(-10)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if (contaCorrente1.transferir(contaCorrente2, -200)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if (contaCorrente1.transferir(contaCorrente2, 200)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if (contaCorrente1.sacar(10)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if(contaPoupanca1.sacar(1088880)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        if(contaPoupanca1.depositar(1000)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }

        System.out.println("Antes da taxa: " + contaPoupanca1.getSaldo());
        contaPoupanca1.creditarTaxa();
        System.out.println("Depois da taxa: " + contaPoupanca1.getSaldo());
        contaPoupanca1.sacar(100);
        System.out.println("Depois do saque da taxa: " + contaPoupanca1.getSaldo()+"\n");

        contaCorrente1.imprimir();
        contaCorrente2.imprimir();
        contaPoupanca1.imprimir();

    }
}