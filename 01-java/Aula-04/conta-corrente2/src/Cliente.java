
public class Cliente {
    private String nome;
    private String cpf;
    public Endereco enderecos[] = new Endereco[2];
    public Contato contatos[] = new Contato[2];

    public Cliente(String nome, String cpf, Endereco[] enderecos, Contato[] contatos) {
        this.nome = nome;
        this.cpf = cpf;
        this.enderecos = enderecos;
        this.contatos = contatos;
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
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

}
