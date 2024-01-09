import pessoa.Pessoa;
import pessoa.PessoaCadastro;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        PessoaCadastro lista = new PessoaCadastro();
        lista.adicionar(new Pessoa("Leticia", 27));
        lista.adicionar(new Pessoa("Vitor", 27));
        lista.adicionar(new Pessoa("Pedro", 27));

        lista.visualizar();

        lista.editar(2, new Pessoa("Roberto", 10));

        lista.visualizar();

        //passando o filtro com lambda expressions
        //lambda interpreta a interface funcional
        System.out.println(lista.consultar(pessoa -> pessoa.getIdade() > 18));
        System.out.println(lista.consultar(pessoa -> pessoa.getNome() == "Vitor"));
        System.out.println(lista.consultar(pessoa -> pessoa.getNome().contains("o")));
        //Arraylist::new
        //Pessoa::getIdade == pessoa -> pessoa.getIdade()
        //sort(Comparator())
    }
}