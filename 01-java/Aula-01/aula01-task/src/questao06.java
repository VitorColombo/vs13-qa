import java.util.Scanner;

public class questao06 {
    public static void main(String[] args) {

        Scanner scan = new Scanner (System.in);
        int eleitores, votosBrancos, votosNulos, votosValidos;
        float pctBrancos, pctNulos, pctValidos;

        System.out.println("Digite o numero total de eleitores do município: ");
        eleitores = scan.nextInt();
        System.out.println("Digite o numero de votos brancos: ");
        votosBrancos = scan.nextInt();
        System.out.println("Digite o numero votos nulos: ");
        votosNulos = scan.nextInt();
        System.out.println("Digite o numero de votos validos: ");
        votosValidos = scan.nextInt();
        if(eleitores != (votosBrancos + votosNulos + votosValidos)){
            System.out.println("Dados inválidos!");
        }else {
            pctValidos = (votosValidos * 100.0f) / eleitores;
            pctNulos = (votosNulos * 100.0f) / eleitores;
            pctBrancos = (votosBrancos * 100.0f) / eleitores;

            System.out.printf("Total de eleitores: %d\n", eleitores);
            System.out.printf("Votos válidos: %.2f%%\n", pctValidos);
            System.out.printf("Votos nulos: %.2f%%\n", pctNulos);
            System.out.printf("Votos em branco: %.2f%%\n", pctBrancos);
        }
    }
}
