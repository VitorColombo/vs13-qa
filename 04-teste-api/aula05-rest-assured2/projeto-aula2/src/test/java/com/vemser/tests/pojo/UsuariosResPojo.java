package com.vemser.tests.pojo;

public class UsuariosResPojo extends UsuariosReqPojo{
    private String _id;
    private String message;

    public UsuariosResPojo() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
            return "UsuariosResPojo{" +
                    "id='" + this._id + '\'' +
                    ", message='" + this.message + '\'' +
                    '}';
    }
}
