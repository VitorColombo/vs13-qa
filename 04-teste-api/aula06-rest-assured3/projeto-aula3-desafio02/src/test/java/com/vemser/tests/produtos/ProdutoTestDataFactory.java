package com.vemser.tests.produtos;
import io.restassured.response.Response;
import model.Produto;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import static data.factory.ProdutoDataFactory.*;

public class ProdutoTestDataFactory {
    public static Produto dadosAusentes = produtoComDadosAusentes();
    public static Produto precoZero = produtoComPrecoZero();
    public static Produto nomeVazio = produtoComNomeVazio();
    public static Produto nomeNulo = produtoComNomeNulo();
    public static Produto descricaoVazia = produtoComDescricaoVazia();
    public static Produto descricaoNula = produtoComDescricaoNula();

    private static Stream<Arguments> produtosComDadosInvalidos(){
        return Stream.of(
                Arguments.of(dadosAusentes,
                        new String[] {"nome não pode ficar em branco", "descricao não pode ficar em branco", "preco deve ser um número", "quantidade deve ser um número"}
                ),
                Arguments.of(precoZero,
                        new String[] {"preco deve ser um número positivo"}
                ),
                Arguments.of(nomeVazio,
                        new String[] {"nome não pode ficar em branco"}
                ),
                Arguments.of(nomeNulo,
                        new String[] {"nome deve ser uma string"}
                ),
                Arguments.of(descricaoVazia,
                        new String[] {"descricao não pode ficar em branco"}
                ),
                Arguments.of(descricaoNula,
                        new String[] {"descricao deve ser uma string"}
                )
        );
    }

}
