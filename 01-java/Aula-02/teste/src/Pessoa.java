public class Pessoa {
    public String nome;
    public String sobrenome;
    public int idade;

    public String zap;

    public void conversar(Pessoa ouvinte){
        System.out.println("Olá " + ouvinte.nome);
        System.out.println("Olá " + this.nome);
    }
    public void retornarNomeCompleto(){
        System.out.println(this.nome + " " + this.sobrenome);
    }

    public boolean ehMaiorDeIdade(){
        if(this.idade >= 18){
            return true;
        }
        return false;
    }

    public void mandarZap(Pessoa pessoa, String msg){
        System.out.println(this.nome + " enviou: " + msg + " para " + pessoa.nome);
    }
}
