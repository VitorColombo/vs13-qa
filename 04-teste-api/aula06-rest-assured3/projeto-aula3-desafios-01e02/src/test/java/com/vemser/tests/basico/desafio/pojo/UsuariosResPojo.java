package com.vemser.tests.basico.desafio.pojo;

public class UsuariosResPojo extends UsuariosReqPojo {

    private String message;
    private String _id;

    public UsuariosResPojo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "UsuariosResPojo{" +
                "message='" + message + '\'' +
                ", _id='" + _id + '\'' +
                '}';
    }
}
