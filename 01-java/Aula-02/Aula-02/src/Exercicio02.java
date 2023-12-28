import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        int numero;
        int palpite;
        boolean acertou = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Escolha um número para ser adivinhado: ");
        numero = scan.nextInt();

        while(!acertou){
            System.out.println("Chute um número: ");
            palpite = scan.nextInt();
            if(palpite > numero){
                System.out.println("O número a ser encontrado é menor do que você digitou");
            } else if (palpite < numero) {
                System.out.println("O número a ser encontrado é maior do que você digitou");
            }else{
                acertou = true;
            }
      }

    }
}