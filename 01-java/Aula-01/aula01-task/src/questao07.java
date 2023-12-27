import java.util.Scanner;

public class questao07 {
    public static void main(String[] args) {
        float total, valorProd = 0;
        int qtdProd;
        String codProd;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o código do produto: ");
        codProd = scan.nextLine();
        switch (codProd) {
            case "ABCD":
                valorProd = 5.30F;
                break;
            case "XYPK":
                valorProd = 6.00F;
                break;
            case "KLMP":
                valorProd = 3.20F;
                break;
            case "QRST":
                valorProd = 2.50F;
                break;
            default:
                System.out.println("Código inválido!");
                return;
        }
        System.out.println("Digite a quantidade: ");
        qtdProd = scan.nextInt();
        total = qtdProd * valorProd;
        System.out.printf("Total a pagar: R$" + total);
    }
}
