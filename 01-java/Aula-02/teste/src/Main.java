

public class Main {
    public static void main(String[] args) {
    Pessoa robisvelton = new Pessoa();
    Pessoa josinei = new Pessoa();

    robisvelton.nome = "Robisvelton";
    robisvelton.sobrenome = "Costa da Silva";
    robisvelton.idade = 12;
    robisvelton.zap = "22222";

    josinei.nome = "Josinei";
    josinei.sobrenome = "Calabresa";
    josinei.idade = 20;
    josinei.zap = "11111";

    robisvelton.conversar(josinei);
    if(robisvelton.ehMaiorDeIdade()){
        System.out.println( robisvelton.nome + " demaior");
    }else{
        System.out.println(robisvelton.nome + " demenor");
    }
    robisvelton.mandarZap(josinei, "eai porra");
    robisvelton.retornarNomeCompleto();
    josinei.retornarNomeCompleto();

    }
}