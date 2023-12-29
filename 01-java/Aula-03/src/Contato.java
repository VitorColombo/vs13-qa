public class Contato {
    public String descricao;
    public String telefone;
    public int tipo;

    public void imprimirContato() {
        if (tipo == 1){
            System.out.println("\n---Contato Residencial---\n" + "descricao: " + this.descricao + ", telefone: " + this.telefone);
        }
        else if (tipo == 2){
            System.out.println("\n---Contato Comercial---\n" + "descricao: " + this.descricao + ", telefone: " + this.telefone);
        }
    }
}
