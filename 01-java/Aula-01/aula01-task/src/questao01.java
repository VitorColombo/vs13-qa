import java.util.Scanner;

public class questao01 {
    public static void main (String[] args) {
    Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String name = scan.nextLine();

        System.out.println("Digite sua idade: ");
        int age = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite sua cidade de origem: ");
        String city = scan.nextLine();

        System.out.println("Digite o estado de origem: ");
        String state = scan.nextLine();

        System.out.println("Olá seu nome é " + name + ", você tem " + age + " anos, é da cidade de " + city + " situada no estado de " + state + ".");

    }
}