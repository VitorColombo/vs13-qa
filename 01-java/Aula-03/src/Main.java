import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Endereco endereco1 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rua das Flores";
        endereco1.numero = 123;
        endereco1.complemento = "Apto 2";
        endereco1.cep = "12345-678";
        endereco1.cidade = "Cidade A";
        endereco1.estado = "RS";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 2;
        endereco2.logradouro = "Avenida Principal";
        endereco2.numero = 456;
        endereco2.complemento = "Sala 101";
        endereco2.cep = "82921-876";
        endereco2.cidade = "Cidade B";
        endereco2.estado = "SC";
        endereco2.pais = "Brasil";

        Contato contatoResidencial = new Contato();
        contatoResidencial.tipo = 1;
        contatoResidencial.descricao = "Fixo da casa";
        contatoResidencial.telefone = "367843210";

        Contato contatoComercial = new Contato();
        contatoComercial.tipo = 2;
        contatoComercial.descricao = "Telefone da firma";
        contatoComercial.telefone = "986543210";

        Cliente cliente1 = new Cliente();
        cliente1.nome = "Leticia";
        cliente1.cpf = "12345678";
        cliente1.enderecos[0] = endereco2;
        cliente1.enderecos[1] = endereco1;
        cliente1.contatos[0] = contatoResidencial;
        cliente1.contatos[1] = contatoComercial;

        Endereco endereco3 = new Endereco();
        endereco3.tipo = 1;
        endereco3.logradouro = "viela B";
        endereco3.numero = 789;
        endereco3.complemento = "Casa";
        endereco3.cep = "54321-876";
        endereco3.cidade = "Cidade C";
        endereco3.estado = "SE";
        endereco3.pais = "Brasil";

        Contato contatoResidencial2 = new Contato();
        contatoResidencial2.tipo = 1;
        contatoResidencial2.descricao = "Telefone fixo casa";
        contatoResidencial2.telefone = "196543210";

        Cliente cliente2 = new Cliente();
        cliente2.nome = "Vitor";
        cliente2.cpf = "87654321";
        cliente2.enderecos[0] = endereco3;
        cliente2.contatos[0] = contatoResidencial2;

        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.cliente = cliente1;
        contaCorrente1.numeroConta = "1852";
        contaCorrente1.saldo = 2000;
        contaCorrente1.agencia = "1";
        contaCorrente1.chequeEspecial = 500;

        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.cliente = cliente2;
        contaCorrente2.numeroConta = "2321";
        contaCorrente2.saldo = 100;
        contaCorrente2.agencia = "2";
        contaCorrente2.chequeEspecial = 3000;


        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.impimirEnderecos();
        contaCorrente1.imprimirContaCorrente();
        System.out.println("\n");
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.impimirEnderecos();
        contaCorrente2.imprimirContaCorrente();

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

        contaCorrente1.imprimirContaCorrente();
        System.out.println("\n");
        contaCorrente2.imprimirContaCorrente();
    }
}