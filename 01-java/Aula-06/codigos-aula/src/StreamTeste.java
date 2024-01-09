import pessoa.Pessoa;
import pessoa.PessoaCadastro;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamTeste {
    public static void main(String[] args) {

        PessoaCadastro lista = new PessoaCadastro();
        lista.adicionar(new Pessoa("Leticia", 27));
        lista.adicionar(new Pessoa("Vitor", 27));
        lista.adicionar(new Pessoa("Pedro", 27));
        ArrayList<Pessoa> listaFiltrada = new ArrayList<>();

        ArrayList<Pessoa> listaDePessoas = lista.listarTodos();

        listaDePessoas.forEach(pessoa -> System.out.println(pessoa.getNome()));

        ArrayList<Pessoa> listaMaioresDeIdade = listaDePessoas
            .stream()
            .filter(pessoa -> pessoa.getIdade() > 18)
            .collect(Collectors.toCollection(() -> new ArrayList<>()));
            //.collect(Collectors.toCollection(ArrayList::new));
            //o collect faz com que o tipo STREAM seja convertido para o tipo desejado
            //stream só pode ser usado em collections
        System.out.println(listaMaioresDeIdade);

    }
}










