import java.util.Scanner;

public class Exercicio04 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [][] alunos = new int[5][4];
        int [] notaFinal = new int[5];
        int maiorNotaF = 0;
        int matriculaMaiorNota = 0;
        int somaNotasFinais = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Informe a matrícula do aluno:");
            alunos[i][0] = scan.nextInt();

            System.out.println("Informe a média das provas:");
            alunos[i][1] = scan.nextInt();

            System.out.println("Informe a média dos trabalhos:");
            alunos[i][2] = scan.nextInt();

            alunos[i][3] = (int) ((alunos[i][1] * 0.6) + (alunos[i][2] * 0.4));

            if (alunos[i][3] > maiorNotaF) {
                maiorNotaF = alunos[i][3];
                matriculaMaiorNota = alunos[i][0];
            }
            somaNotasFinais += alunos[i][3];
        }
        System.out.println("Matricula da maior nota final: " + matriculaMaiorNota);
        System.out.println("Média das notas finais: " + (somaNotasFinais/5));

    }
}