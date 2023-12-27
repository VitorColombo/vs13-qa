public class questao04 {

    public static void main(String[] args) {

    int a = 10;
    int b = 20;
    System.out.printf("ANTES---> a:" + a + " b:" + b);
    int aux = a;
    a = b;
    b = aux;
    System.out.printf("\nDEPOIS---> a:" + a + " b:" + b);
    }
}
