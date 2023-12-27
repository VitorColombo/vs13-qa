import java.util.Scanner;

public class Questao09 {
    public static void main(String[] args) {
        int horaIni, horaFinal, minutosIni, minutosFinal;
        int ht,mt;
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a hora de inicio: ");
        horaIni = scan.nextInt();
        System.out.println("Digite os minutos de inicio: ");
        minutosIni = scan.nextInt();
        System.out.println("Digite a hora de fim: ");
        horaFinal = scan.nextInt();
        System.out.println("Digite os minutos do fim: ");
        minutosFinal = scan.nextInt();

        if ((horaFinal > horaIni && minutosFinal >= minutosIni) || (horaFinal == horaIni && minutosFinal >= minutosIni)) {
            ht = horaFinal - horaIni;
            mt = minutosFinal - minutosIni;
        } else if(horaFinal > horaIni && minutosIni > minutosFinal){
            ht = horaFinal - horaIni - 1;
            mt = (60 - minutosIni) + minutosFinal;
        }else {
            ht = (24 - horaIni) + horaFinal;
            mt = (60 - minutosIni) + minutosFinal;
            ht--;
        }
        if (mt >= 60) {
            mt -= 60;
            ht++;
        }

        System.out.println("Tempo gasto: " + ht + "h" + mt + ".");
    }
}
