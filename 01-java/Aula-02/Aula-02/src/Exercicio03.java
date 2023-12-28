import java.util.Scanner;

public class Exercicio03 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String nome;
        double altura, peso;
        int idade;
        int qtdJogadores = 0;
        double maiorAltura = 0;
        double maiorIdade = 0;
        double maiorPeso = 0;
        String jogadorMaisVelho = "";
        String jogadorMaisPesado = "";
        double somaAlturas = 0;

        while (true) {
            System.out.println("Insira o nome do jogador: ");
            nome = scan.nextLine();

            if (nome.equalsIgnoreCase("SAIR")) {
                break;
            }
            System.out.println("Digite a altura do jogador: ");
            altura = scan.nextDouble();

            System.out.println("Digite a idade do jogador: ");
            idade = scan.nextInt();

            System.out.println("Informe o peso: ");
            peso = scan.nextDouble();

            qtdJogadores++;

            somaAlturas += altura;

            if (maiorAltura < altura) {
                maiorAltura = altura;
            }
            if (maiorIdade < idade) {
                maiorIdade = idade;
                jogadorMaisVelho = nome;
            }
            if (maiorPeso < peso) {
                maiorPeso = peso;
                jogadorMaisPesado = nome;
            }
            scan.nextLine();
        }
        double mediaAltura = somaAlturas / qtdJogadores;

        System.out.println("Quantidade de jogadores cadastrados: " + qtdJogadores);
        System.out.println("Altura do maior jogador: " + maiorAltura + " m");
        System.out.println("Jogador mais velho: " + jogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + jogadorMaisPesado);
        System.out.println("Média das alturas dos jogadores: " + mediaAltura + " m");
    }
}
