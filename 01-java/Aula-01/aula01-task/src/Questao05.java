import java.util.Scanner;

public class Questao05 {
    public static void main(String[] args) {

    float base, height, area;
    Scanner scan = new Scanner(System.in);

    System.out.println("Digite a base do retangulo em cm: ");
    base = scan.nextFloat();

    System.out.println("Digite a altura do retangulo em cm: ");
    height = scan.nextFloat();

    area = base * height;

    System.out.println("A area do retangulo é " + area + " cm2!");
    }
}
