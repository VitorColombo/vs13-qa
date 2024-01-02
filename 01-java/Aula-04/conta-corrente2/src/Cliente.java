
import java.util.ArrayList;
import java.util.List;
public class Cliente {
    private String nome;
    private String cpf;
    private List <Endereco> enderecos = new ArrayList<>(2);
    private List <Contato> contatos = new ArrayList<>(2);

    public Cliente(String nome, String cpf, Endereco endereco, Contato contato) {
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos.add(endereco);
        this.contatos.add(contato);
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    void imprimirContatos(){
        for (Contato cont: contatos) {
            if(cont == null){
                break;
            }
            cont.imprimirContato();
        }
    }
    void imprimirEnderecos(){
        for (Endereco end:enderecos) {
            if(end == null){
                break;
            }
            end.imprimirEndereco();
        }
    }
    void imprimirCliente(){
        System.out.println("----CLIENTE----\nNome: " + this.nome + "\nCPF: " + this.cpf);
        this.imprimirContatos();
        this.imprimirEnderecos();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public boolean adicionarContato(Contato contato){
        if (contatos.add(contato)){
            return true;
        }
        return false;
    }

    public boolean adicionarEndereco(Endereco endereco){
        if (enderecos.add(endereco)){
            return true;
        }
        return false;
    }
}
