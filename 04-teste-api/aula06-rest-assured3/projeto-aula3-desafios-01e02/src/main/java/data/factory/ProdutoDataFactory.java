package data.factory;

import model.Produto;
import net.datafaker.Faker;
import org.apache.commons.lang3.StringUtils;

import java.util.Locale;
import java.util.Random;

public class ProdutoDataFactory {

    private static Faker faker = new Faker(new Locale("PT-BR"));
    private static Random geradorBoolean = new Random();

    private ProdutoDataFactory() {}

    public static Produto produtoValido() {
        return novoProduto();
    }

    public static Produto produtoComDadosAusentes() {
        Produto produtoSemDados = novoProduto();
        produtoSemDados.setNome(StringUtils.EMPTY);
        produtoSemDados.setDescricao(StringUtils.EMPTY);
        produtoSemDados.setPreco(StringUtils.EMPTY);
        produtoSemDados.setQuantidade(StringUtils.EMPTY);

        return produtoSemDados;
    }

    private static Produto novoProduto() {
        Produto novoProduto = new Produto();
        novoProduto.setNome(faker.commerce().brand() + " " + faker.commerce().productName());
        novoProduto.setPreco(String.valueOf((faker.number().numberBetween(1, 1000))));
        novoProduto.setDescricao(faker.lorem().characters(10, 100));
        novoProduto.setQuantidade(String.valueOf((faker.number().numberBetween(1, 100))));

        return novoProduto;
    }

    public static Produto produtoComQtdEPrecoZero(){
        Produto produtoComQtdEPrecoZero = novoProduto();
        produtoComQtdEPrecoZero.setQuantidade("0");
        produtoComQtdEPrecoZero.setPreco("0");

        return produtoComQtdEPrecoZero;
    }

    public static Produto produtoComQtdZero() {
        Produto produtoComQtdZero = novoProduto();
        produtoComQtdZero.setQuantidade("0");

        return produtoComQtdZero;
    }

    public static Produto produtoComPrecoZero() {
        Produto produtoComPrecoZero = novoProduto();
        produtoComPrecoZero.setPreco("0");

        return produtoComPrecoZero;
    }

    public static Produto produtoComNomeVazio() {
        Produto produtoComNomeVazio = novoProduto();
        produtoComNomeVazio.setNome(StringUtils.EMPTY);

        return produtoComNomeVazio;
    }

    public static Produto produtoComNomeNulo() {
        Produto produtoComNomeNulo = novoProduto();
        produtoComNomeNulo.setNome(null);

        return produtoComNomeNulo;
    }

    public static Produto produtoComNomeComEspacos() {
        Produto produtoComNomeComEspacos = novoProduto();
        produtoComNomeComEspacos.setNome("   ");

        return produtoComNomeComEspacos;
    }

    public static Produto produtoComNomeComCaracteresEspeciais() {
        Produto produtoComNomeComCaracteresEspeciais = novoProduto();
        produtoComNomeComCaracteresEspeciais.setNome(faker.lorem().characters(10, 100) + "çãõáéíóú");

        return produtoComNomeComCaracteresEspeciais;
    }

    public static Produto produtoComDescricaoVazia() {
        Produto produtoComDescricaoVazia = novoProduto();
        produtoComDescricaoVazia.setDescricao(StringUtils.EMPTY);

        return produtoComDescricaoVazia;
    }

    public static Produto produtoComDescricaoNula() {
        Produto produtoComDescricaoNula = novoProduto();
        produtoComDescricaoNula.setDescricao(null);

        return produtoComDescricaoNula;
    }

    public static Produto produtoComDescricaoComEspacos() {
        Produto produtoComDescricaoComEspacos = novoProduto();
        produtoComDescricaoComEspacos.setDescricao("   ");

        return produtoComDescricaoComEspacos;
    }

    public static Produto produtoComNomeExtenso() {
        Produto novoProduto = new Produto();
        novoProduto.setNome(faker.lorem().characters(600000, 600001));
        novoProduto.setPreco(String.valueOf((faker.number().numberBetween(1, 1000))));
        novoProduto.setDescricao(faker.lorem().characters(10, 100));
        novoProduto.setQuantidade(String.valueOf((faker.number().numberBetween(1, 100))));

        return novoProduto;
    }

}
