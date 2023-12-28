
public class Exercicio05 {
    public static void main(String[] args) {
        float[] precoFinalMercados = new float[3];
        float [][] precosProdutos =
                {{1, 2, 3},
                {100, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 200, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3},
                {1, 2, 3}};

        for(int i = 0; i < 3; i++){
            float total = 0;
            for(int j = 0; j < 10; j++){
                total += precosProdutos[j][i];
            }
            precoFinalMercados[i] = total;
        }
        int mercadoMaisBarato = 0;
        for (int i = 0; i < 3; i++) {
            System.out.println("Mercado " + (i+1) + ": " + precoFinalMercados[i]);
            if (precoFinalMercados[i] < precoFinalMercados[mercadoMaisBarato]) {
                mercadoMaisBarato = i;
            }
        }
        System.out.println("O mercado mais barato é o Mercado " + (mercadoMaisBarato + 1));
    }
}