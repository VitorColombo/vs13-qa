package model;

import lombok.Data;

import java.util.List;

@Data
public class ListaProdutosResponse extends Produto {

    private List<ProdutoResponse> produtos;
    private String quantidade;

}
