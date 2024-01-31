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

    public static Produto produtoComQtdEPrecoZero() {
        Produto produtoComQtdZero = novoProduto();
        produtoComQtdZero.setQuantidade("0");
        produtoComQtdZero.setPreco("0");

        return produtoComQtdZero;
    }

    public static Produto produtoComNomeExtenso() {
        Produto novoProduto = new Produto();
        novoProduto.setNome(faker.lorem().characters(30000, 30001));
        novoProduto.setPreco(String.valueOf((faker.number().numberBetween(1, 1000))));
        novoProduto.setDescricao(faker.lorem().characters(10, 100));
        novoProduto.setQuantidade(String.valueOf((faker.number().numberBetween(1, 100))));

        return novoProduto;
    }


}
