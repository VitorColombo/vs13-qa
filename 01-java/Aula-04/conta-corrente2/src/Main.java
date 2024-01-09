
public class Main {
    public static void main(String[] args) {
        Endereco enderecosCliente1[] = new Endereco[2];
        Endereco endereco1 = new Endereco("Brasil", "Cidade A", "12345-678", "Apto 2", 1, "RS", "Rua das Flores", 123);
        Endereco endereco2 = new Endereco("Brasil", "Cidade B", "82921-876","Sala 101", 2, "SC","Avenida Principal", 456);
        enderecosCliente1[0] = endereco1;
        enderecosCliente1[1] = endereco2;

        Endereco enderecosCliente2[] = new Endereco[2];
        Endereco endereco3 = new Endereco("Brasil", "Cidade C", "54321-876","Casa", 1, "SE","viela B", 789);
        enderecosCliente2[0] = endereco3;

        Contato contatosCliente1[] = new Contato[2];
        Contato contatoResidencial = new Contato(1, "Fixo da casa", "367843210");
        Contato contatoComercial = new Contato(2, "Telefone da firma", "986543210");
        contatosCliente1[0] = contatoResidencial;
        contatosCliente1[1] = contatoComercial;

        Contato contatosCliente2[] = new Contato[2];
        Contato contatoResidencial2 = new Contato(1, "Telefone fixo casa", "196543210");
        contatosCliente2[0] = contatoResidencial2;

        Cliente cliente1 = new Cliente("Leticia", "12345678", enderecosCliente1, contatosCliente1);
        Cliente cliente2 = new Cliente("Vitor", "87654321", enderecosCliente2, contatosCliente2);

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
