import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Endereco endereco1 = new Endereco("Brasil", "Cidade A", "12345-678", "Apto 2", 1, "RS", "Rua das Flores", 123);
        Endereco endereco2 = new Endereco("Brasil", "Cidade B", "82921-876","Sala 101", 2, "SC","Avenida Principal", 456);
        ArrayList <Endereco> enderecos1 = new ArrayList<>(2);
        enderecos1.add(endereco1);
        enderecos1.add(endereco2);

        Contato contatoResidencial = new Contato(1, "Fixo da casa", "367843210");
        Contato contatoComercial = new Contato(2, "Telefone da firma", "986543210");

        Cliente cliente1 = new Cliente("Leticia", "12345678", enderecos1, contatoResidencial);
        cliente1.adicionarContato(contatoComercial);

        Endereco endereco3 = new Endereco("Brasil", "Cidade C", "54321-876","Casa", 1, "SE","viela B", 789);
        Contato contatoResidencial2 = new Contato(1, "Telefone fixo casa", "196543210");

        Cliente cliente2 = new Cliente("Vitor", "87654321", endereco3, contatoResidencial2);

        ContaCorrente contaCorrente2 = new ContaCorrente(cliente2, "2321", "2", 100, 3000);
        ContaPoupanca contaPoupanca1 = new ContaPoupanca(cliente2, "3123",  "4", 0);
        ContaCorrente contaCorrente1 = new ContaCorrente(cliente1, "1852", "1", 2000, 500);

        ContaPagamento contaPag1 = new ContaPagamento(cliente1, "2222", "10", 0);

        cliente1.imprimirCliente();
        contaCorrente1.imprimir();
        contaPag1.imprimir();

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
        System.out.println("Depois do saque: " + contaPoupanca1.getSaldo()+"\n");

        ContaCorrente contaCorrente3 = new ContaCorrente(cliente1, "11111",  "1", 0, 200);
        ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente2, "22222",  "2", 200);

        contaPoupanca2.creditarTaxa();
        contaPoupanca2.transferir(contaCorrente3, 200);
        contaCorrente3.depositar(100);
        contaCorrente3.transferir(contaPag1, 300);
        if(contaPag1.sacar(200)){
            System.out.println("Operação concluida com sucesso\n");
        }else{
            System.out.println("Falha na operação\n");
        }
        contaCorrente3.imprimir();
        contaPag1.imprimir();
        contaPoupanca2.imprimir();

    }
}
