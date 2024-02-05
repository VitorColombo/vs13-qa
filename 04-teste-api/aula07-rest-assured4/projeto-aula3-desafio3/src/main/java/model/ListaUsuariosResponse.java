package model;

import lombok.Data;

import java.util.List;

@Data
public class ListaUsuariosResponse extends Produto {

    private List<UsuarioResponse> usuarios;
    private String quantidade;

}
