package pessoa;
import interfaces.Filtro;

import java.util.ArrayList;
import java.util.Objects;

public class PessoaCadastro {

    private ArrayList<Pessoa> lista;

    public PessoaCadastro(){
        this.lista = new ArrayList<>();
    }

    //create pessoa
    public void adicionar(Pessoa pessoa){
        lista.add(pessoa);
    }

    public ArrayList<Pessoa> listarTodos(){
        return lista;
    }

    public void visualizar(){
        int i = 0;
        for(Pessoa pessoa : lista){
            System.out.println((i) + " - " + pessoa.toString());
            i++;
        }
    }

    public ArrayList<Pessoa> consultar(Filtro<Pessoa> filtro){
        ArrayList<Pessoa> listaFiltrada = new ArrayList<>();
        for(Pessoa pessoa : lista){
            if(filtro.avaliar(pessoa)){
                listaFiltrada.add(pessoa);
            }
        }
        return listaFiltrada;
    }

    public void editar(int index, Pessoa pessoaEditada){
        if(pessoaEditada == null){
            return;
        }

        Pessoa pessoa = lista.get(index);
        pessoa.setNome(pessoaEditada.getNome());
        pessoa.setIdade(pessoaEditada.getIdade());
        System.out.println("Edição concluída!");
    }

    public void remover(Pessoa pessoa){
        lista.remove(pessoa);
    }
}
