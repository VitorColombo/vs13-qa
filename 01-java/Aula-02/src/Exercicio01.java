import java.util.Scanner;

public class Exercicio01 {
    public static void main(String[] args) {
        double desconto[] = {0.05, 0.1, 0.15, 0.20, 0.25, 0.30, 0.35, 0.40, 0.45, 0.50};
        double prodPrice;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o nome do produto: ");
        String prodName = scan.nextLine();
        System.out.println("Insira o valor: ");
        prodPrice = scan.nextDouble();

        System.out.println("Produto: " + prodName);
        System.out.println("Preço R$: " + prodPrice);
        System.out.println("Promoção: " + prodName);
        System.out.println("----------------------");

        for (int i = 0; i < desconto.length; i++) {
            double discountedPrice = prodPrice - (prodPrice * desconto[i]);
            System.out.println((i + 1) + " x R$ " + String.format("%.2f", discountedPrice) + " = R$ " + String.format("%.2f", discountedPrice * (i+1)));
        }
    }
}
