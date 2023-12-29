public class Cliente {
    public String nome;
    public String cpf;
    public Contato contatos[] = new Contato[2];
    public Endereco enderecos[] = new Endereco[2];

    public void imprimirContatos(){
        for(Contato contato: contatos){
            if(contato == null){
                break;
            }
            contato.imprimirContato();
        }
    }
    public void impimirEnderecos(){
        for(Endereco endereco: enderecos){
            if(endereco == null){
                break;
            }
            endereco.imprimirEndereco();
        }
    }
    public void imprimirCliente(){
        System.out.println("Nome: " + this.nome + "\nCPF: " + this.cpf);
    }
}
