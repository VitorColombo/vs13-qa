import java.util.Scanner;

public class Exercicio06 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numeros = {2,34,56,6,6,12,1,3,5,1};
        int numUser;
        int qtdMenores = 0, qtdMaiores = 0, qtdIguais = 0;

        System.out.println("Digite um numero: ");
        numUser = scan.nextInt();

        for(int numero : numeros){
            if(numero == numUser){
                qtdIguais++;
            }
            if(numUser > numero){
                qtdMenores++;
            }
            if(numUser < numero){
                qtdMaiores++;
            }
        }
        System.out.println("O numero " + numUser + " aparece " + qtdIguais + " vezes no array");
        System.out.println("Existem " + qtdMenores + " numeros menores que " + numUser);
        System.out.println("Existem " + qtdMaiores + " numeros maiores que " + numUser);
    }
}