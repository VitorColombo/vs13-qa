public class Endereco {
    public int tipo;
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco(){
        if (tipo == 1) {
            System.out.println("Endereco Residencial- " + this.cep + " " + this.pais + " - " + this.estado + " " + this.cidade + " " + this.logradouro + ", " + this.numero + " " + this.complemento);
        }
        else if (tipo == 2){
            System.out.println("Endereco Comercial- " + this.cep + " " + this.pais + " - " + this.estado + " " + this.cidade + " " + this.logradouro + ", " + this.numero + " " + this.complemento);
        }
    }
}
