import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
//        Escrever um algoritmo que lê o número de identificação, as 3 notas obtidas por umaluno nas 3verificações e a média dos exercícios
//que fazem parte da avaliação. Calcular a média de
//aproveitamento, usando a fórmula MA = (Nota1 + Nota2 x 2 + Nota3 x 3 + ME )/7
        float n1, n2, n3, me, mf;
        int id;
        String conceito = null;
        String estado = "APROVADO";
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o id do aluno: ");
        id = scan.nextInt();
        System.out.println("Informe nota 1:");
        n1 = scan.nextFloat();
        System.out.println("Informe nota 2:");
        n2 = scan.nextFloat();
        System.out.println("Informe nota 3:");
        n3 = scan.nextFloat();
        System.out.println("Informe nota me:");
        me = scan.nextFloat();

        mf = (n1 + (n2 * 2) + (n3 * 3) + me)/7;
        if(mf < 4){
            conceito = "E";
            estado = "REPROVADO";
        }
        else if(4 <= mf && mf < 6){
            conceito = "D";
            estado = "REPROVADO";
        }
        else if(6 <= mf && mf < 7.5 ){
            conceito = "C";
        }
        else if(7.5 <= mf && mf < 9){
            conceito = "B";
        }
        else if(9 <= mf && mf <= 10){
            conceito = "A";
        }
        System.out.println("ID: " + id + "\nN1:" + n1 + "\nN2:" + n2 + "\nN3:" + n3 + "\nME:" + me + ".\nSua media de aproveitamento foi: " + mf + " tendo sido "+ estado + " com conceito:" + conceito);

    }
}
