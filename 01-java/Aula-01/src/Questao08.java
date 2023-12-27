import java.util.Scanner;

public class Questao08 {
    public static void main(String[] args) {
        double salario, nvSalario;
        String cargo;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite seu cargo: ");
        cargo = scan.nextLine();
        System.out.println("Digite seu salario: ");
        salario = scan.nextDouble();
        //pede para usar o cargo e nao o codigo
        if (cargo.equals("Gerente")){
            nvSalario = salario + salario * 0.1;
        }
        else if (cargo.equals("Engenheiro")){
            nvSalario = salario + salario * 0.2;
        }
        else if(cargo.equals("Tecnico")){
            nvSalario = salario + salario * 0.3;
        }
        else{
            nvSalario = salario + salario * 0.4;
        }
        System.out.println("Seu salario aumentou R$" + (nvSalario-salario) + ". Passou de R$" + salario + " para R$" + nvSalario + ".");
    }
}
