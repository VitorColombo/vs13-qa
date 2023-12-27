import java.util.Scanner;

public class Questao03 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Selecione a opção:\n1. Traduzir de Inglês para Português\n2. Traduzir de Português para Inglês");
        int op = scan.nextInt();
        scan.nextLine();
        switch (op) {
            case 1:
                System.out.println("Digite a palavra em Inglês:");
                String palavraIngles = scan.nextLine();
                String palavraTraduzidaIngles;
                switch (palavraIngles.toLowerCase()) {
                    case "dog":
                        palavraTraduzidaIngles = "Cachorro";
                        break;
                    case "time":
                        palavraTraduzidaIngles = "Tempo";
                        break;
                    case "love":
                        palavraTraduzidaIngles = "Amor";
                        break;
                    case "city":
                        palavraTraduzidaIngles = "Cidade";
                        break;
                    case "happy":
                        palavraTraduzidaIngles = "Feliz";
                        break;
                    case "sad":
                        palavraTraduzidaIngles = "Triste";
                        break;
                    case "should":
                        palavraTraduzidaIngles = "Deveria";
                        break;
                    case "could":
                        palavraTraduzidaIngles = "Poderia";
                        break;
                    default:
                        palavraTraduzidaIngles = null;
                        break;
                }
                if (palavraTraduzidaIngles != null) {
                    System.out.println("\nTradução: " + palavraTraduzidaIngles);
                } else {
                    System.out.println("Essa palavra não é válida.\n\n");
                }
                break;
            case 2:
                System.out.println("Digite a palavra em Português:");
                String palavraPortugues = scan.nextLine();
                String palavraTraduzidaPortugues;
                switch (palavraPortugues.toLowerCase()) {
                    case "cachorro":
                        palavraTraduzidaPortugues = "Dog";
                        break;
                    case "tempo":
                        palavraTraduzidaPortugues = "Time";
                        break;
                    case "amor":
                        palavraTraduzidaPortugues = "Love";
                        break;
                    case "cidade":
                        palavraTraduzidaPortugues = "City";
                        break;
                    case "feliz":
                        palavraTraduzidaPortugues = "Happy";
                        break;
                    case "triste":
                        palavraTraduzidaPortugues = "Sad";
                        break;
                    case "deveria":
                        palavraTraduzidaPortugues = "Should";
                        break;
                    case "poderia":
                        palavraTraduzidaPortugues = "Could";
                        break;
                    default:
                        palavraTraduzidaPortugues = null;
                        break;
                }
                if (palavraTraduzidaPortugues != null) {
                    System.out.println("\nTradução: " + palavraTraduzidaPortugues);
                } else {
                    System.out.println("Essa palavra não é válida.\n\n");
                }
                break;
            default:
                System.out.println("Opcao inválida!!!\n");
                break;
        }
    }
}

