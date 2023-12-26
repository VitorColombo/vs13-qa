import java.util.Scanner;

public class questao02 {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Selecione seu estado:\n1.Rio Grande do Sul\n2.Santa Catarina\n3.Parana");
        int op = scan.nextInt();
        if(op == 1){//loop RS
            System.out.println("1. Imbé");
            System.out.println("2. Porto Alegre");
            int subop = scan.nextInt();

            if (subop == 1) {
                System.out.println("---IMBÉ/RIO GRANDE DO SUL---");
                System.out.println("População: 26.824");
                System.out.println("Principal festa: Festa do peixe");
                System.out.println("IDH: 0,764");
            } else if (subop == 2) {
                System.out.println("---PORTO ALEGRE/RIO GRANDE DO SUL---");
                System.out.println("Capital do estado do Rio Grande do Sul");
                System.out.println("População: 1.492.530");
                System.out.println("Principal festa: jogo do Internacional");
                System.out.println("IDH: 0,805");
            } else {
                System.out.println("Digite um número valido!");
            }
        } else if(op == 2){//loop SC
            System.out.println("1. Itapema");
            System.out.println("2. Florianópolis");
            int subop = scan.nextInt();

            if (subop == 1) {
                System.out.println("---ITAPEMA/SANTA CATARINA---");
                System.out.println("População: 67.338");
                System.out.println("Principal festa: Show de águas do Shopping 2000");
                System.out.println("IDH: 0,764");
            } else if (subop == 2) {
                System.out.println("---FLORIANÓPOLIS/SANTA CATARINA---");
                System.out.println("Capital do estado de Santa Catarina");
                System.out.println("População: 537.211");
                System.out.println("Principal festa: Lollapalooza");
                System.out.println("IDH: 0,847");
            } else {
                System.out.println("Digite um número valido!");
            }
        } else if(op == 3){//loop PR
            System.out.println("1. Curitiba");
            System.out.println("2. Ponta Grossa");
            int subop = scan.nextInt();

            if (subop == 1) {
                System.out.println("---CURITIBA/PARANÁ---");
                System.out.println("Capital do estado do Paraná");
                System.out.println("População: 1.773.733");
                System.out.println("Principal festa: Show dos amigos");
                System.out.println("IDH: 0,856");
            } else if (subop == 2) {
                System.out.println("---PONTA GROSSA/PARANÁ---");
                System.out.println("População: 358.367");
                System.out.println("Principal festa: Pesca náutica avançada");
                System.out.println("IDH: 0,756");
            } else {
                System.out.println("Digite um número valido!");
            }
        } else {
            System.out.println("Digite um número valido!");
        }
    }
}
